package com.woojin.app.employees;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woojin.app.ActionForward;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService = new EmployeeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        employeeService = new EmployeeService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("컨트롤러");
		String uri = request.getRequestURI();
		String path = "";
		
		uri=uri.substring(uri.lastIndexOf("/")+1);
		
		ActionForward af = new ActionForward();
		af.setFlag(true);
		af.setPath("/WEB-INF/views/errors/notfound.jsp");
		
		try {
			if(uri.equals("join.do")) {
				String m = request.getMethod();
				if (m.toUpperCase().equals("POST")) {
					employeeService.add(request, af);
				}else {
					af.setFlag(true);
					af.setPath("/WEB-INF/views/employees/join.jsp");
				}
			}else if (uri.equals("login.do")) {
				String m = request.getMethod();
				
				//쿠키 꺼내기
				Cookie[] cookies=request.getCookies();
				for(Cookie cookie:cookies) {
					System.out.println(cookie.getName());
					System.out.println(cookie.getValue());
				}
				
				
				if (m.toUpperCase().equals("POST")) {
					employeeService.login(request, af);
				}else {
					af.setFlag(true);
					af.setPath("/WEB-INF/views/employees/login.jsp");
				}
			}else if (uri.equals("logout.do")) {
				
				HttpSession session=request.getSession();
				//session.setAttribute("user", null);
				//session.removeAttribute("user");
				//session.removeValue("user");
				session.invalidate();
				
				af.setFlag(false);
				af.setPath("../index.do");
				
			}else if (uri.equals("mypage.do")) {
				
				employeeService.detail(request, af);
				af.setFlag(true);
				af.setPath("/WEB-INF/views/employees/mypage.jsp");
			}else if (uri.equals("update.do")) {
				
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					employeeService.update(request, af);
				}else {
					employeeService.detail(request, af);
					af.setFlag(true);
					af.setPath("/WEB-INF/views/employees/update.jsp");				
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		//응답 방식이 Forward일때
		if (af.isFlag()) {
		RequestDispatcher view = request.getRequestDispatcher(af.getPath());
		view.forward(request, response);
		}else {
			//redirect
			response.sendRedirect(af.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
