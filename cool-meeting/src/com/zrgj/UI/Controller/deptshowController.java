package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.departmentService;
@WebServlet(value={"/roleManage/deptshow.do"})
public class deptshowController extends HttpServlet {
	private departmentService service=new departmentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("depts", service.getAllDept());
		req.getRequestDispatcher("/roleManage/dep_manage.jsp").forward(req, resp);
	}
	

}
