package com.woojin.app.departments;

import java.util.List;

public class DepartmentDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentDAO departmentDAO = new DepartmentDAO();
		try {
			List<DepartmentDTO> ar = departmentDAO.getList();
			System.out.println(ar.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
