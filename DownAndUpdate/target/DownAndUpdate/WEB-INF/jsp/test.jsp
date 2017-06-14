<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<title>下载文件显示页面</title>
<head>
    <script type="text/javascript" src="http://localhost:8090/js/jquery/jquery-1.7.1.js" ></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<!-- 遍历Map集合 -->
<c:forEach var="me" items="${fileNameMap}">
    <c:url value="http://localhost:8090/servlet/ListFileServlet" var="downurl">
        <c:param name="filename" value="${me.key}"></c:param>
    </c:url>
    ${me.value}<a href="${downurl}">下载</a>
    <br/>
</c:forEach>
</body>
</html>