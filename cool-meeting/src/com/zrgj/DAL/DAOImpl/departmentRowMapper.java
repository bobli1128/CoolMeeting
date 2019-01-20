package com.zrgj.DAL.DAOImpl; 

import java.sql.ResultSet;

import com.zrgj.POJO.department;
import com.zrgj.jdbc.Util.RowMapper;

public class departmentRowMapper implements RowMapper<department> {
	@Override
	public department rowMapper(ResultSet rs) throws Exception {
		department dept=new department();
		try{
			dept.setDep_id(rs.getInt(1));
			dept.setDep_name(rs.getString(2));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return dept;
		}
	}
	
	

}
