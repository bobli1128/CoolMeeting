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

import com.zrgj.BLL.RoomService;
import com.zrgj.POJO.Room;
@WebServlet(value={"/meetingorder/roomshowbyid.do"})
public class roomShowbyid extends HttpServlet {
	private RoomService service=new RoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Room r=service.ReadById(Integer.parseInt(req.getParameter("id")));
			if(r.getRoomstate().equals("0")) r.setRoomstate("∆Ù”√");
			else if(r.getRoomstate().equals("1")) r.setRoomstate("Õ£”√");
			else if(r.getRoomstate().equals("2")) r.setRoomstate("…æ≥˝");
			req.setAttribute("room", r);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/meetingorder/meetingdetail.jsp").forward(req, resp);
	}

}
