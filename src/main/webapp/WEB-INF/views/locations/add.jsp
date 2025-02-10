<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>위치 추가 페이지</h1>
	<!-- 도로명, 우편번호, 도시명, 시/도, 나라코드 -->
	<form action="./addProcess.jsp" method="post">
		<input type="text" name="street_address" placeholder="도로명을 입력하세요."><br>
		<input type="text" name="postal_code" placeholder="우편번호를 입력하세요."><br>
		<input type="text" name="city" placeholder="도시명을 입력하세요"><br>
		<input type="text" name="state_province" placeholder="시/도명을 입력하세요."><br>
		<input type="text" name="country_id" placeholder="나라코드를 입력하세요."><br>
		<input type="submit" value="등록">
		
	</form>

</body>
</html>