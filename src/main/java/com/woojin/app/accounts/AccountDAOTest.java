package com.woojin.app.accounts;

import java.util.ArrayList;
import java.util.List;

import com.woojin.app.users.UserDTO;

public class AccountDAOTest {
	
	public static void main(String[] args) {
		AcconutDAO acconutDAO = new AcconutDAO();
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("admin");
		List<AccountDTO> ar = new ArrayList<AccountDTO>();
		try {
			ar=acconutDAO.getList(userDTO);
			System.out.println(ar.get(0).getAcc_num());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
