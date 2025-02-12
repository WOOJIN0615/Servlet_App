<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 추가 페이지</h1>
	
	<form action="./add.do" method="post">
		<input type="text" placeholder="부서명을 입력하세요." name="department_name"><br>
		<input type="text" placeholder="매니저코드를 입력하세요." name="manager_id"><br>
		<input type="text" placeholder="지역 코드를 입력하세요." name="location_id"><br>
		<input type="submit" value="등록">  
	</form>

</body>
</html>