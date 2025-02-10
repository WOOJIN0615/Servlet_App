<%@page import="com.woojin.app.departments.DepartmentDTO"%>
<%@page import="com.woojin.app.locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.woojin.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Object ar = request.getAttribute("list");
	List<LocationDTO> list = (List<LocationDTO>)ar;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/common.jsp"%>
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<%@ include file="../template/header.jsp"%>
	<section class="wrap_left contents">
		<%@ include file="../template/nav.jsp"%>
		<div class="right contents_right">
			<div class="contents_right_list">
				<table class="table_sprite">
					<thead>
						<tr>
							<th>주소</th>
							<th>ID</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < list.size(); i++) {
						%>
						<tr>
							<td><%=list.get(i).getLocation_id()%></td>
							<td><a
								href="./detail.do?location_id=<%=list.get(i).getLocation_id()%>"><%=list.get(i).getStreet_address()%></a>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<div>
				<a href="add.do">위치등록</a>
			</div>


		</div>

	</section>

	<%@ include file="../template/footer.jsp"%>



</body>
</html>