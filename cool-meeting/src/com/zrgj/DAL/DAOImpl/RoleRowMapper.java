package com.zrgj.DAL.DAOImpl;

import java.sql.ResultSet;

import com.zrgj.POJO.Role;
import com.zrgj.jdbc.Util.RowMapper;

public class RoleRowMapper implements RowMapper<Role> {
	@Override
	public Role rowMapper(ResultSet rs) throws Exception {
		Role t=new Role();
		t.setRole_id(rs.getInt(1));
		t.setRole_name(rs.getString(2));
		t.setRole_dep(rs.getString(3));
		t.setRole_mail(rs.getString(4));
		t.setRole_tele(rs.getString(5));
		t.setRole_username(rs.getString(6));
		t.setRole_password(rs.getString(7));
		t.setRole_status(rs.getInt(8));
		return t;
	}
}
