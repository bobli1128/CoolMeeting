package com.zrgj.UI.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.zrgj.BLL.RoomService;
import com.zrgj.POJO.Room;
@WebServlet(value={"/roleManage/roomadd.do"})
public class roomadd extends HttpServlet {
	private RoomService service=new RoomService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out:if(!req.getParameter("door").equals("")&&!req.getParameter("name").equals("")&&!req.getParameter("hold").equals("")&&!req.getParameter("status").equals("")){
			String door=req.getParameter("door");
			String cap=req.getParameter("hold");
			for(int i=0;i<door.length();i++){
				if(!Character.isDigit(door.charAt(i))){
					JOptionPane.showMessageDialog(null, "会议室门牌号为整数，请重新输入！","alert",JOptionPane.ERROR_MESSAGE);
					break out;
				}
				
			}
			for(int i=0;i<cap.length();i++){
				if(!Character.isDigit(cap.charAt(i))){
					JOptionPane.showMessageDialog(null, "会议容纳人数为整数，请重新输入！","alert",JOptionPane.ERROR_MESSAGE);
					break out;
				}
				
			}
			int id=Integer.parseInt(req.getParameter("door"));
			String name=req.getParameter("name");
			int hold=Integer.parseInt(req.getParameter("hold"));
			String state=req.getParameter("status");
			String notes=req.getParameter("note");
			Room r=new Room();
			r.setRoomid(id);
			r.setRoomname(name);
			r.setCapacity(hold);
			r.setRoomstate(state);
			r.setNotes(notes);
			
			List<Room> rrrr=null;
			try {
				rrrr = service.readall();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(Room m:rrrr){
				if(m.getRoomid()==id){
					JOptionPane.showMessageDialog(null, "该会议室已存在，请重新输入！","alert",JOptionPane.ERROR_MESSAGE);
					break out;
				}
			}
			
			try {
				service.insert(r);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "无效的添加信息，请重新输入！","alert",JOptionPane.ERROR_MESSAGE);
		}
		req.getRequestDispatcher("/roleManage/addmeeting.jsp").forward(req, resp);
	}

}
