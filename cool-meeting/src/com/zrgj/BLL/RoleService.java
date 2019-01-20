package com.zrgj.BLL;

import java.util.List;

import com.zrgj.DAL.DAO.RoleDAO;
import com.zrgj.POJO.Role;
import com.zrgj.Util.DAOFactory;

//import java.util.List;

//import com.zrgj.Util.DAOFactory;

public class RoleService {
	private RoleDAO dao=null;
	public RoleService(){
		try{
			dao=DAOFactory.getRoleDAO();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
//���ϴ���ʵ��ͨ�������Ž���Role������ֱ��RoleDAOImpl a=new ..() ������ܹ��е���������ϵ̫����
//�����������ϵӦ����С
	public List<Role> getAllUser() throws Exception{
		return dao.read();
	}
	
	public Role getUserbyid(Role t) throws Exception{
		return dao.readbyid(t.getRole_id());
	}
	
	public Role login(Role t) throws Exception
	{
		if(dao.readbyusernameandpassword(t)!=null)
		{
			return dao.readbyusernameandpassword(t);
		}
		else
			return null;
	}
	public Role getRightUser(int role_id){
		Role tt=new Role();
		try{
			tt=dao.readbyid(role_id);
		} catch(Exception e){
			System.out.println("Error!!");
		}finally{
			return tt;
		}
	}
	public void UpdateOldUser(Role t){
		try {
			if(dao.readbyid(t.getRole_id())!=null){
				dao.update(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void create(Role r){
		try {
			dao.insert(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Role check_username(String username){
		Role rm=null;
		try {
			rm=dao.check_username(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return rm;
		}
	}
	@SuppressWarnings("finally")
	public List<Role> getUncheckedRoles() {
		List<Role> list=null;
		try{
			list=dao.check();
		}catch(Exception e){
//			JOptionPane.showMessageDialog(null, "û���κδ������Ա��Ϣ","alert",JOptionPane.ERROR_MESSAGE);
			System.out.println("û���κδ������Ա��Ϣ");
		}finally{
			return list;
		}
	}
	@SuppressWarnings("finally")
	public List<Role> search(Role r,int page){
		List list=null;
		try {
			list=dao.readbynandu(r,page);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("û���κ���Ա��Ϣ");
		}finally{
			return list;
		}
	}
	public List<Role> search_u(Role r,int page){
		List list=null;
		try {
			list=dao.readbyu(r,page);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("û���κ���Ա��Ϣ");
		}finally{
			return list;
		}
	}
	public List<Role> search_n(Role r,int page){
		List list=null;
		try {
			list=dao.readbyn(r,page);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("û���κ���Ա��Ϣ");
		}finally{
			return list;
		}
	}
	@SuppressWarnings("finally")
	public int pagecount(int i,Role r){
		int count=0;
		try {
			count=dao.count(i, r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return count;
		}
	}
	public int pagecount_s(int s){
		int count=0;
		try {
			count=dao.count_status(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return count;
		}
	}
	
	public List<Role> getEmpbyStatus(int status,int page){
		List list=null;
		try {
			list=dao.readbystatus(status,page);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("û���κ���Ա��Ϣ");
		}finally{
			return list;
		}
	}
	public void changestatus(int status,String username){
		try {
			dao.pass(status,username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(String username){
		try {
			dao.delete(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Role> readbyname(String name) throws Exception{
		return dao.readbyname(name);
	}
	
	public List<Role> getrolebydepartmentname(String name){
		return dao.readbydepartmentname(name);
	}

}
