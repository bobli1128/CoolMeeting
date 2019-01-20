package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.MeetingDAO;
import com.zrgj.DAL.DAO.MemberDAO;
import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Member;
import com.zrgj.Util.DAOFactory;

public class MeetingService {
	private MeetingDAO dao=null;
	
	public MeetingService(){
		try {
			dao=DAOFactory.getMeetingDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public Meeting GetById(int id) throws Exception{
		Meeting meet=null;
		try{
			meet=dao.ReadbyId(id);
		}catch(Exception e){
			System.out.println("未找到会议信息");
		}finally{
			return meet;
		}
	}
	public List<Meeting> readbyroleid(int id){
		return dao.readbyroleid(id);
	}
	public void UpdateOldUser(int state,int id,String reason){
		dao.update(state, id);
		dao.updatereason(reason, id);
	}
	public List<Meeting> readbydetails(String sql,Object object[]){
		return dao.readbydetail(sql, object);
	}
	public List<Meeting> getMeeting(int room_id) throws Exception{
		return dao.readbyroomid(room_id);
		
	}
	
	public List<Meeting> getMeetingByTime(int id,int state,String start,String end){
		return dao.readbyidandtime(id,state, start, end);
	}
	public int CreateNewMeeting(Meeting m){
		int meetingId = 0;
		try {
			meetingId=dao.insert(m);
		} catch (Exception e) {
			System.out.println("预定会议失败");
			e.printStackTrace();
		}
		return meetingId;
	}
}
