<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
		<section class="wrap_left contents">
			<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
			<div class="right contents_right">
				<table class="table_sprite">
					<thead>
						<tr>
							<th>계좌번호</th>
							<th>상품번호</th>
							<th>잔액</th>
							<th>가입일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="d">
							<tr>
								<td>${d.acc_num}</td>
								<td>${d.pro_num}</td>
								<td>${d.acc_balance}</td>
								<td>${d.acc_date}</td>
							</tr>
						
						</c:forEach>
						
					</tbody>
				</table>
			
			</div>
	
		</section>	
	
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>

</body>
</html>