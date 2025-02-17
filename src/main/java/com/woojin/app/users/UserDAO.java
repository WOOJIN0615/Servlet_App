package com.woojin.app.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.woojin.app.utils.DBConnection;

public class UserDAO {
	
	public int join(UserDTO userDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		System.out.println("dao조인");
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
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT USERNAME, PASSWORD, NAME FROM USERS WHERE USERNAME=? AND PASSWORD=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, userDTO.getUsername());
		ps.setString(2, userDTO.getPassword());
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			userDTO.setUsername(rs.getString("username"));
		}else {
			userDTO=null;
		}
		DBConnection.disConnection(rs, ps, conn);
		
		return userDTO;
	}
	
	public UserDTO detail(UserDTO userDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userDTO.getUsername());
		
		ResultSet rs = ps.executeQuery();	
		UserDTO result = null;
		
		if (rs.next()) {
			result = new UserDTO();
			result.setUsername(rs.getString("USERNAME"));
			result.setPassword(rs.getString("PASSWORD"));
			result.setName(rs.getString("NAME"));
			result.setPhone(rs.getString("PHONE"));
			result.setEmail(rs.getString("EMAIL"));
		}
		DBConnection.disConnection(rs, ps, conn);
		
		return result;
	}
	
	public int update(UserDTO userDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE USERS SET PASSWORD=?, NAME=?, PHONE=?, EMAIL=? WHERE USERNAME=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		System.out.println("dao업데이트");
		ps.setString(1, userDTO.getPassword());
		ps.setString(2, userDTO.getName());
		ps.setString(3, userDTO.getPhone());
		ps.setString(4, userDTO.getEmail());
		ps.setString(5, userDTO.getUsername());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);
		
		return result;
	}

}
