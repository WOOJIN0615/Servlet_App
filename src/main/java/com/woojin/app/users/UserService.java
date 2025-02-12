package com.woojin.app.users;

import javax.servlet.http.HttpServletRequest;

import com.woojin.app.ActionForward;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserService() {
		this.userDAO = new UserDAO();
	}
	
	public void join(HttpServletRequest request, ActionForward af) throws Exception {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUsername(request.getParameter("username"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setName(request.getParameter("name"));
		userDTO.setPhone(request.getParameter("phone"));
		userDTO.setEmail(request.getParameter("email"));
		
		int result = userDAO.join(userDTO);
		String str = "가입 실패";
		
		if (result>0) {
			str="가입 성공";
		}
		request.setAttribute("result", str);
		request.setAttribute("path", "../index.do");
		
		af.setFlag(false);
		af.setPath("/WEB-INF/views/commons/result.jsp");
		
	}

}
