package com.zrgj.DAL.DAO;

import java.util.List;

import com.zrgj.POJO.department;

public interface departmentDao {
	public List<department> read() throws Exception;
	public department readbyid(int id) throws Exception;
	public void insert(String name) throws Exception;
	public void delete(int id) throws Exception;
	public void update(department dept) throws Exception;
	public department readbyname(String name) throws Exception;
	

}
