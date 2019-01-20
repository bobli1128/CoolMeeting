package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.BLL.departmentService;
import com.zrgj.POJO.department;
@WebServlet(value={"/roleManage/deptupd.do"})
public class upddeptController extends HttpServlet {
	private departmentService service=new departmentService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deptname=req.getParameter("departmentname");
		int deptid=Integer.parseInt(req.getParameter("departmentid"));
		department dept=new department();
		dept.setDep_id(deptid);
		dept.setDep_name(deptname);
		service.UpdateDept(dept);
		resp.sendRedirect(req.getContextPath()+"/roleManage/deptshow.do");
		
		
		
	}
	

}
