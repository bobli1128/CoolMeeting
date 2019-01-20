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
@WebServlet(value={"/loginshow.do"})
public class RoleLoginController extends HttpServlet {
	private RoleService service=new RoleService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String mima=req.getParameter("code");
		Role t=new Role();
		t.setRole_username(username);
		t.setRole_password(mima);
		Role emp=null;
		try {
			emp = service.login(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(emp!=null){
			HttpSession session=req.getSession(true);
			session.setAttribute("admin", emp);
     		resp.sendRedirect(req.getContextPath()+"/index.jsp");
		}
		else{
//			req.setAttribute("message", "输入的信息存在问题，请重新输入！");
			JOptionPane.showMessageDialog(null, "输入的信息存在问题，请重新输入！！","alert",JOptionPane.ERROR_MESSAGE);
			/*resp.sendRedirect(req.getContextPath()+"/welcome.jsp");*/
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
		}
	}
}
