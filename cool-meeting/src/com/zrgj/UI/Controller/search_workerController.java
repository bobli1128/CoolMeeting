package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


import com.zrgj.BLL.RoleService;
import com.zrgj.POJO.Role;

@WebServlet(value = { "/search.do" })
public class search_workerController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private RoleService service = new RoleService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n=req.getParameter("search_name");
		String u=req.getParameter("search_username");
		String s=req.getParameter("status");
		String pageStr = req.getParameter("pages");
		List<Role> clist=null;
		int all_count=0;
		Role r=new Role();
		int pageindex=1;
		if(pageStr!=null){   //获得页面的session
			if(pageStr.equals("")){
				pageindex=1;
			}else{
				pageindex = Integer.parseInt(pageStr);
			}
			req.getSession().setAttribute("pageindex", pageindex);
		}else{
			pageindex=1;
			req.getSession().setAttribute("pageindex", pageindex);
		}
		if(s!=null){   //获得状态信息的session
			int statuss = Integer.parseInt(s);
			req.getSession().setAttribute("statuss", statuss);
		}else{
			HttpSession session=req.getSession(true);
			Object ss=session.getAttribute("statuss");
			s=ss.toString();
//			System.out.println(s);
		}
		if(u!=null){   //获得账户名的session
			req.getSession().setAttribute("username", u);
		}else{
			HttpSession session=req.getSession(true);
			Object uu=session.getAttribute("username");
			u=uu.toString();
		}
		if(n!=null){   //获得用户名的session
			req.getSession().setAttribute("name", n);
		}else{
			HttpSession session=req.getSession(true);
			Object nn=session.getAttribute("name");
			n=nn.toString();
		}
		
		int start = (pageindex-1)*6;
		if((n.equals(""))&&(u.equals(""))){  //用于选择方面
			if(s!=null){
				int statuss = Integer.parseInt(s);
				clist=service.getEmpbyStatus(statuss,start);
				all_count=service.pagecount_s(statuss);
			}
		}
		else{  //用于填写信息
			if(!(n.equals(""))&&u.equals("")){  //有名字
				r.setRole_name(n);
				clist=service.search_n(r,start);
				all_count=service.pagecount(2, r);
			}else if((n.equals(""))&&!u.equals("")){  //有用户名
				r.setRole_username(u);
				clist=service.search_u(r,start);
				all_count=service.pagecount(3, r);
			}else if(!(n.equals(""))&&!(u.equals(""))){ //都写了
				r.setRole_name(n);
				r.setRole_username(u);
				clist=service.search(r,start);
				all_count=service.pagecount(1, r);
			}else{
			}
		}
		
		req.setAttribute("total_page", all_count);	
		req.setAttribute("current_page", pageindex);	
		req.setAttribute("pages", (int)Math.ceil(all_count*1.0/6));	
		req.setAttribute("search_worker", clist);
		req.getRequestDispatcher("/roleManage/search_worker.jsp").forward(req, resp);
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
