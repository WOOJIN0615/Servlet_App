package com.woojin.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.woojin.app.ActionForward;
import com.woojin.app.utils.DBConnection;

public class ProductDAO {
	
	public List<ProductDTO> getList()throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCT_ID DESC";
		PreparedStatement ps = conn.prepareStatement(sql);
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_id(rs.getLong("product_id"));
			productDTO.setProduct_name(rs.getString("product_name"));
			productDTO.setProduct_detail(rs.getString("product_detail"));
			productDTO.setProduct_date(rs.getDate("product_date"));
			productDTO.setProduct_rate(rs.getLong("product_rate"));
			
			ar.add(productDTO);
		}
		
		DBConnection.disConnection(rs, ps, conn);
		
		return ar;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCT_NAME=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, productDTO.getProduct_name());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			productDTO.setProduct_id(rs.getLong("product_id"));
			productDTO.setProduct_name(rs.getString("product_name"));
			productDTO.setProduct_detail(rs.getString("product_detail"));
			productDTO.setProduct_date(rs.getDate("product_date"));
			productDTO.setProduct_rate(rs.getLong("product_rate"));
		}else {
			productDTO=null;
		}
		
		DBConnection.disConnection(rs, ps, conn);
		
		return productDTO;
		
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, PRODUCT_DETAIL, PRODUCT_DATE, PRODUCT_RATE)"
				+" VALUES (PRODUCTNUM_SEQ.NEXTVAL, ?, ?, SYSDATE, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, productDTO.getProduct_name());
		ps.setString(2, productDTO.getProduct_detail());
		ps.setLong(3, productDTO.getProduct_rate());
		
		int result=ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);
		
		return result;
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		Connection conn = DBConnection.getConnection();
		
		String sql = "UPDATE PRODUCTS SET PRODUCT_NAME=?, PRODUCT_DETAIL=?, PRODUCT_DATE=?, PRODUCT_RATE=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, productDTO.getProduct_name());
		ps.setString(2, productDTO.getProduct_detail());
		ps.setDate(3, productDTO.getProduct_date());
		ps.setLong(4, productDTO.getProduct_rate());
		
		int result = ps.executeUpdate();
		
		DBConnection.disConnection(ps, conn);
		
		return result;
		
	}

}
