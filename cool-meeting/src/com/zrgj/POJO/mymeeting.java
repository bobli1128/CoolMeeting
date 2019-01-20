package com.zrgj.POJO;

import java.sql.Timestamp;

public class mymeeting {
	private int meeting_id;
	private int role_id;
    private String meeting_name;
    private String room_name;
    private Timestamp starttime;
    private Timestamp endtime;
    private Timestamp booktime;
    private String role_name;
    private int meeting_state;
    private String meeting_notes;
    
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
	public String getMeeting_name() {
		return meeting_name;
	}
	public void setMeeting_name(String meeting_name) {
		this.meeting_name = meeting_name;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp time) {
		this.starttime = time;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp time) {
		this.endtime = time;
	}
	public Timestamp getBooktime() {
		return booktime;
	}
	public void setBooktime(Timestamp time) {
		this.booktime = time;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	public int getMeeting_state() {
		return meeting_state;
	}
	public void setMeeting_state(int meeting_state) {
		this.meeting_state = meeting_state;
	}
	
	public String getMeeting_notes() {
		return meeting_notes;
	}
	public void setMeeting_notes(String meeting_notes) {
		this.meeting_notes = meeting_notes;
	}
	@Override
	public String toString() {
		return "mymeeting [meeting_id=" + meeting_id + ", role_id=" + role_id + ", meeting_name=" + meeting_name
				+ ", room_name=" + room_name + ", starttime=" + starttime + ", endtime=" + endtime + ", booktime="
				+ booktime + ", role_name=" + role_name + ", meeting_state=" + meeting_state + ", meeting_notes="
				+ meeting_notes + "]";
	}
	
}
