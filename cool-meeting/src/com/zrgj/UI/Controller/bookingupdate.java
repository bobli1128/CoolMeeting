package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.zrgj.BLL.MeetingService;
@WebServlet(value={"/myself/bookingupdate.do"})
public class bookingupdate extends HttpServlet {
	private MeetingService service=new MeetingService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String reason=req.getParameter("reason");
		if(!"".equals(reason)) service.UpdateOldUser(0, id,reason);
		else JOptionPane.showMessageDialog(null, "请输入撤销理由！","alert",JOptionPane.ERROR_MESSAGE);
		resp.sendRedirect(req.getContextPath()+"/myself/mybookingshow.do");
	}

}
