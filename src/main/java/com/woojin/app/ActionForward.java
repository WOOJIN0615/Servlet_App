package com.woojin.app;

public class ActionForward {
	//true: forward, false: redirect
	
	private boolean flag;
	
	//forward의 경우 jsp의 경로 또는 redirect의 경우 url 경로 작성
	private String path;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	

}
