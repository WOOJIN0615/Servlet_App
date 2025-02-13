package com.woojin.app.accounts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woojin.app.ActionForward;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        accountService = new AccountService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = "";
		ActionForward af = new ActionForward();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/errors/notfound.jsp");
		
		try {
			switch (uri) {
			case "list.do":
				accountService.getList(request, af);
				break;
			case "add.do":
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					accountService.join(request, af);
				}else {
					af.setFlag(true);
					af.setPath("/WEB-INF/views/accounts/add.jsp");
				}
				break;
			}
			
		}catch (Exception e) {
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
