<%--
  Created by IntelliJ IDEA.
  User: notreami
  Date: 15/12/29
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'fragmentB.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<%=basePath%>
这是在fragmentB.jar中的jsp文件
<br> 这个图片文件同样来自该模块的jar
<img alt="hp" src="<%=basePath%>themes/images/hp.gif">
跳转到fragmentA.jar中的
<a href="<%=basePath%>fragmentA.jsp">fragmentA.jsp</a>
<br>
<img alt="hp" src="<%=basePath%>themes/images/hp.gif">
<br/>
<jsp:include page="fragmentA.jsp"/>
</body>
</html>
