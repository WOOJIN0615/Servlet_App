package com.woojin.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.woojin.app.utils.DBConnection;

public class DepartmentDAO {
	
	//부서 리스트
		public List<DepartmentDTO> getList() throws Exception {
			//DB에서 부서 리스트를 조회
			Connection conn = DBConnection.getConnection();
			String sql = "SELECT * FROM DEPARTMENTS";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartment_id(rs.getLong("department_id"));
				departmentDTO.setDepartment_name(rs.getString("department_name"));
				departmentDTO.setManager_id(rs.getLong("manager_id"));
				departmentDTO.setLocation_id(rs.getLong("location_id"));
				ar.add(departmentDTO);
			}    
			
			DBConnection.disConnection(ps, conn, rs);
			return ar;
			
		}
		
		public void getDetail() throws Exception {
			//DB에서 한 부서의 정보를 조회
			Connection conn = DBConnection.getConnection();
			String sql = "SELECT * FROM DEPARTMENTS WHERE ";
		}

}
