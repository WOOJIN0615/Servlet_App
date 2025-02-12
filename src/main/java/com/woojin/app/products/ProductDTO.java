package com.woojin.app.products;

import java.sql.Date;

public class ProductDTO {
	private Long product_id;
	private String product_name;
	private String product_detail;
	private Date product_date;
	private Long product_rate;
	
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_detail() {
		return product_detail;
	}
	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}
	public Date getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
	public Long getProduct_rate() {
		return product_rate;
	}
	public void setProduct_rate(Long product_rate) {
		this.product_rate = product_rate;
	}
}
