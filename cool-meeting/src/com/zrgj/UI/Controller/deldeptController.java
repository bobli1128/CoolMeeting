package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.departmentService;
@WebServlet(value={"/roleManage/deptdel.do"})
public class deldeptController extends HttpServlet {
	private departmentService service=new departmentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int deptid=Integer.parseInt(req.getParameter("id"));
		try {
			service.DeleteDept(deptid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/roleManage/deptshow.do");
	}
}
