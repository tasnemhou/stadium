package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;
import service.UserInfoService;
import service.UserInfoServiceImpl;

public class UserInfoServlet extends HttpServlet{
	private static final long serialVersionUID = 3311468728658233434L;
	Logger log = Logger.getLogger(UserInfoServlet.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		log.info(path);
		UserInfoService service = new UserInfoServiceImpl();
		if("/jsp/getPhone.info".equals(path)) {
			int count = service.getPhoneNo(req.getParameter("phone"));
			JSONObject obj = JSONObject.fromObject("{'isRight':"+count+"}"); 
			PrintWriter pw = res.getWriter();
			pw.println(obj);
			pw.close();
		}
		
	}
}
