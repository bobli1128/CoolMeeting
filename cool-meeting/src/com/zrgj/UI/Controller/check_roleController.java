package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zrgj.BLL.RoleService;

@WebServlet(value={"/roleManage/check.do"})
public class check_roleController extends HttpServlet {
	private RoleService service=new RoleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles", service.getUncheckedRoles());	
		req.getRequestDispatcher("/roleManage/check_people.jsp").forward(req, resp);
	}
}
