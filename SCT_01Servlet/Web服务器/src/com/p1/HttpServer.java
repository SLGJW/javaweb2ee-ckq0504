package com.p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class HttpServer extends Thread {
	// web资源根路径
	public static final String ROOT = "f:";
	// 输入流对象,读取浏览器请求
	private InputStream input;
	// 输出流对象，响应内容给浏览器
	private OutputStream out;
 
	public HttpServer(Socket socket) {
		try {
			input = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 多线程方法调用
	@Override
	public void run() {
		String filePath = read();
		response(filePath);
	}
 
	private void response(String filePath) {
		File file = new File(ROOT + filePath);
		if (file.exists()) {
			// 1、资源存在，读取资源
			try {
				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(file));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					System.out.println("line:"+ line);
					sb.append(line).append("\r\n");
				}
				StringBuffer result = new StringBuffer();
				result.append("HTTP/1.1 200 ok \r\n");
				result.append("Content-Language:zh-CN \r\n");
				result.append("Content-Type:text/html;charset=UTF-8 \r\n");
				result.append("Content-Length:" + file.length() + "\r\n");
				result.append("\r\n" + sb.toString());
				out.write(result.toString().getBytes());
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
 
		} else {
			// 2、资源不存在，提示 404 not found
			StringBuffer error = new StringBuffer();
			error.append("HTTP/1.1 400 file not found \r\n");
			error.append("Content-Type:text/html \r\n");
			error.append("Content-Length:20 \r\n").append("\r\n");
			error.append("<h1 >404 Not Found..</h1>");
			try {
				out.write(error.toString().getBytes());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
	}
 
	private String read() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		try {
			// 读取请求头， 如：GET /index.html HTTP/1.1
			String readLine = reader.readLine();
			String[] split = readLine.split(" ");
			if (split.length != 3) {
				return null;
			}
			System.out.println(readLine);
			return split[1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 
}
