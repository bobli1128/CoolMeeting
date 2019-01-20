package com.zrgj.UI.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.MeetingService;
import com.zrgj.BLL.MemberService;
import com.zrgj.BLL.RoleService;
import com.zrgj.BLL.RoomService;
import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.Role;
import com.zrgj.POJO.Room;
import com.zrgj.POJO.mymeeting;
@WebServlet(value={"/myself/showmymeeting.do"})
public class mymeetingShow extends HttpServlet {
   private MeetingService service= new MeetingService();
   private MemberService service1=new MemberService();
   private RoleService service2=new RoleService();
   private RoomService service3=new RoomService();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int id=Integer.parseInt(req.getParameter("rid"));
//	System.out.println(id);
	System.out.print(id);
	List<Member> list=new ArrayList<Member>();
			try {
				list=service1.getTempsByRoleId(id);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
//	System.out.print(list.size());
	int len=list.size();
//	List<meeting> list1=new ArrayList<meeting>();
	List<mymeeting> list2=new ArrayList<mymeeting>();
	for(int i=0;i<len;i++){
//		System.out.print(list.get(i).getMeeting_id());
		Meeting m=new Meeting();
		try {
			m=service.GetById(list.get(i).getMeeting_id());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int roomid=m.getRoom_id();/*找到会议室的名称*/
		Room meetingroom=new Room();
		try {
			meetingroom=service3.ReadById(roomid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rname=meetingroom.getRoomname();
//		System.out.println(rname);
				
		int roleid=m.getRole_id();/*找到了预定会议人的名称*/
		Role booker=new Role();
		booker=service2.getRightUser(roleid);
		String bookername=booker.getRole_name();
//		System.out.println(bookername);
		
		mymeeting my=new mymeeting();/*建立一个对象存储会议名称以及预订人名称,此时list2中存储的是我所有的会议,不管是否取消以及是否过时*/
		my.setMeeting_id(m.getMeeting_id());
		my.setMeeting_name(m.getMeeting_name());
		my.setRoom_name(rname);
		my.setStarttime(m.getStartime());
		my.setEndtime(m.getEndtime());
		my.setBooktime(m.getBooktime());
		my.setRole_name(bookername);
		my.setMeeting_state(m.getMeeting_state());
		
		list2.add(new Integer(i), my);
	}
	
	List<mymeeting> list1=new ArrayList<mymeeting>();
	Timestamp nowtime=new Timestamp(System.currentTimeMillis());
	int lenth=list2.size();
	int count=0;
	for(int j=0;j<lenth;j++){
		if((list2.get(j).getStarttime().getTime()>=nowtime.getTime())&&(list2.get(j).getMeeting_state()==1)){
			mymeeting my1=new mymeeting();/*建立一个对象存储会议名称以及预订人名称，此时list1中存储的是我将要参加的会议，即会议开始时间比当前系统时间迟*/
			my1.setMeeting_id(list2.get(j).getMeeting_id());
			my1.setMeeting_name(list2.get(j).getMeeting_name());
			my1.setRoom_name(list2.get(j).getRoom_name());
			my1.setStarttime(list2.get(j).getStarttime());
			my1.setEndtime(list2.get(j).getEndtime());
			my1.setBooktime(list2.get(j).getBooktime());
			my1.setRole_name(list2.get(j).getRole_name());
			my1.setMeeting_state(list2.get(j).getMeeting_state());
			list1.add(new Integer(count), my1);
			count++;
		}
	}
	
	req.setAttribute("mymeetings",list1);
//	req.setAttribute("mymeetingnames",list2);
	req.getRequestDispatcher("/myself/mymeeting.jsp").forward(req, resp);
}
   
}
