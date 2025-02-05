<%@page import="com.woojin.app.locations.LocationDTO"%>
<%@page import="com.woojin.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	LocationDAO locationDAO = new LocationDAO();
    	LocationDTO locationDTO = new LocationDTO();
    	String location_id = request.getParameter("location_id");
    	locationDTO.setLocation_id(Long.parseLong(location_id));
    	locationDTO=locationDAO.getDetail(locationDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Location Detail Page</h1>
	
	<%if(locationDTO!=null){ %>
		<h3><%=locationDTO.getLocation_id() %></h3>
		<h3><%=locationDTO.getStreet_address() %></h3>
		<h3><%=locationDTO.getState_province() %></h3>
	<%}else { %>
		존재하지 않는 위치입니다.
	<%} %>

</body>
</html>