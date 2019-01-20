package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;


import com.zrgj.BLL.RoleService;
import com.zrgj.BLL.departmentService;

import com.zrgj.POJO.Role;
import com.zrgj.POJO.department;


@WebServlet(value="/meeting/searchrolebydepartment.do")
public class searchrolebydepartment extends HttpServlet {

	private RoleService service=new RoleService();
	private departmentService service1=new departmentService();
	private ObjectMapper objmapper=new ObjectMapper();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int depa_id=Integer.parseInt(req.getParameter("locationdepa"));
		department d=new department();
		d=service1.getDeptById(depa_id);
		String depa_name=d.getDep_name();
		List<Role> list=service.getrolebydepartmentname(depa_name);
		objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
		objmapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		String jsonstr=objmapper.writeValueAsString(list);
		resp.getWriter().print(jsonstr);
	}
	
	
}
