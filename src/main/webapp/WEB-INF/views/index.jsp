<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<%@ include file="./template/common.jsp" %>
</head>
<body>
	<%@ include file="./template/header.jsp" %>
	<section class="wrap_left contents">
		<%@ include file="./template/nav.jsp" %>
		<div class="right contents_right"></div>
	</section>
	
	<%@ include file="./template/footer.jsp" %>
	
	<h1>Home Page</h1>
	<a href="./departments/list.jsp">Department List</a><p>
	<a href="./locations/list.jsp">Location List</a>

</body>
</html>