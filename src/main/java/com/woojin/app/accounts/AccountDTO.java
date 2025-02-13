package com.woojin.app.accounts;

import java.sql.Date;

public class AccountDTO {
	private String acc_num;
	private String username;
	private Long pro_num;
	private Long acc_balance;
	private Date acc_date;
	
	public String getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getPro_num() {
		return pro_num;
	}
	public void setPro_num(Long pro_num) {
		this.pro_num = pro_num;
	}
	public Long getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(Long acc_balance) {
		this.acc_balance = acc_balance;
	}
	public Date getAcc_date() {
		return acc_date;
	}
	public void setAcc_date(Date acc_date) {
		this.acc_date = acc_date;
	}
}
