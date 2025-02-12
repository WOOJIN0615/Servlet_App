package com.woojin.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.woojin.app.utils.DBConnection;

public class EmployeeDAO {
	
	public int update (EmployeeDTO employeeDTO) throws Exception {
		int result=0;
		Connection conn = DBConnection.getConnection();
		String sql ="UPDATE EMPLOYEES SET FIRST_NAME=?, LAST_NAME=? WHERE EMPLOYEE_ID=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, employeeDTO.getFirst_name());
		ps.setString(2, employeeDTO.getLast_name());
		ps.setLong(3, employeeDTO.getEmployee_id());
		
		result = ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);		
		
		return result;
	}
	
	public EmployeeDTO detail(EmployeeDTO employeeDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, employeeDTO.getEmployee_id());
		
		ResultSet rs = ps.executeQuery();
		EmployeeDTO result = null;
		
		if (rs.next()) {
			result=new EmployeeDTO();
			result.setLast_name(rs.getString("LAST_NAME"));
			result.setEmail(rs.getString("EMAIL"));
			result.setJob_id(rs.getString("JOB_ID"));
			result.setHire_date(rs.getDate("HIRE_DATE"));
			result.setSalary(rs.getDouble("SALARY"));
			result.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			result.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
			result.setManager_id(rs.getLong("MANAGER_ID"));
			result.setPhone_number(rs.getString("PHONE_NUMBER"));
		}
		
		DBConnection.disConnection(rs, ps, conn);
		
		return result;
	}
	
	public EmployeeDTO login(EmployeeDTO employeeDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT EMPLOYEE_ID, PASSWORD, FIRST_NAME FROM EMPLOYEES"
				+ " WHERE EMPLOYEE_ID=? AND PASSWORD=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setLong(1, employeeDTO.getEmployee_id());
		ps.setString(2, employeeDTO.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
		}else {
			employeeDTO=null;
		}
		
		DBConnection.disConnection(rs, ps, conn);
		
		return employeeDTO;
	}
	
	public int add(EmployeeDTO employeeDTO) throws Exception {
		int result=0;
		Connection conn = DBConnection.getConnection();
		String sql="INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID, PASSWORD)"
					+" VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, employeeDTO.getFirst_name());
		ps.setString(2, employeeDTO.getLast_name());
		ps.setString(3, employeeDTO.getEmail());
		ps.setString(4, employeeDTO.getPhone_number());
		ps.setString(5, employeeDTO.getJob_id());
		ps.setDouble(6, employeeDTO.getSalary());
		ps.setDouble(7, employeeDTO.getCommission_pct());
		ps.setLong(8, employeeDTO.getManager_id());
		ps.setLong(9, employeeDTO.getDepartment_id());
		ps.setString(10, employeeDTO.getPassword());
		
		result=ps.executeUpdate();
		DBConnection.disConnection(ps, conn);
		
		return result;
	}

}
