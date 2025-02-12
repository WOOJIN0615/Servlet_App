<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 등록 페이지</h1>
	<!-- 도로명, 우편번호, 도시명, 시/도, 나라코드 -->
	<form action="./join.do" method="post">
		<input type="text" name="first_name" placeholder="성을 입력하세요."><br>
		<input type="text" name="last_name" placeholder="이름을 입력하세요."><br>
		<input type="text" name="email" placeholder="이메일을 입력하세요"><br>
		<input type="text" name="phone_number" placeholder="핸드폰번호를 입력하세요."><br>
		<input type="text" name="job_id" placeholder="직책을 입력하세요."><br>
		<input type="text" name="salary" placeholder="월급을 입력하세요."><br>
		<input type="text" name="commission_pct" placeholder="보너스를 입력하세요."><br>
		<input type="text" name="manager_id" placeholder="담당부서 관리자코드를 입력하세요"><br>
		<input type="text" name="department_id" placeholder="부서코드를 입력하세요."><br>
		<input type="password" name="password" placeholder="비밀번호를 입력하세요."><br>
		<input type="submit" value="등록">
		
	</form>

</body>
</html>