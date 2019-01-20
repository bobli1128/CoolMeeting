package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Member;

public interface MeetingDAO {
	public Meeting ReadbyId(int MeetId) throws Exception;
	public List<Meeting> readbyroleid(int id);
	public void update(int state,int id);
	public void updatereason(String reason,int id);
	public List<Meeting> readbydetail(String sql,Object object[]);
	public int insert(Meeting m)throws Exception;
	public List<Meeting> readbyroomid(int roomid)throws Exception;
	public List<Meeting> readbyidandtime(int roomid,int meetingstate,String start,String end);
}
