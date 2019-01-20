package com.zrgj.BLL;

import java.util.ArrayList;
import java.util.List;

import com.zrgj.DAL.DAO.MemberDAO;
import com.zrgj.DAL.DAOImpl.MemberDAOImpl;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.department;
import com.zrgj.Util.DAOFactory;

public class MemberService {
	private MemberDAO dao=null;
	
	public MemberService(){
		try {
			dao=DAOFactory.getMemberDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Member> getTempsByRoleId(int id) throws Exception{
		List<Member> list=null;
		try{
			list=dao.GetMeetsbyId(id);
		}catch(Exception e){
			System.out.println("Œ¥’“µΩª·“ÈID");
		}finally{
			return list;
		}
	}
	
	public List<Member> getAllMember(){
		return dao.read();
	}
	
	public Member getMemberbyid(Member m){
		return dao.readbyid(m.getId());
	}
	
	public void CreateNewMember(Member m){
		dao.insert(m);
	}
	
	public void UpdateOldMember(Member m){
		if(dao.readbyid(m.getId())!=null){
			dao.update(m);
		}
	}
	
	public void DeleteOldMember(Member m){
		if(dao.readbyid(m.getId())!=null){
			dao.delete(m.getId());
		}
	}
	public List<Member> getMemberbymid(int meeting_id){
		return dao.readbymeetingid(meeting_id);
	}

}
