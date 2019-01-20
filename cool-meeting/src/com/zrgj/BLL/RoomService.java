package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.MemberDAO;
import com.zrgj.DAL.DAO.RoomDAO;
import com.zrgj.POJO.Room;
import com.zrgj.Util.DAOFactory;

public class RoomService {
	private RoomDAO dao=null;
	
	public RoomService(){
		try {
			dao=DAOFactory.getRoomDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Room getRoombyid(int id){
		return dao.readbyid(id);
	}
	public Room ReadById(int id) throws Exception{
		return dao.GetNamebyId(id);
	}
	public void insert(Room r) throws Exception{
		dao.insert(r);
	}
	public List<Room> readall() throws Exception{
		return dao.read();
	}
	public Room readbyname(String name) throws Exception{
		return dao.readbyname(name);
	}
	public List<Room> getAllRoom(){
		return dao.readallroom();
	}
}
