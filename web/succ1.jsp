<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2017/3/30
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>succ1</title>
</head>
<body>
<%
    String msg = (String) session.getAttribute("username");
    if (msg == null) {
        request.setAttribute("msg", "未登录");
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return;
    }
%>
<h1>Welcome <%=msg%>用户</h1>

</body>
</html>
