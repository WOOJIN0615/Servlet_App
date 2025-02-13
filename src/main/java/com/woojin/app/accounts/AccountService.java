package com.woojin.app.accounts;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.woojin.app.ActionForward;

public class AccountService {
	
	private AcconutDAO acconutDAO;
	
	public AccountService() {
		this.acconutDAO=new AcconutDAO();
	}
	
	public void join(HttpServletRequest request, ActionForward af) throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAcc_num(request.getParameter("ACCOUNT_NUM"));

		int result = acconutDAO.join(accountDTO);
		String str = "계좌 생성 실패";
		if (result>0) {
			str = "계좌 생성 성공";
		}
		
		request.setAttribute("result", str);
		request.setAttribute("path", "./list.do");
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/commons/result.do");
		
	}
	
	public void getList(HttpServletRequest request, ActionForward af) throws Exception {
		List<AccountDTO> ar = new ArrayList<AccountDTO>();
		request.setAttribute("list", ar);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/accounts.list.do");
		
	}
}
