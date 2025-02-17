package com.woojin.app.accounts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.woojin.app.ActionForward;
import com.woojin.app.users.UserDTO;

public class AccountService {
	
	private AcconutDAO accountDAO;
	private UserDTO userDTO;
	
	public AccountService() {
		this.accountDAO=new AcconutDAO();
		this.userDTO = new UserDTO();
	}
	
	public ActionForward getList(HttpServletRequest request, ActionForward af) throws Exception {
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		
		List<AccountDTO> ar = accountDAO.getList(userDTO);
		request.setAttribute("list", accountDAO.getList(userDTO));
		af.setFlag(true);
		af.setPath("/WEB-INF/views/accounts/list.jsp");
		
		return af;
		
	}
}
