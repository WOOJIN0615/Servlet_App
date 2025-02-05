package com.woojin.app.departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentController
 */

@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
		String method = request.getMethod();
		StringBuffer sb = request.getRequestURL();
		String uri = request.getRequestURI();
		
		//parameter
		String department_id=request.getParameter("department_id");
		
		
		uri=this.useToken(uri);
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
					if (uri.equals("list.do")) {
					List<DepartmentDTO> list = departmentDAO.getList();
					PrintWriter p = response.getWriter();
					p.println("<h1 style=\"text-align: center;\">department list</h1>");
					
					p.println("<table width=300 style=\"text-align: center; margin: auto;\" border=\"1\"");
					p.println("<thead style=\"font-weight: bold;\">");
					p.println("<td>"+"NAME"+"</td>");
					p.println("<td>"+"ID"+"</td>");
					p.println("<thead>");
					for(int i=0; i<list.size(); i++) {
						p.println("<tbody>");
						p.println("<tr>");
						p.println("<td>"+list.get(i).getDepartment_name()+"</td>");
						p.println("<td>"+list.get(i).getDepartment_id()+"</td>");
						p.println("</tr>");
						p.println("</tbody>");
					}
					p.println("</table>");
					p.close();
					}else {
						departmentDAO.getDetail();
					}
					}
		catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
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
