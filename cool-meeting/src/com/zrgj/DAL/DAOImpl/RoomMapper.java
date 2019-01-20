package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.Room;
import com.zrgj.jdbc.Util.RowMapper;

public class RoomMapper implements RowMapper<Room> {
	@Override
	public Room rowMapper(ResultSet rs) throws Exception {
		Room r=new Room();
		r.setRoomid(rs.getInt(1));
		r.setRoomstate(rs.getString(2));
		r.setRoomname(rs.getString(3));
		r.setCapacity(rs.getInt(4));
		r.setNotes(rs.getString(5));
		return r;
	}
}
