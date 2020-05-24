<%@ page import="com.school.util.MyUtil" %>
<%@ page import="com.school.domain.Student" %>
<%@ page import="com.school.dao.DAOFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生信息</title>
</head>
<script>

    <%
    request.setCharacterEncoding("utf-8");
    String Sid = request.getParameter("delete");
    int sid = MyUtil.toInt(Sid);
    Student student = MyUtil.getStudent(sid);
    %>
    onload = function () {
        var flag = confirm("是否删除学号为<%=student.getSid()%>，姓名为：<%=student.getSname()%>的学生信息？")
        if(flag==true){
            var form =document.getElementById("form");
            form.submit();
        }
    }
</script>
<body>
<form id="form" action="/stu59/deletestudent" method="post">
    <input type="hidden" name="sid" value="<%=student.getSid()%>">
</form>
</body>
</html>
