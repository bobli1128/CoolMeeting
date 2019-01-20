package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.RoomService;
import com.zrgj.POJO.Room;

@WebServlet(value={"/meetingorder/roomshow.do"})
public class roomShow extends HttpServlet {
	private RoomService service=new RoomService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("rooms", service.readall());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/meetingorder/bookingmeeting.jsp").forward(req, resp);
	}

}
