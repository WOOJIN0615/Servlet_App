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
				<!-- contents 내용 기술 -->
				<table class="table_sprite">
					<thead>
						<tr>
							<td>상품번호</td>
							<td>상품명</td>
							<td>상세내용</td>
							<td>기간</td>
							<td>이자율</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="li">
							<tr>
								<td>${li.product_id}</td>
								<td><a href="./detail.do?product_name=${li.product_name}">${li.product_name}</a></td>
								<td>${li.product_detail}</td>
								<td>${li.product_date}</td>
								<td>${li.product_rate}</td>
							</tr>	
						</c:forEach>
					</tbody>
				</table>
			
			</div>
	
		</section>	
	
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>

</body>
</html>