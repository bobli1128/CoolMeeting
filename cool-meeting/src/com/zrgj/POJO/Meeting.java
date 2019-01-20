package com.zrgj.POJO;

/*import java.sql.Date;*/
import java.sql.Timestamp;

public class Meeting {
    private int meeting_id;
    private int room_id;
    private Timestamp startime;
    private Timestamp endtime;
    private Timestamp booktime;
    private int meeting_state;
    private int meeting_number;
    private int role_id;
    private String meeting_name;
    private String meeting_notes;
    private String meeting_reason;
    private String room_name;
    private String roomname;
    private String rolename;
    private String state;
	public int getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public Timestamp getStartime() {
		return startime;
	}
	public void setStartime(Timestamp startime) {
		this.startime = startime;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	public Timestamp getBooktime() {
		return booktime;
	}
	public void setBooktime(Timestamp booktime) {
		this.booktime = booktime;
	}
	public int getMeeting_state() {
		return meeting_state;
	}
	public void setMeeting_state(int meeting_state) {
		this.meeting_state = meeting_state;
	}
	public int getMeeting_number() {
		return meeting_number;
	}
	public void setMeeting_number(int meeting_number) {
		this.meeting_number = meeting_number;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getMeeting_name() {
		return meeting_name;
	}
	public void setMeeting_name(String meeting_name) {
		this.meeting_name = meeting_name;
	}
	public String getMeeting_notes() {
		return meeting_notes;
	}
	public void setMeeting_notes(String meeting_notes) {
		this.meeting_notes = meeting_notes;
	}
	public String getMeeting_reason() {
		return meeting_reason;
	}
	public void setMeeting_reason(String meeting_reason) {
		this.meeting_reason = meeting_reason;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Meeting [meeting_id=" + meeting_id + ", room_id=" + room_id + ", startime=" + startime + ", endtime="
				+ endtime + ", booktime=" + booktime + ", meeting_state=" + meeting_state + ", meeting_number="
				+ meeting_number + ", role_id=" + role_id + ", meeting_name=" + meeting_name + ", meeting_notes="
				+ meeting_notes + ", meeting_reason=" + meeting_reason + "]";
	}
    
}
