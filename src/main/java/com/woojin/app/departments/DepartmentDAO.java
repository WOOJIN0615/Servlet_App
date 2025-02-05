package com.woojin.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.woojin.app.utils.DBConnection;

public class DepartmentDAO {
	
	//부서 추가
	public int add(DepartmentDTO departmentDTO) throws Exception {
		int result=0;
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+" VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, departmentDTO.getDepartment_name());
		ps.setLong(2, departmentDTO.getManager_id());
		ps.setLong(3, departmentDTO.getLocation_id());
		
		result = ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);		
		
		return result;
	}
	
	//부서 리스트
		public List<DepartmentDTO> getList() throws Exception {
			//DB에서 부서 리스트를 조회
			Connection conn = DBConnection.getConnection();
			String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID DESC";
			
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
			
			DBConnection.disConnection(rs, ps, conn);;
			return ar;
			
		}
		
		public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
			//DB에서 한 부서의 정보를 조회
			Connection conn = DBConnection.getConnection();
			String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, departmentDTO.getDepartment_id());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				departmentDTO.setDepartment_id(rs.getLong("department_id"));
				departmentDTO.setDepartment_name(rs.getString("department_name"));
				departmentDTO.setManager_id(rs.getLong("manager_id"));
				departmentDTO.setLocation_id(rs.getLong("location_id"));
			}else {
				departmentDTO=null;
			}
			DBConnection.disConnection(rs, ps, conn);
			
			return departmentDTO;
		}

		public void getDetail() {
			// TODO Auto-generated method stub
			
		}

}
