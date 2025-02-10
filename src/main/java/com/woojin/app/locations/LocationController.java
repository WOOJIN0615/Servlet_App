package com.woojin.app.locations;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class LocationController
 */
@WebServlet("/LocationController")
public class LocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationService locationService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationController() {
        super();
        locationService = new LocationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String path="";
		uri=uri.substring(uri.lastIndexOf("/")+1);
		ActionForward af = new ActionForward();
		af.setFlag(true);
		af.setPath("/WEB-INF/views/errors/notfound.jsp");
		try {
			switch(uri) {
			case "list.do":
				locationService.getList(request, af);
				break;
				
			case "detail.do":
				locationService.getDetail(request, af);
				break;
			}
			
		
			
		}
		catch (Exception e) {
				// TODO Auto-generated catch block
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

