package com.zrgj.POJO;

public class Role {
	private int role_id;
	private String role_name;
	private String role_dep;
	private String role_mail;
	private String role_tele;
	private String role_username;
	private String role_password;
	private int role_status;
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_dep() {
		return role_dep;
	}
	public void setRole_dep(String role_dep) {
		this.role_dep = role_dep;
	}
	public String getRole_mail() {
		return role_mail;
	}
	public void setRole_mail(String role_mail) {
		this.role_mail = role_mail;
	}
	public String getRole_tele() {
		return role_tele;
	}
	public void setRole_tele(String role_tele) {
		this.role_tele = role_tele;
	}
	public String getRole_username() {
		return role_username;
	}
	public void setRole_username(String role_username) {
		this.role_username = role_username;
	}
	public String getRole_password() {
		return role_password;
	}
	public void setRole_password(String role_password) {
		this.role_password = role_password;
	}
	public int getRole_status() {
		return role_status;
	}
	public void setRole_status(int role_status) {
		this.role_status = role_status;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_dep=" + role_dep + ", role_mail="
				+ role_mail + ", role_tele=" + role_tele + ", role_username=" + role_username + ", role_password="
				+ role_password + ", role_status=" + role_status + "]";
	}
	
	
}
