package com.woojin.app.locations;

import java.util.List;

public class LocationDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocationDTO locationDTO = new LocationDTO();
		LocationDAO locationDAO = new LocationDAO();
		
		try {
			List<LocationDTO> test = locationDAO.getList();
			System.out.println(test.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
