package com.zrgj.POJO;

public class Room {
	private int roomid;
	private String roomstate;
	private String roomname;
	private int capacity;
	private String notes;
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getRoomstate() {
		return roomstate;
	}
	public void setRoomstate(String roomstate) {
		this.roomstate = roomstate;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomstate=" + roomstate + ", roomname=" + roomname + ", capacity="
				+ capacity + ", notes=" + notes + "]";
	}
	
}
