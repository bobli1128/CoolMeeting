package com.zrgj.UI.Controller;

import java.io.IOException;
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
import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.Role;

@WebServlet(value={"/myself/meetingshowbyid.do"})
public class meetingShowbyid extends HttpServlet {
	private MeetingService service=new MeetingService();
	private MemberService service1 = new MemberService();
	private RoleService service2 = new RoleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Meeting m=null;
		try {
			m = service.GetById(Integer.parseInt(req.getParameter("id")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(m.getMeeting_state()==0) m.setState("取消");
		else if(m.getMeeting_state()==1) m.setState("正常");
		req.setAttribute("booking", m);
		
		List<Member> list=service1.getMemberbymid(m.getMeeting_id());
		List<String> list2=new ArrayList<String>();
		int len=list.size();
		for(int i=0;i<len;i++){
			int rid=list.get(i).getRole_id();
			Role partner=new Role();
			partner=service2.getRightUser(rid);
			String pname=partner.getRole_name();
			list2.add(new Integer(i), pname);
		}
		req.setAttribute("mates",list2);
		
		req.getRequestDispatcher("/myself/bookingdetail.jsp").forward(req, resp);
	}

}
