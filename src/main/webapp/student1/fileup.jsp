<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Insert titlehere</title>

</head>

<body>
文件上传
<%="aync return=" + new java.util.Date() %>
<!--index.html文件部分代码-->
<form action="/upLoad" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadPart">
    <input type="submit" name="upload" value="上传">
</form>
</body>
</html>