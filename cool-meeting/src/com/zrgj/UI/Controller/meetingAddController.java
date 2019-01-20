package com.zrgj.UI.Controller;

import java.io.IOException;
import java.sql.Timestamp;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.codehaus.jackson.map.ObjectMapper;

import com.zrgj.BLL.MeetingService;
import com.zrgj.BLL.MemberService;
import com.zrgj.BLL.RoomService;

import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.Role;
import com.zrgj.POJO.Room;

@WebServlet(value={"/meeting/add.do"})
public class meetingAddController extends HttpServlet {

	private MeetingService service=new MeetingService();
	private RoomService service2=new RoomService();
	private MemberService service3=new MemberService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(req.getParameter("meeting_name"));
//		if((!req.getParameter("meeting_name").equals(""))&&(!req.getParameter("room_id").equals(""))&&(!req.getParameter("meeting_number").equals(""))&&(!req.getParameter("starttimedate").equals(""))&&(!req.getParameter("starttimetime").equals(""))&&(!req.getParameter("endtimedate").equals(""))&&(!req.getParameter("endtimetime").equals(""))&&(!req.getParameter("meeting_notes").equals(""))){
			String meeting_name=req.getParameter("meeting_name");
			int room_id=Integer.parseInt(req.getParameter("room_id"));
/*			String room_state=service2.getRoombyid(room_id).getRoom_state();
			int room_capacity=service2.getRoombyid(room_id).getRoom_capacity();*/
			/*Room R=new Room();
			R=service2.getRoombyid(room_id);
			req.setAttribute("room", R);*/
			int meeting_number=Integer.parseInt(req.getParameter("meeting_number"));
			String starttimedate=req.getParameter("starttimedate");
			String starttimetime=req.getParameter("starttimetime");
			String endtimedate=req.getParameter("endtimedate");
			String endtimetime=req.getParameter("endtimetime");
			String starttime=starttimedate+" "+starttimetime+":00";
			String endtime=endtimedate+" "+endtimetime+":00";
			Timestamp StartTime=Timestamp.valueOf(starttime);
			Timestamp EndTime=Timestamp.valueOf(endtime);
			int meeting_state=1;
			/*try {
				List<meeting> list=service.getMeeting(room_id);
				for(int i=0;i<list.size();i++){
					if(StartTime.getTime()<=list.get(0).getStarttime().getTime()&&EndTime.getTime()>=list.get(0).getEndtime().getTime()){
						JOptionPane.showMessageDialog(null, "该时间段会议室有其他会议","alert",JOptionPane.ERROR_MESSAGE);
						resp.sendRedirect(req.getContextPath()+"/meeting/bookmeeting.jsp");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
			HttpSession session=req.getSession(false);
			Role r=(Role) session.getAttribute("admin");
			int role_id=r.getRole_id();
			String meeting_notes=req.getParameter("meeting_notes");
			Timestamp booktime=new Timestamp(System.currentTimeMillis());
			/*if(EndTime.getTime()<StartTime.getTime()){
				JOptionPane.showMessageDialog(null, "预计结束时间早于预计开始时间","alert",JOptionPane.ERROR_MESSAGE);
//				resp.sendRedirect(req.getContextPath()+"/meeting/bookmeeting.jsp");
			}*/
			/*else if("0".equals(room_state)){
				JOptionPane.showMessageDialog(null, "会议室停用","alert",JOptionPane.ERROR_MESSAGE);
//				resp.sendRedirect(req.getContextPath()+"/meeting/bookmeeting.jsp");
			}
			else if(room_capacity<meeting_number){
				JOptionPane.showMessageDialog(null, "参会人数超过会议室容纳上限","alert",JOptionPane.ERROR_MESSAGE);
//				resp.sendRedirect(req.getContextPath()+"/meeting/bookmeeting.jsp");
			}*/
			//else{
				Meeting m=new Meeting();
				m.setMeeting_name(meeting_name);
				m.setRoom_id(room_id);
				m.setMeeting_number(meeting_number);
				m.setStartime(StartTime);
				m.setEndtime(EndTime);
				m.setBooktime(booktime);
				m.setMeeting_state(meeting_state);
				m.setMeeting_notes(meeting_notes);
				m.setRole_id(role_id);
				int MEETING_ID=service.CreateNewMeeting(m);
				resp.sendRedirect(req.getContextPath()+"/meetingorder/adddepartmentandroom.do");
				String meetingmember[]=req.getParameterValues("selSelectedEmployees");
				Member M=new Member();
				for(int j=0;j<meetingmember.length;j++){
					int p=Integer.parseInt(meetingmember[j]);
					M.setRole_id(p);
					M.setMeeting_id(MEETING_ID);
					service3.CreateNewMember(M);
				}
				
			//}
//		}
/*		else{
			JOptionPane.showMessageDialog(null, "填写信息不完整","alert",JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/meeting/bookmeeting.jsp");
		}*/
		
		
		
	}
	
}
