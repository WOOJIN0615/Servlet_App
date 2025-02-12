package com.woojin.app.locations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.woojin.app.ActionForward;

public class LocationService {
	
	private LocationDAO locationDAO;
	
	public LocationService() {
		this.locationDAO = new LocationDAO();
	}
	
	public ActionForward getList(HttpServletRequest request, ActionForward af) throws Exception {
		List<LocationDTO> ar = locationDAO.getList();
		request.setAttribute("list", ar);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/locations/list.jsp");
		
		return af;
	}
	
	public ActionForward getDetail(HttpServletRequest request, ActionForward af) throws Exception {
		String id = request.getParameter("location_id");
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Long.parseLong(id));
		locationDTO=locationDAO.getDetail(locationDTO);
		
		request.setAttribute("dto", locationDTO);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/locations/detail.jsp");
		
		return af;
	}
	
	public void add(HttpServletRequest request, ActionForward af) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		String address=request.getParameter("street_address");
		String postal=request.getParameter("postal_code");
		String city=request.getParameter("city");
		String state=request.getParameter("state_province");
		String country=request.getParameter("country_id");
		locationDTO.setStreet_address(address);
		locationDTO.setPostal_code(postal);
		locationDTO.setCity(city);
		locationDTO.setState_province(state);
		locationDTO.setCountry_id(country);
		
		int result = locationDAO.add(locationDTO);
		String str="위치 등록 실패";
		if (result>0) {
			str="위치 등록 성공";
		}
		request.setAttribute("result", str);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/commons/result.jsp");
		
		
	}
	
	//1. DB에서 수정할 데이터 조회
	public void update(HttpServletRequest request, ActionForward af) throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Long.parseLong(request.getParameter("location_id")));
		locationDTO=locationDAO.getDetail(locationDTO);
		request.setAttribute("dto", locationDTO);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/locations/update.jsp");
		
	}
	
	//2. 데이터 수정
	public void updateProcess(HttpServletRequest request, ActionForward af) throws Exception{
		String id = request.getParameter("location_id");
		String address = request.getParameter("street_address");
		String code = request.getParameter("postal_code");
		String city = request.getParameter("city");
		String state = request.getParameter("state_province");
		String country = request.getParameter("country_id");
		
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Long.parseLong(id));
		locationDTO.setStreet_address(address);
		locationDTO.setPostal_code(code);
		locationDTO.setCity(city);
		locationDTO.setState_province(state);
		locationDTO.setCountry_id(country);
		
		int result = locationDAO.update(locationDTO);
		
		String str="위치 수정 실패";
		if (result>0) {
			str="위치 수정 성공";
		}
		request.setAttribute(str, locationDTO);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/commons/result.jsp");
	}

}
