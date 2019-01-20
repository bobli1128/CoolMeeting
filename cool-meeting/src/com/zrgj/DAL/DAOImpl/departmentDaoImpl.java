package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.departmentDao;
import com.zrgj.POJO.department;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class departmentDaoImpl implements departmentDao {
	private JdbcTemplate<department> template=null;
	public departmentDaoImpl(){
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection()); 
	}

	@Override
	public List<department> read() throws Exception {
		return template.queryList("select dep_id,dep_name from department", null, new departmentRowMapper());
	}

	@Override
	public department readbyid(int id) throws Exception {
		return (template.queryList("select dep_id,dep_name from department where dep_id=?", new Object[]{id}, new departmentRowMapper())).get(0);
	}

	@Override
	public void insert(String name) throws Exception {
		template.update("insert into department(dep_name) values(?)", new Object[]{name});
	}

	@Override
	public void delete(int id) throws Exception {
		template.update("delete from department where dep_id=?", new Object[]{id});
		
	}

	@Override
	public void update(department dept) throws Exception {
		template.update("update department set dep_name=? where dep_id=?", new Object[]{dept.getDep_name(),dept.getDep_id()});
		
	}

	@Override
	public department readbyname(String name) throws Exception {
		department d=null;
		d=template.queryList("select * from department where dep_name=?", new Object[]{name}, new departmentRowMapper()).get(0);
		return d;
	}


}
