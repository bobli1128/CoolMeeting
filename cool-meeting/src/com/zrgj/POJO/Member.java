package com.zrgj.POJO;

public class Member {
	private int id;
	private int role_id;
	private int meeting_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", role_id=" + role_id + ", meeting_id=" + meeting_id + "]";
	}
	

}
