<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="wrap_left contents">
		<c:import url="../template/nav.jsp"></c:import>
		<div class="right contents_right">
			<div class="contents_right_list">
				<table class="table_sprite">
					<thead>
						<tr>
							<th>부서번호</th>
							<th>부서명</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="d" varStatus="st">
							<tr>
								<td>
									${d.department_id}
							   <%-- <h2>현재 아이템 : ${st.current}</h2>
									<h4>인덱스 번호 : ${st.index}</h4>
									<h4>순서 번호 : ${st.count}</h4>
									<h4>시작 여부 : ${st.first}</h4>
									<h4>종료 여부 : ${st.last}</h4> --%>
								</td>
								<td><a
									href="./detail.do?department_id=${d.department_id}">${d.department_name}</a>
								</td>
							</tr>
						
						</c:forEach>
						
					</tbody>
				</table>
			</div>
			<div>
				<a href="add.do">부서등록</a>
			</div>


		</div>

	</section>

	<c:import url="../template/footer.jsp"></c:import>
	
</body>
</html>