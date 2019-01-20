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


@WebServlet(value={"/meetingorder/searchmeetingshowbyid.do"})
public class searchmeetingshowbyid extends HttpServlet {
	private MeetingService service=new MeetingService();
	private RoleService service1=new RoleService();
	private MemberService service2 = new MemberService();

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
		else if(m.getMeeting_state()==1){
			m.setState("正常");
			m.setMeeting_reason("会议状态正常，没有撤销理由！！！");
		}
		List<Member> list=service2.getMemberbymid(Integer.parseInt(req.getParameter("id")));
		List<String> list2=new ArrayList<String>();
		int len=list.size();
		for(int i=0;i<len;i++){
			int rid=list.get(i).getRole_id();
			Role partner=new Role();
			partner=service1.getRightUser(rid);
			String pname=partner.getRole_name();
			list2.add(new Integer(i), pname);
		}
		req.setAttribute("partner",list2);
		Role r=service1.getRightUser(m.getRole_id());
		m.setRolename(r.getRole_name());
		req.setAttribute("booking", m);
		req.getRequestDispatcher("/meetingorder/searchmeetingdetail.jsp").forward(req, resp);
	}

}
