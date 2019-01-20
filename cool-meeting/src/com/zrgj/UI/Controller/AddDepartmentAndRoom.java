package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.RoomService;
import com.zrgj.BLL.departmentService;

@WebServlet(value={"/meetingorder/adddepartmentandroom.do"})
public class AddDepartmentAndRoom extends HttpServlet {

	private departmentService service1=new departmentService();
	private RoomService service2=new RoomService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("department", service1.getAllDept());
		req.setAttribute("room", service2.getAllRoom());
	
		req.getRequestDispatcher("/meetingorder/meetingbook.jsp").forward(req, resp);
	}
	
	
}
