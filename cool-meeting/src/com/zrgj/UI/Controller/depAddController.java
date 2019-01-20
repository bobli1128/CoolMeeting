package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.zrgj.BLL.departmentService;
import com.zrgj.POJO.department;
@WebServlet(value={"/roleManage/deptadd.do"})
public class depAddController extends HttpServlet {
	private departmentService service=new departmentService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String deptname=req.getParameter("deptname");
		department d=null;
		try {
			d=service.readbyname(deptname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(d!=null){
			System.out.println(d.getDep_name());
			JOptionPane.showMessageDialog(null, "该部门已存在，请重新输入！","alert",JOptionPane.ERROR_MESSAGE);
		}
//		if(!d.getDep_name().equals(deptname)) service.CreateNewDept(deptname);
		else{
			 service.CreateNewDept(deptname);
		}
		resp.sendRedirect(req.getContextPath()+"/roleManage/deptshow.do");
	}

}
