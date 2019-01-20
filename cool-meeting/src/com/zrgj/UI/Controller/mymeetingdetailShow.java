package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zrgj.BLL.MeetingService;
import com.zrgj.BLL.MemberService;
import com.zrgj.BLL.RoleService;
import com.zrgj.BLL.RoomService;
import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.Role;
import com.zrgj.POJO.Room;
import com.zrgj.POJO.mymeeting;

@WebServlet(value = { "/myself/detailshow.do" })
public class mymeetingdetailShow extends HttpServlet {
	MeetingService service = new MeetingService();
	private MemberService service1 = new MemberService();
	private RoleService service2 = new RoleService();
	private RoomService service3 = new RoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("mid"));
		Meeting meet = new Meeting();
		try {
			meet = service.GetById(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<Member> list=service1.getMemberbymid(id);
		List<String> list2=new ArrayList<String>();
		int len=list.size();
		for(int i=0;i<len;i++){
			int rid=list.get(i).getRole_id();
			Role partner=new Role();
			partner=service2.getRightUser(rid);
			String pname=partner.getRole_name();
			list2.add(new Integer(i), pname);
		}
		req.setAttribute("partners",list2);


		int roomid = meet.getRoom_id();/* 找到会议室的名称 */
		Room meetingroom = new Room();
		try {
			meetingroom = service3.ReadById(roomid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rname = meetingroom.getRoomname();

		int roleid = meet.getRole_id();/* 找到了预定会议人的名称 */
		Role booker = new Role();
		booker = service2.getRightUser(roleid);
		String bookername = booker.getRole_name();

		mymeeting my = new mymeeting();
		my.setMeeting_id(id);
		my.setMeeting_name(meet.getMeeting_name());
		my.setRoom_name(rname);
		my.setStarttime(meet.getStartime());
		my.setEndtime(meet.getEndtime());
		my.setBooktime(meet.getBooktime());
		my.setRole_name(bookername);
		my.setMeeting_notes(meet.getMeeting_notes());
		
		//HttpSession session=req.getSession(true);
		//session.setAttribute("mymeeting", emp);
		req.setAttribute("mine",my);
//		req.setAttribute("mymeetingnames",list2);
		req.getRequestDispatcher("/myself/mymeetingdetail.jsp").forward(req, resp);
	}

}
