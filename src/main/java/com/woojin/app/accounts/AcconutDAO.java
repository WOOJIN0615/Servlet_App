package com.woojin.app.accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.woojin.app.utils.DBConnection;

public class AcconutDAO {
	
	public int join(AccountDTO accountDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO ACCOUNTS (ACCOUNT_NUM, ACCOUNT_BAL, ACCOUNT_DATE) VALUES (?, 0, SYSDATE)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, accountDTO.getAcc_num());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);
		
		return result;
	}
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM ACCOUNTS WHERE USERNAME=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		List<AccountDTO> ar = new ArrayList<AccountDTO>();
		
		ps.setString(1, accountDTO.getUsername());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			accountDTO.setAcc_num(rs.getString("ACCOUNT_NUM"));
			accountDTO.setPro_num(rs.getLong("PRODUCT_NUM"));
			accountDTO.setAcc_balance(rs.getLong("ACCOUNT_BAL"));
			accountDTO.setAcc_date(rs.getDate("ACCOUNT_DATE"));
			
			ar.add(accountDTO);
		}
		
		DBConnection.disConnection(rs, ps, conn);
		
		return ar;
	}

}
