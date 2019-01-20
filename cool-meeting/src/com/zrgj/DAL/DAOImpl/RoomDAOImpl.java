package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.RoomDAO;
import com.zrgj.POJO.Room;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class RoomDAOImpl implements RoomDAO {
	private JdbcTemplate<Room> template=null;
	public RoomDAOImpl(){
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection()); 
	}
	@Override
	public Room GetNamebyId(int id) throws Exception {
		return (template.queryList("select room_id,room_state,room_name,room_capacity,room_notes from room where room_id=?", new Object[]{id}, new RoomMapper())).get(0);
	}
	@Override
	public void insert(Room r) throws Exception{
		template.update("insert into room(room_id,room_state,room_name,room_capacity,room_notes) values(?,?,?,?,?)", new Object[]{r.getRoomid(),r.getRoomstate(),r.getRoomname(),r.getCapacity(),r.getNotes()});
	}
	@Override
	public List<Room> read() throws Exception {
		List<Room> r=null;
		try{
			r=template.queryList("select room_id,room_state,room_name,room_capacity,room_notes from room", null, new RoomMapper());
			for(Room list:r){
			if("0".equals(list.getRoomstate())) list.setRoomstate("∆Ù”√");
			else if("1".equals(list.getRoomstate())) list.setRoomstate("Õ£”√");
			else if("2".equals(list.getRoomstate())) list.setRoomstate("…æ≥˝");
			}
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			return r;
		}
	}
	@Override
	public Room readbyname(String name) throws Exception {
		Room r=null;
		r=template.queryList("select room_id,room_state,room_name,room_capacity,room_notes from room where room_name=?", new Object[]{name}, new RoomMapper()).get(0);
		return r;
	}
	@Override
	public List<Room> readallroom() {
		List<Room> list=null;
		try{
			list=template.queryList("select room_id,room_state,room_name,room_capacity,room_notes from room", null, new RoomMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@Override
	public Room readbyid(int id) {
		Room r=null;
		try{
			r=template.queryList("select room_id,room_state,room_name,room_capacity,room_notes from room where room_id=?", new Object[]{id}, new RoomMapper()).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return r;
		}
	}

}
