package com.zrgj.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.zrgj.DAL.DAO.MeetingDAO;
import com.zrgj.DAL.DAO.MemberDAO;
import com.zrgj.DAL.DAO.RoleDAO;
import com.zrgj.DAL.DAO.RoomDAO;
import com.zrgj.DAL.DAO.departmentDao;
import com.zrgj.DAL.DAOImpl.RoleDAOImpl;
import com.zrgj.POJO.department;


/**
 * DAO�����࣬�Ե���������ʽ����DAO����ʵ��ҵ���߼������ݷ���֮��Ľ����ҵ���߼�����Ҫ�õ����ݷ��ʶ�����ⲿע�뵽
 * ҵ���߼����У��Ӷ�ҵ���߼��㲻��Ҫ֪����������һ�����ݷ��ʶ���ʵ�����ݷ��ʹ���
 * @author Administrator
 *
 */
/*public class DAOFactory {
	private static tUserDAO dao=null;
	private static Properties pro=null;
	
	 ��̬����Σ��൱������������Ӧ�ó������й�����ֻ����һ��
	
	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro=new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
public class DAOFactory {
	private static RoleDAO dao=null;
	private static departmentDao dao1=null;
	private static MeetingDAO dao2=null;
	private static MemberDAO dao3=null;
	private static RoomDAO dao4=null;
	private static Properties pro=null;
	

	static{
		InputStream is=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		pro=new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��̬��������
	 * @return
	 * @throws Exception
	 */
/*	public static tUserDAO gettUserDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro.getProperty("tUserDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao=(tUserDAO) cls.newInstance();
		return dao;
	}*/
	public static RoleDAO getRoleDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro.getProperty("RoleDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao=(RoleDAO) cls.newInstance();
		return dao;
	}
	public static departmentDao getdepartmentDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro.getProperty("departmentDao");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao1=(departmentDao) cls.newInstance();
		return dao1;
	}
	public static MeetingDAO getMeetingDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro.getProperty("MeetingDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao2=(MeetingDAO) cls.newInstance();
		return dao2;
	}
	public static MemberDAO getMemberDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro.getProperty("MemberDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao3=(MemberDAO) cls.newInstance();
		return dao3;
	}
	public static RoomDAO getRoomDAO() throws Exception{
		//��ȡ���ݷ���ʵ�����ȫ����
		String clsname=pro.getProperty("RoomDAO");
		//��ȡ���ݷ���ʵ�������ṹ
		Class cls=Class.forName(clsname);
		//�������ݷ���ʵ����Ķ���
		dao4=(RoomDAO) cls.newInstance();
		return dao4;
	}

}
