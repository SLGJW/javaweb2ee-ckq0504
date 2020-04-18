
package com.school.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String tel = request.getParameter("tel");
		String bir = request.getParameter("bir");
		String name = request.getParameter("name");

		PrintWriter out = response.getWriter();

		out.println("<html>");

		out.println("<head><title>个人信息</title></head>");

		out.println("<body>");
		out.println("学号:" + tel + "</br>");
		out.println("生日:" + bir + "</br>");
		out.println("姓名:" + name + "</br>");
		String[] sex = request.getParameterValues("sex");
		for (String string1 : sex) {

			out.println("性别:" +string1+ "</br>");
		}

		String[] active = request.getParameterValues("active");

		out.println("爱好:" +"</br>");
		for (String string : active) {
			out.println( string);

		}

		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
