package com.zrgj.UI.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import com.zrgj.BLL.RoomService;
import com.zrgj.BLL.departmentService;
import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Member;
import com.zrgj.POJO.Role;
import com.zrgj.POJO.Room;
@WebServlet(value={"/myself/meetshow1.do"})
public class GetMeetIdByRoleIdController extends HttpServlet {
	private MemberService service=new MemberService();
	private MeetingService service1=new MeetingService();
	private RoomService service2=new RoomService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*int RoleId=Integer.parseInt(req.getParameter("id"));*/
		HttpSession session=req.getSession();
		Role temp=(Role) session.getAttribute("admin");
		int RoleId=temp.getRole_id();
		
		List<Member> temps= new ArrayList<Member>();//����meet-id������member��
		List<Meeting> meets=new ArrayList<Meeting>();//�����7����Ҫ�μӵ�����meet
		List<Meeting> cancelmeet=new ArrayList<Meeting>();//δ����ȡ���Ļ���
		Meeting temp_meet=null;//��ʱһ�е�meet
		Room room=null;
		String roomname="";
		Date date = new Date();       
		Timestamp curtime = new Timestamp(date.getTime());//��ǰʱ��
		int tempmeetid=0;
			try {
				temps=service.getTempsByRoleId(RoleId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*req.setAttribute("meets", service.getTempsByRoleId(RoleId));*/
		for(int i=0;i<temps.size();i++){
			tempmeetid=temps.get(i).getMeeting_id();//�õ�meet-id
			try {
				temp_meet=service1.GetById(tempmeetid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				room=service2.ReadById(temp_meet.getRoom_id());
			} catch (Exception e) {
				e.printStackTrace();
			}//��ʱroomһ��
			long bet=temp_meet.getStartime().getTime()-curtime.getTime();
			int ii = Integer.parseInt(String.valueOf(bet/86400000)); 
			if(ii<7&&temp_meet.getStartime().getTime()>curtime.getTime()&&temp_meet.getMeeting_state()==1)
			{
				roomname=room.getRoomname();
				temp_meet.setRoom_name(roomname);
				meets.add(temp_meet);	
			}
			if(ii>0&&temp_meet.getMeeting_state()==0)
			{
				roomname=room.getRoomname();
				temp_meet.setRoom_name(roomname);
				cancelmeet.add(temp_meet);	
			}
		}
/*		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ  
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ�� */		
		req.setAttribute("meets", meets);
		req.setAttribute("canceleeets", cancelmeet);
		req.getRequestDispatcher("/myself/notification.jsp").forward(req, resp);
	}
	
}
