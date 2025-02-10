package com.woojin.app.departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woojin.app.ActionForward;

/**
 * Servlet implementation class DepartmentController
 */

@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService departmentService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        departmentService = new DepartmentService();
    }

	/*
     * 서버 요청시
     * 1. URL(ip:port/경로)
     * 2. 메서드 형식
     * 		1) GET
     * 			* 단순 요청시
     * 			* Parameter가 주소창에 노출(Parameter가 Header에 담긴다)
     * 			* 작은 용량을 보낼 때 사용
     * 		2) POST
     * 			* 보안이 요구되는 요청 시 사용
     * 			* Parameter가 주소창에 노출이 안됨(Parameter가 Body에 담긴다)
     * 			* 큰 용량을 보낼 때 사용
     * 		
     * 3. 메서드 결정
     * 		1) 주소창에 URL을 직접 입력 - GET
     * 		2) a 태그 사용         	- GET
     * @throws UnsupportedEncodingException 
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String path = "";
		
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		ActionForward af = new ActionForward();
		af.setFlag(true);
		af.setPath("/WEB-INF/views/errors/notfound.jsp");
		
		
		try {
			switch(uri) {
			case "list.do":
				departmentService.getList(request, af);
				break;
			case "detail.do":
				departmentService.getDetail(request, af);
				break;
			case "add.do":
				String method=request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					departmentService.add(request, af);
				}else {
					af.setFlag(true);
					af.setPath("/WEB-INF/views/departments/add.jsp");
				}
				
				break;
			case "update.do":
				String m=request.getMethod();
				if (m.toUpperCase().equals("POST")) {
					departmentService.updateProcess(request, af);
				}else {
					
					departmentService.update(request, af);
					af.setFlag(true);
					af.setPath("/WEB-INF/views/departments/update.jsp");
				}
				break;
			case "delete.do":
				departmentService.delete(request, af);
				
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher(af.getPath());
		view.forward(request, response);
		
		
//		try {
//		DepartmentDAO departmentDAO = new DepartmentDAO();
//		List<DepartmentDTO> ar = departmentDAO.getList();
//		//attribute : 속성 (키:String, 값(Value):Object)
//		//
//		request.setAttribute("list", ar);
//		
//		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/departments/list.jsp");
//		view.forward(request, response);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
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
	
	private String useToken(String data) {
		StringTokenizer st = new StringTokenizer(data, "/");
		String result="";
		while(st.hasMoreTokens()) {
			result=st.nextToken();
		}
		System.out.println(result);
		return result;
	}

}
