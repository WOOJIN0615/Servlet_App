package com.woojin.app.users;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.woojin.app.utils.DBConnection;

public class UserDAO {
	
	public int join(UserDTO userDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, userDTO.getUsername());
		ps.setString(2, userDTO.getPassword());
		ps.setString(3, userDTO.getName());
		ps.setString(4, userDTO.getPhone());
		ps.setString(5, userDTO.getEmail());
		
		int result=ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);
		
		return result;	
		
	}
	
	public void login() {
		
	}
	
	public void detail() {
		
	}
	
	public void update() {
		
	}

}
