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
				<h1>부서 추가 페이지</h1>
	
	<form action="./add.do" method="post">
		<input type="text" placeholder="계좌번호를 입력하세요." name="account_num"><br>
		<input type="submit" value="등록">  
	</form>
			
			</div>
	
		</section>	
	
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>

</body>
</html>