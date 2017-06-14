<%--
  Created by IntelliJ IDEA.
  User: huangwei
  Date: 2017/6/7
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<title>文件上传</title>
<head>
    <script type="text/javascript" src="http://localhost:8090/js/jquery/jquery-1.7.1.js"></script>
    <script type="text/javascript">


    </script>
</head>

<body>
<form action="http://localhost:8090/servlet/UploadHandleServlet" enctype="multipart/form-data" method="post">
    上传用户：<input type="text" name="username"><br/>
    上传文件1：<input type="file" name="file1"><br/>
    上传文件2：<input type="file" name="file2"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>