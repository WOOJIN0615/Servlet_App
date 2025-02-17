package com.woojin.app.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.Action;

import com.woojin.app.ActionForward;

public class UserService {
	
	private UserDAO userDAO;
	
	public UserService() {
		this.userDAO = new UserDAO();
	}
	
	public void update(HttpServletRequest request, ActionForward af) throws Exception {
		UserDTO session = (UserDTO)request.getSession().getAttribute("user");
		UserDTO userDTO = new UserDTO();
		System.out.println("서비스업데이트");
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setName(request.getParameter("name"));
		userDTO.setPhone(request.getParameter("phone"));
		userDTO.setEmail(request.getParameter("email"));
		userDTO.setUsername(session.getUsername());  
		
		int result = userDAO.update(userDTO);
		
		if (result>0) {
			session.setPassword(userDTO.getPassword());
		}
		
		af.setFlag(false);
		af.setPath("./mypage.do");
		
	}
	
	public void join(HttpServletRequest request, ActionForward af) throws Exception {
		UserDTO userDTO = new UserDTO();
		System.out.println("서비스조인");
		
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
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	public void detail(HttpServletRequest request, ActionForward af) throws Exception {
		
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		//System.out.println(userDTO);
		UserDTO result = userDAO.detail(userDTO);
		request.setAttribute("user", result);
		
	}
	
	public void login(HttpServletRequest request, ActionForward af) throws Exception {
		//DTO 객체 생성
		//파라미터로 입력한 값 DTO에 넣기
		//DAO로 로그인 불러오기
		//로그인 성공했다면 > redirect로 메인화면 이동
		//로그인 실패했다면 > result.jsp이용 실패창 노출 후 로그인 창 이동
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(request.getParameter("username"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO=userDAO.login(userDTO);
		
		if (userDTO!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userDTO);
			af.setFlag(false);
			af.setPath("../index.do");
		}else {
			request.setAttribute("result", "로그인 실패");
			request.setAttribute("path", "login.do");
			af.setFlag(true);
			af.setPath("/WEB-INF/views/users/login.jsp");
		}
	}

}
