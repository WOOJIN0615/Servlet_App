package com.woojin.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.woojin.app.utils.DBConnection;

public class LocationDAO {
	
	//지역 정보
	public List<LocationDTO> getList() throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		List<LocationDTO> ar = new ArrayList<LocationDTO>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getLong("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			ar.add(locationDTO);
		}
		
		DBConnection.disConnection(ps, conn, rs);
		return ar;
	}
	
	public void getDetail() {
		System.out.println("한 지역 상세 정보");
	}
	
}
