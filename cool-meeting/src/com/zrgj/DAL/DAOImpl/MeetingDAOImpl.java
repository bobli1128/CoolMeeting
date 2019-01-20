package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.MeetingDAO;
import com.zrgj.POJO.Meeting;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class MeetingDAOImpl implements MeetingDAO {
	private JdbcTemplate<Meeting> template=null;
	public MeetingDAOImpl(){
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection()); 
	}
	@Override
	public Meeting ReadbyId(int MeetId) throws Exception {
		return (template.queryList("select * from meeting where meeting_id=?", new Object[]{MeetId}, new MeetingMapper())).get(0);
	}
	@Override
	public List<Meeting> readbyroleid(int id) {
		List<Meeting> list=null;
		try {
			list=template.queryList("select meeting_id,room_id,starttime,endtime,booktime,meeting_state,meeting_number,role_id,meeting_name,meeting_notes,meeting_reason from meeting where role_id=?", 
					new Object[]{id}, new MeetingMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@Override
	public void update(int state,int id) {
		// TODO Auto-generated method stub
		try{
			template.update("update meeting set meeting_state=? where meeting_id=?", 
					new Object[]{state,id});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void updatereason(String reason, int id) {
		// TODO Auto-generated method stub
		try{
			template.update("update meeting set meeting_reason=? where meeting_id=?", 
					new Object[]{reason,id});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public List<Meeting> readbydetail(String sql,Object object[]) {
		List<Meeting> list=null;
		try {
			list=template.queryList(sql,object, new MeetingMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return list;
		}
		
	}
	
	
	@Override
	public List<Meeting> readbyidandtime(int roomid, int meetingstate, String start, String end) {
		List<Meeting> list=null;
		try{
			list=template.queryList("select meeting_id,room_id,starttime,endtime,booktime,meeting_state,meeting_number,role_id,meeting_name,meeting_notes,meeting_reason from meeting where room_id=? and meeting_state=? and starttime>? and endtime<?", new Object[]{roomid,meetingstate,start,end}, new MeetingMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@Override
	public int insert(Meeting m) throws Exception {
		try{
			template.update("insert into meeting(meeting_id,room_id,starttime,endtime,booktime,meeting_state,meeting_number,role_id,meeting_name,meeting_notes,meeting_reason) values (?,?,?,?,?,?,?,?,?,?,?)", new Object[]{m.getMeeting_id(),m.getRoom_id(),m.getStartime(),m.getEndtime(),m.getBooktime(),m.getMeeting_state(),m.getMeeting_number(),m.getRole_id(),m.getMeeting_name(),m.getMeeting_notes(),m.getMeeting_reason()});
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return (template.queryList("select meeting_id,room_id,starttime,endtime,booktime,meeting_state,meeting_number,role_id,meeting_name,meeting_notes,meeting_reason from meeting order by meeting_id desc", null, new MeetingMapper()).get(0)).getMeeting_id();
		}
	}
	@Override
	public List<Meeting> readbyroomid(int roomid) throws Exception {
		List<Meeting> list=null;
		try{
			list=template.queryList("select meeting_id,room_id,starttime,endtime,booktime,meeting_state,meeting_number,role_id,meeting_name,meeting_notes,meeting_reason from meeting where room_id=?", 
					new Object[]{roomid}, new MeetingMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	


	

}
