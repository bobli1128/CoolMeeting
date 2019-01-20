package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.MemberDAO;
import com.zrgj.POJO.Member;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class MemberDAOImpl implements MemberDAO {
	private JdbcTemplate<Member> template=null;
	public MemberDAOImpl(){
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection()); 
	}
	@Override
	public List<Member> GetMeetsbyId(int id) throws Exception {
		return template.queryList("select id,role_id,meeting_id from member where role_id=?", new Object[]{id}, new MemberRowMapper());
	}
	@Override
	public List<Member> read() {
		List<Member> list=null;
		try{
			list=template.queryList("select id,role_id,meeting_id from member", null, new MemberRowMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@Override
	public Member readbyid(int id) {
		Member m=null;
		try{
			m=(template.queryList("select id,role_id,meeting_id from member where id=?", new Object[]{id}, new MemberRowMapper())).get(0);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return m;
		}
	}
	@Override
	public void insert(Member m) {
		try{
			template.update("insert into member(id,role_id,meeting_id) values(?,?,?)", new Object[]{m.getId(),m.getRole_id(),m.getMeeting_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(Member m) {
		try{
			template.update("update member set role_id=? where meeting_id=?", new Object[]{m.getRole_id(),m.getMeeting_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(int id) {
		try{
			template.update("delete from member where id=?", new Object[]{id});
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Member> readbymeetingid(int meeting_id) {
		// TODO Auto-generated method stub
		List<Member> list=null;
		try{
			list=template.queryList("select * from member where meeting_id=?", new Object[]{meeting_id}, new MemberRowMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}


}
