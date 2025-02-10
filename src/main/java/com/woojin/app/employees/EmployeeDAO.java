package com.woojin.app.employees;

import java.sql.Connection;

import com.woojin.app.utils.DBConnection;

public class EmployeeDAO {
	
	public int add(EmployeeDTO employeeDTO) throws Exception {
		int result=0;
		Connection conn = DBConnection.getConnection();
		String sql="INSERT INTO EMPLOYEES ()";
		
		return result;
	}
	
	public void getList() {
		
	}
	
	public void getDetail() {
		
	}

}
