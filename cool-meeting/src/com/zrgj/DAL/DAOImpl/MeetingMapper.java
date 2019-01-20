package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.Meeting;
import com.zrgj.jdbc.Util.RowMapper;

public class MeetingMapper implements RowMapper<Meeting> {
	@Override
	public Meeting rowMapper(ResultSet rs) throws Exception {
		Meeting t=new Meeting();
		t.setMeeting_id(rs.getInt(1));
		t.setRoom_id(rs.getInt(2));
		t.setStartime(rs.getTimestamp(3));
		t.setEndtime(rs.getTimestamp(4));
		t.setBooktime(rs.getTimestamp(5));
		t.setMeeting_state(rs.getInt(6));
		t.setMeeting_number(rs.getInt(7));
		t.setRole_id(rs.getInt(8));
		t.setMeeting_name(rs.getString(9));
		t.setMeeting_notes(rs.getString(10));
		t.setMeeting_reason(rs.getString(11));
		return t;
	}
}
