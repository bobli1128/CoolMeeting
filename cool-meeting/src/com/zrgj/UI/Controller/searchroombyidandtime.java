package com.zrgj.UI.Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.zrgj.BLL.MeetingService;

import com.zrgj.POJO.Meeting;




@WebServlet(value="/meeting/searchroombyidandtime.do")
public class searchroombyidandtime extends HttpServlet {

	private MeetingService service=new MeetingService();
	private ObjectMapper objmapper=null;
	public searchroombyidandtime(){
		objmapper=new ObjectMapper();
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int meeting_number=Integer.parseInt(req.getParameter("RoomID"));
		int meeting_state=1;
		String starttimedate=req.getParameter("Start_d");
		/*String starttimetime=req.getParameter("Start_t");*/
		String endtimedate=req.getParameter("End_d");
		/*String endtimetime=req.getParameter("End_t");*/
		String starttime=starttimedate+" 00:00:00";
		String endtime=endtimedate+" 23:59:59";
		Timestamp StartTime=Timestamp.valueOf(starttime);
		Timestamp EndTime=Timestamp.valueOf(endtime);
		List<Meeting> list=service.getMeetingByTime(meeting_number,meeting_state, starttime,endtime);
		objmapper.setSerializationInclusion(Inclusion.NON_EMPTY);
		objmapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		objmapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		String jsonstr=objmapper.writeValueAsString(list);
		resp.getWriter().print(jsonstr);
	}
	
}
