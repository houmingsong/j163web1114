package com.lovo.j163web1114.bean;

public class UserBean {
	private String ussername;
	private String password;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(String ussername, String password) {
		super();
		this.ussername = ussername;
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBean [ussername=" + ussername + ", password=" + password + "]";
	}
	public String getUssername() {
		return ussername;
	}
	public void setUssername(String ussername) {
		this.ussername = ussername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
