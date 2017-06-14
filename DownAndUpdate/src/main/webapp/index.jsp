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
        function upload(value) {

            window.location = "http://localhost:8090/servlet/jumpServlet?jspName=" +value;
        }
    </script>
</head>

<body>
<input id="upload" type="button" value="上传" onclick="upload(this.id)">
<input id="download" type="button" value="下载" onclick="upload(this.id)">
</body>
</html>