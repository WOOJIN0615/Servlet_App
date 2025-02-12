package com.woojin.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.woojin.app.utils.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class LocationDAO {
	
	public int add(LocationDTO locationDTO) throws Exception {
		int result=0;
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID)"
				+" VALUES (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, locationDTO.getStreet_address());
		ps.setString(2, locationDTO.getPostal_code());
		ps.setString(3, locationDTO.getCity());
		ps.setString(4, locationDTO.getState_province());
		ps.setString(5, locationDTO.getCountry_id());
		
		result=ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);
		
		
		
		return result;
	}
	
	//지역 정보
	public List<LocationDTO> getList() throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID DESC";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		List<LocationDTO> ar = new ArrayList<LocationDTO>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getLong("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			ar.add(locationDTO);
		}
		
		DBConnection.disConnection(rs, ps, conn);;
		return ar;
	}
	
	public LocationDTO getDetail(LocationDTO locationDTO) throws Exception {
		System.out.println("한 지역 상세 정보");
		
		Connection conn = DBConnection.getConnection();
		String sql="SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, locationDTO.getLocation_id());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			locationDTO.setLocation_id(rs.getLong("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
		}else {
			locationDTO=null;
		}
		
		DBConnection.disConnection(rs, ps, conn);
		return locationDTO;
	}

	public void getDetail() {
		// TODO Auto-generated method stub
		
	}
	
	public int update(LocationDTO locationDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE LOCATIONS SET STREET_ADDRESS=? POSTAL_CODE=? CITY=? STATE_PROVINCE=? COUNTRY_ID=? WHERE LOCATION_ID=?";
		int result=0;
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, locationDTO.getStreet_address());
		ps.setString(2, locationDTO.getPostal_code());
		ps.setString(3, locationDTO.getCity());
		ps.setString(4, locationDTO.getState_province());
		ps.setString(5, locationDTO.getCountry_id());
		ps.setLong(6, locationDTO.getLocation_id());
		
		result=ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);
		
		return result;
		
		
	}
	
}
