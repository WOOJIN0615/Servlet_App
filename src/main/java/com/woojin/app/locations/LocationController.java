package com.woojin.app.locations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocationController
 */
@WebServlet("/LocationController")
public class LocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		LocationDAO locationDAO = new LocationDAO();
		
		String method = request.getMethod();
		String uri = request.getRequestURI();
		System.out.println(uri);
		uri=uri.substring(uri.lastIndexOf("/")+1);
		if (uri.equals("list.do")) {
				LocationDTO locationDTO = new LocationDTO();
				List<LocationDTO> list = locationDAO.getList();
				PrintWriter p = response.getWriter();
				p.println("<h1 style=text-align:center;>Location List</h1>");
				
				p.println("<table width=500 style=\"text-align: center; margin: auto;\" border=\"1\"");
				p.println("<thead style=\"font-weight: bold;\">");
				p.println("<td>"+"ADDRESS"+"</td>");
				p.println("<td>"+"ID"+"</td>");
				p.println("</thead>");
				for(int i=0; i<list.size(); i++) {
					p.println("<tbody>");
					p.println("<tr>");
					p.println("<td>"+list.get(i).getStreet_address()+"</td>");
					p.println("<td>"+list.get(i).getLocation_id()+"</td>");
					p.println("</tr>");
					p.println("</tbody>");
				}
				p.println("</table>");
			} 
		else {
			locationDAO.getDetail();
		}}
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
	}

	
}

