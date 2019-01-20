package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.Role;

public interface RoleDAO {
	public List<Role> read() throws Exception;
	public Role readbyid(int id)  throws Exception;
	public Role readbyusernameandpassword(Role t) throws Exception;
	public void update(Role t)throws Exception;
	public List<Role> readbynandu(Role r,int page) throws Exception;
	public List<Role> readbyn(Role r,int page) throws Exception;
	public List<Role> readbyu(Role r,int page) throws Exception;
	public List<Role> readbystatus(int s,int page) throws Exception;
	public void insert(Role r) throws Exception;
	public Role check_username(String username) throws Exception;
	public List<Role> check() throws Exception;
	public void pass(int status,String username)throws Exception;
	public void delete(String username)throws Exception;
	public int count(int i,Role r)throws Exception;
	public int count_status(int s)throws Exception;
	public List<Role> readbyname(String name) throws Exception;
	public List<Role> readbydepartmentname(String name);
}
