package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.Member;
import com.zrgj.POJO.Role;
import com.zrgj.jdbc.Util.RowMapper;

public class MemberRowMapper implements RowMapper<Member> {
	@Override
	public Member rowMapper(ResultSet rs) throws Exception {
		Member t=new Member();
		t.setId(rs.getInt(1));
		t.setRole_id(rs.getInt(2));
		t.setMeeting_id(rs.getInt(3));
		return t;
	}
}
