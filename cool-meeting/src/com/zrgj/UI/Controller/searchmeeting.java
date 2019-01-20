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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.zrgj.BLL.MeetingService;
import com.zrgj.BLL.RoleService;
import com.zrgj.BLL.RoomService;
import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.PageBean;
import com.zrgj.POJO.Role;
import com.zrgj.POJO.Room;




@WebServlet(value={"/meetingorder/searchmeeting.do"})
public class searchmeeting extends HttpServlet {
	private MeetingService servicem=new MeetingService();
	private RoomService servicerm=new RoomService();
	private RoleService servicerl=new RoleService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mn=req.getParameter("meetingname");
		String rmn=req.getParameter("roomname");
		String rln=req.getParameter("rolename");
		String bst=req.getParameter("bookstime");
		String bbt=req.getParameter("bookbtime");
		String st=req.getParameter("starttime");
		String ed=req.getParameter("endtime");
		
		String pageStr = req.getParameter("pages");
		int all_count=0;
		int pageindex=1;
		if(pageStr!=null){   //获得页面的session
			if("".equals(pageStr)) pageindex=1;
			else pageindex = Integer.parseInt(pageStr);
			req.getSession().setAttribute("pageindex", pageindex);
		}else{
			pageindex=1;
			req.getSession().setAttribute("pageindex", pageindex);
		}
		
		
		Meeting m=new Meeting();
		Room rm=new Room();
		Role rl=new Role();
		List<Meeting> Meeting=null;
		List<Role> Role=null;
		List<Meeting> Meeting1=null;
		String sql="";
		if(mn!=null){
			req.getSession().setAttribute("meetingname", mn);
		}else{
			HttpSession session=req.getSession(true);
			Object nn=session.getAttribute("meetingname");
			mn=nn.toString();
		}
		if(rmn!=null){
			req.getSession().setAttribute("roomname", rmn);
		}else{
			HttpSession session=req.getSession(true);
			Object nn=session.getAttribute("roomname");
			rmn=nn.toString();
		}
		if(rln!=null){
			req.getSession().setAttribute("rolename", rln);
		}else{
			HttpSession session=req.getSession(true);
			Object nn=session.getAttribute("rolename");
			rln=nn.toString();
		}
		if(bst!=null){
			req.getSession().setAttribute("booksmalltime", bst);
		}else{
			HttpSession session=req.getSession(true);
			Object nn=session.getAttribute("booksmalltime");
			bst=nn.toString();
		}
		if(bbt!=null){
			req.getSession().setAttribute("bookbigtime", bbt);
		}else{
			HttpSession session=req.getSession(true);
			Object nn=session.getAttribute("bookbigtime");
			bbt=nn.toString();
		}
		if(st!=null){
			req.getSession().setAttribute("starttime", st);
		}else{
			HttpSession session=req.getSession(true);
			Object nn=session.getAttribute("starttime");
			st=nn.toString();
		}
		if(ed!=null){
			req.getSession().setAttribute("endtime", ed);
		}else{
			HttpSession session=req.getSession(true);
			Object nn=session.getAttribute("endtime");
			ed=nn.toString();
		}
		
		if("".equals(mn)&&(!rmn.equals(""))&&"".equals(rln)&&"".equals(bst)&&"".equals(bbt)&&"".equals(st)&&"".equals(ed)){
			try {
				rm=servicerm.readbyname(rmn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sql="select * from meeting where room_id=?";
			Meeting=servicem.readbydetails(sql, new Object[]{rm.getRoomid()});
		}else if((!"".equals(mn))&&"".equals(rmn)&&(!"".equals(rln))&&"".equals(bst)&&"".equals(bbt)&&"".equals(st)&&"".equals(ed)){
			try {
				Role=servicerl.readbyname(rln);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sql="select * from meeting where role_id=? and meeting_name=?";
			List<Meeting> mm=null;
			Meeting=new ArrayList();
			for(int i=0;i<Role.size();i++){
				mm=servicem.readbydetails(sql, new Object[]{Role.get(i).getRole_id(),mn});
				for(int j=0;j<mm.size();j++){
					Meeting.add(mm.get(j));
				}
			}
		}else if("".equals(mn)&&"".equals(rmn)&&"".equals(rln)&&(!"".equals(bst))&&(!"".equals(bbt))&&"".equals(st)&&"".equals(ed)){
			bst=bst+" 00:00:00";
			bbt=bbt+" 23:59:59";
			Timestamp booktime1=Timestamp.valueOf(bst);
			Timestamp booktime2=Timestamp.valueOf(bbt);
			sql="select * from meeting where booktime between ? and ?";
			Meeting=servicem.readbydetails(sql, new Object[]{booktime1,booktime2});
		}else if("".equals(mn)&&"".equals(rmn)&&"".equals(rln)&&"".equals(bst)&&"".equals(bbt)&&(!"".equals(st))&&(!"".equals(ed))){
			ed=ed+" 23:59:59";
			st=st+" 00:00:00";
			Timestamp booktime1=Timestamp.valueOf(st);
			Timestamp booktime2=Timestamp.valueOf(ed);
			sql="select * from meeting where starttime>=? and endtime<=?";
			Meeting=servicem.readbydetails(sql, new Object[]{booktime1,booktime2});
		}else if((!"".equals(mn))&&(!"".equals(rmn))&&(!"".equals(rln))&&"".equals(bst)&&"".equals(bbt)&&"".equals(st)&&"".equals(ed)){
			try {
				rm=servicerm.readbyname(rmn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Role=servicerl.readbyname(rln);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Meeting=new ArrayList();
			sql="select * from meeting where role_id=? and room_id=? and meeting_name=?";
			List<Meeting> mm=null;
			for(int i=0;i<Role.size();i++){
				mm=servicem.readbydetails(sql, new Object[]{Role.get(i).getRole_id(),rm.getRoomid(),mn});
				for(int j=0;j<mm.size();j++){
					Meeting.add(mm.get(j));
				}
			}
		}else if("".equals(mn)&&(!"".equals(rmn))&&"".equals(rln)&&(!"".equals(bst))&&(!"".equals(bbt))&&"".equals(st)&&"".equals(ed)){
			try {
				rm=servicerm.readbyname(rmn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bst=bst+" 00:00:00";
			bbt=bbt+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(bst);
			Timestamp time2=Timestamp.valueOf(bbt);
			sql="select * from meeting where room_id=? and booktime>=? and booktime<=?";
			Meeting=servicem.readbydetails(sql, new Object[]{rm.getRoomid(),time1,time2});
		}else if("".equals(mn)&&(!"".equals(rmn))&&"".equals(rln)&&"".equals(bst)&&"".equals(bbt)&&(!"".equals(st))&&(!"".equals(ed))){
			try {
				rm=servicerm.readbyname(rmn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st=st+" 00:00:00";
			ed=ed+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(st);
			Timestamp time2=Timestamp.valueOf(ed);
			sql="select * from meeting where room_id=? and starttime>=? and endtime<=?";
			Meeting=servicem.readbydetails(sql, new Object[]{rm.getRoomid(),time1,time2});
		}else if((!"".equals(mn))&&"".equals(rmn)&&(!"".equals(rln))&&"".equals(bst)&&"".equals(bbt)&&(!"".equals(st))&&(!"".equals(ed))){
			try {
				Role=servicerl.readbyname(rln);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st=st+" 00:00:00";
			ed=ed+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(st);
			Timestamp time2=Timestamp.valueOf(ed);
			sql="select * from meeting where role_id=? and meeting_name=? and starttime>=? and endtime<=?";
			List<Meeting> mm=null;
			Meeting=new ArrayList();
			for(int i=0;i<Role.size();i++){
				mm=servicem.readbydetails(sql, new Object[]{Role.get(i).getRole_id(),mn,time1,time2});
				for(int j=0;j<mm.size();j++){
					Meeting.add(mm.get(j));
				}
			}
		}else if((!"".equals(mn))&&"".equals(rmn)&&(!"".equals(rln))&&(!"".equals(bst))&&(!"".equals(bbt))&&"".equals(st)&&"".equals(ed)){
			try {
				Role=servicerl.readbyname(rln);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bst=bst+" 00:00:00";
			bbt=bbt+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(bst);
			Timestamp time2=Timestamp.valueOf(bst);
			sql="select * from meeting where role_id=? and meeting_name=? and booktime>=? and booktime<=?";
			List<Meeting> mm=null;
			Meeting=new ArrayList();
			for(int i=0;i<Role.size();i++){
				mm=servicem.readbydetails(sql, new Object[]{Role.get(i).getRole_id(),mn,time1,time2});
				for(int j=0;j<mm.size();j++){
					Meeting.add(mm.get(j));
				}
			}
		}else if("".equals(mn)&&"".equals(rmn)&&"".equals(rln)&&(!"".equals(bst))&&(!"".equals(bbt))&&(!"".equals(st))&&(!"".equals(ed))){
			bst=bst+" 00:00:00";
			bbt=bbt+" 23:59:59";
			st=st+" 00:00:00";
			ed=ed+" 23:59:59";
			Timestamp booktime1=Timestamp.valueOf(bst);
			Timestamp booktime2=Timestamp.valueOf(bbt);
			Timestamp booktime3=Timestamp.valueOf(st);
			Timestamp booktime4=Timestamp.valueOf(ed);
			sql="select * from meeting where booktime>=? and booktime<=? and starttime>=? and endtime<=?";
			Meeting=servicem.readbydetails(sql, new Object[]{booktime1,booktime2,booktime3,booktime4});
		}else if((!"".equals(mn))&&(!"".equals(rmn))&&(!"".equals(rln))&&(!"".equals(bst))&&(!"".equals(bbt))&&"".equals(st)&&"".equals(ed)){
			try {
				rm=servicerm.readbyname(rmn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Role=servicerl.readbyname(rln);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bst=bst+" 00:00:00";
			bbt=bbt+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(bst);
			Timestamp time2=Timestamp.valueOf(bbt);
			Meeting=new ArrayList();
			sql="select * from meeting where role_id=? and room_id=? and meeting_name=? and booktime>=? and booktime<=?";
			List<Meeting> mm=null;
			for(int i=0;i<Role.size();i++){
				mm=servicem.readbydetails(sql, new Object[]{Role.get(i).getRole_id(),rm.getRoomid(),mn,time1,time2});
				for(int j=0;j<mm.size();j++){
					Meeting.add(mm.get(j));
				}
			}
		}else if((!"".equals(mn))&&(!"".equals(rmn))&&(!"".equals(rln))&&"".equals(bst)&&"".equals(bbt)&&(!"".equals(st))&&(!"".equals(ed))){
			try {
				rm=servicerm.readbyname(rmn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Role=servicerl.readbyname(rln);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st=st+" 00:00:00";
			ed=ed+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(st);
			Timestamp time2=Timestamp.valueOf(ed);
			Meeting=new ArrayList();
			sql="select * from meeting where role_id=? and room_id=? and meeting_name=? and starttime>=? and endtime<=?";
			List<Meeting> mm=null;
			for(int i=0;i<Role.size();i++){
				mm=servicem.readbydetails(sql, new Object[]{Role.get(i).getRole_id(),rm.getRoomid(),mn,time1,time2});
				for(int j=0;j<mm.size();j++){
					Meeting.add(mm.get(j));
				}
			}
		}else if((!"".equals(mn))&&"".equals(rmn)&&(!"".equals(rln))&&(!"".equals(bst))&&(!"".equals(bbt))&&(!"".equals(st))&&(!"".equals(ed))){
			try {
				Role=servicerl.readbyname(rln);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bst=bst+" 00:00:00";
			bbt=bbt+" 23:59:59";
			st=st+" 00:00:00";
			ed=ed+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(bst);
			Timestamp time2=Timestamp.valueOf(bbt);
			Timestamp time3=Timestamp.valueOf(st);
			Timestamp time4=Timestamp.valueOf(ed);
			sql="select * from meeting where role_id=? and meeting_name=? and booktime>=? and booktime<=? and starttime>=? and endtime<=?";
			List<Meeting> mm=null;
			Meeting=new ArrayList();
			for(int i=0;i<Role.size();i++){
				mm=servicem.readbydetails(sql, new Object[]{Role.get(i).getRole_id(),mn,time1,time2});
				for(int j=0;j<mm.size();j++){
					Meeting.add(mm.get(j));
				}
			}
		}else if("".equals(mn)&&(!"".equals(rmn))&&"".equals(rln)&&(!"".equals(bst))&&(!"".equals(bbt))&&(!"".equals(st))&&(!"".equals(ed))){
			try {
				rm=servicerm.readbyname(rmn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bst=bst+" 00:00:00";
			bbt=bbt+" 23:59:59";
			st=st+" 00:00:00";
			ed=ed+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(bst);
			Timestamp time2=Timestamp.valueOf(bbt);
			Timestamp time3=Timestamp.valueOf(st);
			Timestamp time4=Timestamp.valueOf(ed);
			sql="select * from meeting where room_id=? and booktime>=? and booktime<=? and starttime>=? and endtime<=?";
			Meeting=servicem.readbydetails(sql, new Object[]{rm.getRoomid(),time1,time2,time3,time4});
		}else if((!"".equals(mn))&&(!"".equals(rmn))&&(!"".equals(rln))&&(!"".equals(bst))&&(!"".equals(bbt))&&(!"".equals(st))&&(!"".equals(ed))){
			try {
				rm=servicerm.readbyname(rmn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Role=servicerl.readbyname(rln);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bst=bst+" 00:00:00";
			bbt=bbt+" 23:59:59";
			st=st+" 00:00:00";
			ed=ed+" 23:59:59";
			Timestamp time1=Timestamp.valueOf(bst);
			Timestamp time2=Timestamp.valueOf(bbt);
			Timestamp time3=Timestamp.valueOf(st);
			Timestamp time4=Timestamp.valueOf(ed);
			Meeting=new ArrayList();
			sql="select * from meeting where role_id=? and room_id=? and meeting_name=? and booktime>=? and booktime<=? and starttime>=? and endtime<=?";
			List<Meeting> mm=null;
			for(int i=0;i<Role.size();i++){
				mm=servicem.readbydetails(sql, new Object[]{Role.get(i).getRole_id(),rm.getRoomid(),mn,time1,time2,time3,time4});
				for(int j=0;j<mm.size();j++){
					Meeting.add(mm.get(j));
				}
			}
		}else{
			Meeting=new ArrayList();
			JOptionPane.showMessageDialog(null, "无效的查询方式，请重新输入！","alert",JOptionPane.ERROR_MESSAGE);
		}
		for(int i=0;i<Meeting.size();i++){
			try {
				String s1=servicerm.ReadById(Meeting.get(i).getRoom_id()).getRoomname();
				String s2=servicerl.getRightUser(Meeting.get(i).getRole_id()).getRole_name();
				m=Meeting.get(i);
				m.setRolename(s2);
				m.setRoomname(s1);
				Meeting.set(i, m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		PageBean pagebean=new PageBean(Meeting.size());//初始化PageBean对象   
		pagebean.setCurPage(pageindex); //这里page是从页面上获取的一个参数，代表页数  
		int firstIndex=(pageindex-1)*6;  	//获得分页数据在list集合中的索引  
		int toIndex=pageindex*6;  
		if(toIndex>Meeting.size()){  
		    toIndex=Meeting.size();  
		}  
		if(firstIndex>toIndex){  
		    firstIndex=0;  
		    pagebean.setCurPage(1);  
		}  
		List courseList=Meeting.subList(firstIndex, toIndex);  	//截取数据集合，获得分页数据  
		req.setAttribute("current", pageindex);
		req.setAttribute("meetings", courseList);
		all_count=Meeting.size();
		req.setAttribute("all", all_count);
		req.setAttribute("pages", (int)Math.ceil(all_count*1.0/6));
		req.getRequestDispatcher("/meetingorder/search_meeting.jsp").forward(req, resp);
	}


}
