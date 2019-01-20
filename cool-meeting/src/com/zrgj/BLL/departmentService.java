package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.departmentDao;
import com.zrgj.POJO.department;
import com.zrgj.Util.DAOFactory;

public class departmentService {
	private departmentDao dao=null;
	
	public departmentService(){
		try {
			dao=DAOFactory.getdepartmentDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<department> getAllDept(){
		List<department> list=null;
		try{
			list=dao.read();
		}catch(Exception e){
			System.out.println("δ�ҵ���ز�����Ϣ");
		}finally{
			return list;
		}
	}
	public department getDeptById(int id){
		department dept=null;
		try{
			dept=dao.readbyid(id);
		}catch(Exception e){
			System.out.println("δ�ҵ���ز�����Ϣ");
		}finally{
			return dept;
		}
	}
	
	public void CreateNewDept(String name){
		try{
			dao.insert(name);
		}catch(Exception e){
			System.out.println("���벿����Ϣ�쳣");
		}
	}
	
	public void DeleteDept(int id) throws Exception{
		dao.delete(id);
	}
	
	public void UpdateDept(department dept){
		try{
			dao.update(dept);
		}catch(Exception e){
			System.out.println("���²�����Ϣ�쳣");
		}
	}
	public department readbyname(String name) throws Exception{
		return dao.readbyname(name);
	}

}
