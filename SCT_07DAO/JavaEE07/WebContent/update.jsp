<%@ page import="com.school.dao.StudentDao" %>
<%@ page import="com.school.dao.DAOFactory" %>
<%@ page import="com.school.domain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String sid = request.getParameter("sid");
    Student student = null;
    StudentDao sd = DAOFactory.getStudentDaoInstance();
    student = sd.findBySid(sid);
    if(student!=null){
%>
<div style="text-align: left;">
    <h2>学生信息修改</h2>
    <form action="/stu59/updateresult.jsp" method="get">
        学号：<input class="inp2" type="text" name="ssid" value="<%=student.getSid()%>" disabled/><br/><br/>
                    <input type="hidden" name="sid" value="<%=student.getSid()%>">
        姓名：<input class="inp2" type="text" value="<%=student.getSname()%>" name="sname"/><br/><br/>
        生日：<input class="inp2" type="date" value="<%=student.getSbirthday().toString()%>" name="sbirthday"/><br/><br/>
        <%if("男".equals(student.getSsex())){%>
        性别：男<input type="radio" name="ssex" value="男" checked/>
        女：<input type="radio" name="ssex" value="女"/><br/><br/>
        <%}else{%>
        性别：男<input type="radio" name="ssex" value="男"/>
        女<input type="radio" name="ssex" value="女" checked/><br/><br/>
        <%}%>
        <input type="reset" value="重置"/>
        <input type="submit" value="提交"/>
    </form>
</div>
<%}%>
</body>
</html>
