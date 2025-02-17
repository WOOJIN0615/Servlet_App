package com.woojin.app.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woojin.app.ActionForward;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/")+1);
		ActionForward af = new ActionForward();
		af.setFlag(true);
		af.setPath("WEB-INF/views/errors/notfound.jsp");
		
		try {
			switch(uri) {
			case "list.do":
				productService.getList(request, af);
				break;
			case "detail.do":
				productService.getDetail(request, af);
				break;
			case "update.do":
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(af.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(af.getPath());
			view.forward(request, response);		
		}else {
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
