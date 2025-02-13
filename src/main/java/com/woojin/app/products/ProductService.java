package com.woojin.app.products;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.woojin.app.ActionForward;

public class ProductService {
	
	private ProductDAO productDAO;
	
	public ProductService() {
		productDAO = new ProductDAO();
	}
	
	public ActionForward getList(HttpServletRequest request, ActionForward af) throws Exception {
		List<ProductDTO> ar = productDAO.getList();
		request.setAttribute("list", ar);
		af.setFlag(true);
		af.setPath("/WEB-INF/views/products/list.jsp");
		
		return af;
	}
	
	public ActionForward getDetail(HttpServletRequest request, ActionForward af) throws Exception {
		String name = request.getParameter("product_name");
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_name(name);
		productDTO = productDAO.getDetail(productDTO);
		
		af.setFlag(true);
		af.setPath("/WEB-INF/views/products/detail.jsp");
		
		return af;
	}
	
	public void add(HttpServletRequest request, ActionForward af) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_name(request.getParameter("product_name"));
		productDTO.setProduct_detail(request.getParameter("product_detail"));
		productDTO.setProduct_rate(Long.parseLong(request.getParameter("product_rate")));
		
		int result = productDAO.add(productDTO);
		String str = "상품 추가 성공";
		if (result >0) {
			str = "상품 추가 실패";
		}
		request.setAttribute("result", str);
		request.setAttribute("path", "./list.do");
		af.setFlag(true);
		af.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
}
