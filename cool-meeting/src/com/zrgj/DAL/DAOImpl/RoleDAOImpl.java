package com.zrgj.DAL.DAOImpl;

import java.util.List;

import com.zrgj.DAL.DAO.RoleDAO;
import com.zrgj.POJO.Role;
import com.zrgj.jdbc.Util.ConnectionFactory;
import com.zrgj.jdbc.Util.JdbcTemplate;

public class RoleDAOImpl implements RoleDAO {
	private JdbcTemplate<Role> template=null;
	public RoleDAOImpl(){
		template=new JdbcTemplate(ConnectionFactory.getInstance().getConnection()); 
	}
	@Override
	public List<Role> read() throws Exception{
		return template.queryList("select role_id,role_name,role_dep,role_mail,role_tele,role_username,role_password,role_status from role", null, new RoleRowMapper());
	}

	@Override
	public Role readbyid(int id) throws Exception{
		return (template.queryList("select role_id,role_name,role_dep,role_mail,role_tele,role_username,role_password,role_status from role where role_id=?", 
				new Object[]{id}, new RoleRowMapper())).get(0);
	}

	@Override
	public Role readbyusernameandpassword(Role t) throws Exception{
		return (template.queryList("select role_id,role_name,role_dep,role_mail,role_tele,role_username,role_password,role_status from role where role_username=? and role_password=?", 
				new Object[]{t.getRole_username(),t.getRole_password()}, new RoleRowMapper())).get(0);
	}
	@Override
	public void update(Role t)throws Exception{
		try{
			template.update("update role set role_password=? where role_id=?", 
					new Object[]{t.getRole_password(),t.getRole_id()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public List<Role> readbynandu(Role r,int page) throws Exception {
		return (template.queryList("select * from role where role_name=? and role_username=? limit ?,6",
				new Object[]{r.getRole_name(),r.getRole_username(),page},new RoleRowMapper()));
	}
	
	@Override
	public List<Role> readbyn(Role r,int page) throws Exception {
		return (template.queryList("select * from role where role_name=? limit ?,6",
				new Object[]{r.getRole_name(),page},new RoleRowMapper()));
	}
	
	@Override
	public List<Role> readbyu(Role r,int page) throws Exception {
		return (template.queryList("select * from role where role_username=? limit ?,6",
				new Object[]{r.getRole_username(),page},new RoleRowMapper()));
	}
	
	@Override
	public List<Role> readbystatus(int s,int page) throws Exception{
		return (template.queryList("select * from role where role_status=? limit ?,6",
				new Object[]{s,page},new RoleRowMapper()));
	}
	@Override
	public void insert(Role r) throws Exception{
		template.update("insert into role(role_name,role_dep,role_mail,role_tele,role_username,role_password,role_status) values(?,?,?,?,?,?,?)",
				new Object[]{r.getRole_name(),r.getRole_dep(),r.getRole_mail(),r.getRole_tele(),r.getRole_username(),r.getRole_password(),r.getRole_status()});
	}
	@Override
	public Role check_username(String username) throws Exception{
		Role rm=(template.queryList("select * from role where role_username=?", new Object[]{username}, new RoleRowMapper())).get(0);
		return rm;		
	}
	@Override
	public List<Role> check() throws Exception{
		return template.queryList("select * from role where role_status=2", null, new RoleRowMapper());
	}
	@Override
	public void pass(int status,String username)throws Exception{
		template.update("update role set role_status=? where role_username=?",new Object[]{status,username});
	}
	@Override
	public void delete(String username)throws Exception{
		template.update("update role set role_status=3 where role_username=?",new Object[]{username});
	}
	@Override
	public int count(int i,Role r) throws Exception {
		List<Role> list=null;
		if(i==1){
			list = template.queryList("select * from role where role_name=? and role_username=?",
					new Object[]{r.getRole_name(),r.getRole_username()},new RoleRowMapper());
			return list.size();
		}else if(i==2){
			list = template.queryList("select * from role where role_name=?",
					new Object[]{r.getRole_name()},new RoleRowMapper());
			return list.size();
		}else{
			list = template.queryList("select * from role where role_username=?",
					new Object[]{r.getRole_username()},new RoleRowMapper());
			return list.size();
		}
	}
	@Override
	public int count_status(int s) throws Exception {
		List<Role> list=null;
		list = template.queryList("select * from role where role_status=?",
				new Object[]{s},new RoleRowMapper());
		return list.size();
	}
	@Override
	public List<Role> readbyname(String name) throws Exception {
		List<Role> r=null;
		r=template.queryList("select role_id,role_name,role_dep,role_mail,role_tele,role_username,role_password,role_status from role where role_name=?", new Object[]{name}, new RoleRowMapper());
		return r;
	}
	@Override
	public List<Role> readbydepartmentname(String name) {
		List<Role> list=null;
		try{
			list=template.queryList("select role_id,role_name,role_dep,role_mail,role_tele,role_username,role_password,role_status from role where role_dep=?", new Object[]{name}, new RoleRowMapper());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return list;
		}
	}
}
