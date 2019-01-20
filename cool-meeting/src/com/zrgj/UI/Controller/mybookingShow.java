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

import com.zrgj.BLL.MeetingService;
import com.zrgj.BLL.RoomService;
import com.zrgj.POJO.Meeting;
import com.zrgj.POJO.Role;
import com.zrgj.POJO.Room;
@WebServlet(value={"/myself/mybookingshow.do"})
public class mybookingShow extends HttpServlet {
	private MeetingService service1=new MeetingService();
	private RoomService service2=new RoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Meeting m=null;
		List<Meeting> m1=null;
		Room r=new Room();
		int roomid=0;
		HttpSession session=req.getSession(true);
		Role rl=(Role) session.getAttribute("admin");
		int id=rl.getRole_id();
		m1=service1.readbyroleid(id);
		List<Meeting> m2=new ArrayList();
		Timestamp nowtime=new Timestamp(System.currentTimeMillis());
		for(int i=0;i<m1.size();i++){
		try {
			if(m1.get(i).getMeeting_state()!=0&&m1.get(i).getStartime().getTime()>nowtime.getTime()){
			m=m1.get(i);
			roomid=m1.get(i).getRoom_id();
			r=service2.ReadById(roomid);
			String s=r.getRoomname();
			m.setRoomname(s);
			m2.add(m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		req.setAttribute("mybookings", m2);
		req.getRequestDispatcher("/myself/mybooking.jsp").forward(req, resp);
	}

}
