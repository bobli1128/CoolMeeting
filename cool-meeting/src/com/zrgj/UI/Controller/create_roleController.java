package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.zrgj.BLL.RoleService;
import com.zrgj.POJO.Role;


@WebServlet(value={"/create.do"})
public class create_roleController extends HttpServlet {
	private RoleService service=new RoleService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("create_role_name");
		String username=req.getParameter("create_role_username");
		if(service.check_username(username)==null){
			String pwd=req.getParameter("create_role_password");
		String tele=req.getParameter("create_role_tele");
		String mail=req.getParameter("create_role_mail");
		String dep=req.getParameter("create_role_dep");
		Role r=new Role();
		r.setRole_name(name);
		r.setRole_username(username);
		r.setRole_password(pwd);
		r.setRole_tele(tele);
		r.setRole_mail(mail);
		r.setRole_dep(dep);
		r.setRole_status(2);
		service.create(r);
		resp.sendRedirect(req.getContextPath()+"/roleManage/createrole_dep.do");
		}else{
			JOptionPane.showMessageDialog(null, "该用户名已经被注册过，请重新输入！","alert",JOptionPane.ERROR_MESSAGE);
			resp.sendRedirect(req.getContextPath()+"/roleManage/createrole_dep.do");
		}
		
	}
}
