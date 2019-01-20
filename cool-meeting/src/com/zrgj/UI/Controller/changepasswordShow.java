package com.zrgj.UI.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.zrgj.BLL.RoleService;
import com.zrgj.POJO.Role;
@WebServlet(value={"/myself/pwdup.do"})
public class changepasswordShow extends HttpServlet {
    private RoleService service=new RoleService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldpwd=req.getParameter("oldpwd");
		String newpwd=req.getParameter("newpwd");
		String confirm=req.getParameter("confirmnewpwd");
		int id=Integer.parseInt(req.getParameter("rightuser"));
		Role t=new Role();
		t=service.getRightUser(id);
		String realpwd=t.getRole_password();
		if(oldpwd==null||newpwd==null||confirm==null){
			req.setAttribute("message1", "�뽫��Ϣ��д������");
			req.getRequestDispatcher("changpassword.jsp").forward(req, resp);
		}
		if(!(realpwd.equals(oldpwd))&&(newpwd.equals(confirm))){
			req.setAttribute("message1", "�������������");
			req.getRequestDispatcher("changpassword.jsp").forward(req, resp);
		}
	    if(!(newpwd.equals(confirm))&&realpwd.equals(oldpwd)){
			req.setAttribute("message2", "��������ȷ�������벻һ�£�");
			req.getRequestDispatcher("changpassword.jsp").forward(req, resp);
		}
	    if(!(realpwd.equals(oldpwd))&&!(newpwd.equals(confirm))){
	    	req.setAttribute("message1", "�������������");
	    	req.setAttribute("message2", "��������ȷ�������벻һ�£�");
	    	req.getRequestDispatcher("changpassword.jsp").forward(req, resp);
	    }
		if((realpwd.equals(oldpwd))&&(newpwd.equals(confirm))){
			Role tt=new Role();
			tt.setRole_id(id);
			tt.setRole_password(newpwd);
//			System.out.println(tt.getRole_id());
//			System.out.println(tt.getRole_password());
			service.UpdateOldUser(tt);
//			req.setAttribute("message1", "�޸ĳɹ���");
			
			JOptionPane.showMessageDialog(null, "�������޸ģ������µ�¼��","alert",JOptionPane.ERROR_MESSAGE);
//			req.getRequestDispatcher("changpassword.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
		}
	}
    
}
