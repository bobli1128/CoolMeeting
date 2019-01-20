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
 * DAO工厂类，以第三方的形式创建DAO对象，实现业务逻辑与数据访问之间的解耦，将业务逻辑层需要用的数据访问对象从外部注入到
 * 业务逻辑层中，从而业务逻辑层不需要知道具体是哪一个数据访问对象实现数据访问功能
 * @author Administrator
 *
 */
/*public class DAOFactory {
	private static tUserDAO dao=null;
	private static Properties pro=null;
	
	 静态代码段，相当于匿名函数，应用程序运行过程中只运行一次
	
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
	 * 静态工厂方法
	 * @return
	 * @throws Exception
	 */
/*	public static tUserDAO gettUserDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro.getProperty("tUserDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao=(tUserDAO) cls.newInstance();
		return dao;
	}*/
	public static RoleDAO getRoleDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro.getProperty("RoleDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao=(RoleDAO) cls.newInstance();
		return dao;
	}
	public static departmentDao getdepartmentDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro.getProperty("departmentDao");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao1=(departmentDao) cls.newInstance();
		return dao1;
	}
	public static MeetingDAO getMeetingDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro.getProperty("MeetingDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao2=(MeetingDAO) cls.newInstance();
		return dao2;
	}
	public static MemberDAO getMemberDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro.getProperty("MemberDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao3=(MemberDAO) cls.newInstance();
		return dao3;
	}
	public static RoomDAO getRoomDAO() throws Exception{
		//获取数据访问实现类的全类名
		String clsname=pro.getProperty("RoomDAO");
		//获取数据访问实现类的类结构
		Class cls=Class.forName(clsname);
		//创建数据访问实现类的对象
		dao4=(RoomDAO) cls.newInstance();
		return dao4;
	}

}
