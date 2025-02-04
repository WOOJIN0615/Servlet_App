package com.woojin.app.tests.connection;

import java.sql.Connection;

import com.woojin.app.utils.DBConnection;

public class DBConnectionTest {
	
	
		
		public void DBConnectionTest() throws Exception {
			 Connection con = DBConnection.getConnection();
			 
			 if(con != null) {
				 System.out.println("테스트 통과");
			 }else {
				 System.out.println("테스트 실패");
			 }
			
		}
		
	
	

}
