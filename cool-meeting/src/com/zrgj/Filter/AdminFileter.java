package com.zrgj.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.zrgj.POJO.Role;

@WebFilter(urlPatterns={"/roleManage/*"})
public class AdminFileter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpSession session=req.getSession();
		Role emp=(Role) session.getAttribute("admin");
		//判断用户信息以及用户的角色权限是否是管理员
		if(emp!=null && emp.getRole_status()==0){
			arg2.doFilter(arg0, arg1);
		}else{
			//如果是非登录用户或者没有管理员权限则跳转到登录页面
			HttpServletResponse resp=(HttpServletResponse)arg1;
			/*resp.sendRedirect(req.getContextPath()+"/welcome.jsp");*/
			req.getRequestDispatcher("null.jsp").forward(req, resp);
			JOptionPane.showMessageDialog(null, "您没有权利进入！");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
