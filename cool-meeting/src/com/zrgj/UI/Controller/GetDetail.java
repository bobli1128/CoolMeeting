package com.zrgj.UI.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(value={"/myself/meetshowD.do"})
public class GetDetail extends HttpServlet {
	private MeetingService service1=new MeetingService();
	private RoomService service2=new RoomService();
	private RoleService service3 = new RoleService();
	private MemberService service4 = new MemberService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int meetid=Integer.parseInt(req.getParameter("mid"));
		int roomid=Integer.parseInt(req.getParameter("rid"));
		
		List<Member> list=service4.getMemberbymid(meetid);
		List<String> list2=new ArrayList<String>();
		int len=list.size();
		for(int i=0;i<len;i++){
			int rid=list.get(i).getRole_id();
			Role partner=new Role();
			partner=service3.getRightUser(rid);
			String pname=partner.getRole_name();
			list2.add(new Integer(i), pname);
		}
		req.setAttribute("qingu",list2);
		
		Meeting temp_meet=null;//临时一行的meet
		Room temp=null;
		try {
			temp_meet=service1.GetById(meetid);
			temp=service2.ReadById(roomid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rname=temp.getRoomname();
		temp_meet.setRoom_name(rname);
		req.setAttribute("meet", temp_meet);
		int flag=Integer.parseInt(req.getParameter("flags"));
		if(flag==1)
			req.getRequestDispatcher("/myself/MeetD2.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("/myself/MeetD.jsp").forward(req, resp);		
	}
}
