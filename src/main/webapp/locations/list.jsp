<%@page import="com.woojin.app.locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.woojin.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	LocationDAO locationDAO = new LocationDAO();
    	List<LocationDTO> ar=locationDAO.getList();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 40%;
		margin: 0 auto;
	}
	
</style>
</head>
<body>
	<h1>Locations List</h1>
	<table style="text-align: center;" border=1>
		<thead>
			<tr>
				<td>주소</td>
				<td>ID</td>
			</tr>
		</thead>
		<%for(int i=0; i<ar.size(); i++) { %>
		<tbody>
			<tr>
				<td>
					<%=ar.get(i).getLocation_id() %>
				</td>
				<td>
					<a href="detail.jsp?location_id=<%= ar.get(i).getLocation_id()%>"><%= ar.get(i).getStreet_address() %></a>
				</td>
			</tr>
		</tbody>
		<%} %>
	
	</table>
	
	<div>
		<a href="add.jsp">위치 등록</a>
	</div>

</body>
</html>