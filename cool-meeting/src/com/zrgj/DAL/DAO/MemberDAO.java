package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Member;

public interface MemberDAO {
	public List<Member> GetMeetsbyId(int RoleId) throws Exception;
	public List<Member> read();
	public Member readbyid(int id);
	public void insert(Member m);
	public void update(Member m);
	public void delete(int id);
	public List<Member> readbymeetingid(int meeting_id);
}
