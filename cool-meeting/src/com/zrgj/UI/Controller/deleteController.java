package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.RoleService;
@WebServlet(value={"/delete.do"})
public class deleteController extends HttpServlet {
	private RoleService service=new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("role_username");
		service.delete(username);
		resp.sendRedirect(req.getContextPath()+"/roleManage/check.do");
	}
	
}
