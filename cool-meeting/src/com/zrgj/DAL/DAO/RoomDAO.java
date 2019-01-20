package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.Member;
import com.zrgj.POJO.Room;

public interface RoomDAO {
	public Room GetNamebyId(int id) throws Exception;
	public Room readbyname(String name) throws Exception;
	public void insert(Room r) throws Exception;
	public List<Room> read() throws Exception;
	public List<Room> readallroom();
	public Room readbyid(int id);
}
