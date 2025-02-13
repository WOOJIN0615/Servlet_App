package com.woojin.app.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woojin.app.ActionForward;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        userService = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		ActionForward af = new ActionForward();
		
		uri=uri.substring(uri.lastIndexOf("/")+1);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/errors/notfound.jsp");
		System.out.println("컨트롤러조인");
		try {
			switch(uri) {
			case "join.do":
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					userService.join(request, af);
				}else {
					af.setFlag(true);
					af.setPath("/WEB-INF/views/users/join.jsp");
				}
				break;
			case "mypage.do" :
				userService.detail(request, af);
				af.setFlag(true);
				af.setPath("/WEB-INF/views/users/mypage.jsp");
				break;
			case "login.do" :
				//getmethod로 변수 생성
				//쿠키 꺼내기(배열을 이용하여 향상 for문을 사욯해 쿠키의 키값과 밸류값 프린트)
				//변수를 대문자로 변환한 값이 POST와 같다면 > service의 로그인로직 실행
				//아니라면 > forword 이용하여 로그인.jsp로 이동
				String m = request.getMethod();
				
				if (m.toUpperCase().equals("POST")) {
					userService.login(request, af);
				}else {
					af.setFlag(true);
					af.setPath("/WEB-INF/views/users/login.jsp");
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher(af.getPath());
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String method = request.getMethod();
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
	}

}
