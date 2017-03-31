<%--
  Created by IntelliJ IDEA.
  User: Xuan
  Date: 2017/3/30
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript">
        function change() {
            var img = document.getElementById("img");
//          当一个<img>的src改变时，页面会自动刷新这个<img>
//          src属性值中的url后加个无用的时间戳参数，浏览器就用自动重新下载图片
            img.src = "VerifyServlet?b=" + new Date().getTime();

        }
    </script>
</head>
<body>
<%
    String username="";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("uname".equals(cookie.getName())) {
                username=cookie.getValue();
            }
        }
    }
%>
<%
    String message = "";
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        message = msg;
    }
%>
<span style="color: red; "><b><%=message%></b></span>
<form action="LoginServlet" method="post">
    用户名：<input type="text" name="username" value="<%=username%>"><br>
    密码：<input type="password" name="password"><br>
    验证码：<input type="text" name="code"size="3"/>
    <img id="img" src="VerifyServlet">
    <a href="javascript:change()">换一张</a><br>
    <input type="submit" name="submit" value="提交">
</form>
</body>
</html>
