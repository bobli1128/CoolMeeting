package com.zrgj.UI.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.zrgj.BLL.RoomService;
import com.zrgj.POJO.Room;

@WebServlet(value="/meeting/searchroombyroomid.do")
public class searchroombyroomidController extends HttpServlet {
	private RoomService service=new RoomService();
	private ObjectMapper objmapper=null;
	public searchroombyroomidController(){
		objmapper=new ObjectMapper();
		objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
		objmapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss"));
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int room_id=Integer.parseInt(req.getParameter("roomID"));
		/*int meeting_number=Integer.parseInt(req.getParameter("Meeting_Number"));*/
		Room R=new Room();
		R=service.getRoombyid(room_id);
		String jsonstr=objmapper.writeValueAsString(R);
		resp.getWriter().println(jsonstr);
	}
	

}
