<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
		<section class="wrap_left contents">
			<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
			<div class="right contents_right">
				<!-- contents 내용 기술 -->
				<form action="update.do" method="post">
					<h2>PASSWORD : </h2><input type="password" name="password" value="${sessionScope.user.password}">
					<h2>NAME : </h2><input type="text" name="name" value="${requsetScope.user.name}">
					<h2>PHONE : </h2> <input type="text" name="phone" value="${requsetScope.user.phone}">
					<h2>EMAIL : </h2><input type="text" name="email" value="${requsetScope.user.email}">
				
					<button type="submit">수정</button>
				</div>
				
				</form>
			
			
	
		</section>	
	
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>

</body>
</html>