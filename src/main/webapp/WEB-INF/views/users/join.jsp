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
				   <h1 style="text-align: center">회원가입</h1>
					<form action="./join.do" method="post" style="text-align: center">
						<input type="text" name="username" placeholder="ID를 입력하세요" style="width: 246px; text-align: center"><br><br>
						<input type="text" name="password" placeholder="비밀번호를 입력하세요" style="width: 246px; text-align: center"><br><br>
						<input type="text" name="name" placeholder="이름을 입력하세요" style="width: 246px; text-align: center"><br><br>
						<input type="text" name="phone" placeholder="휴대폰번호를 입력하세요" style="width: 246px; text-align: center"><br><br>
						<input type="text" name="email" placeholder="이메일을 입력하세요" style="width: 246px; text-align: center"><br><br>
						<input type="submit" value="가입">
					</form>
			</div>
	
		</section>	
	
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>

</body>
</html>