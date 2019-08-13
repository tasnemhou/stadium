package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import entity.User;
import net.sf.json.JSONObject;
import service.LoginService;
import service.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(LoginServlet.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res.setContentType("text/html");
//		res.setContentType("text/html;charset=utf-8");
		/*PrintWriter pw = res.getWriter();
		pw.println("<h1>2018/8/6</h1>");
		pw.close(); */
		
//		req.getRequestDispatcher("/test1.jsp").forward(req, res);
		
		String path = req.getServletPath();
		log.info("path is: "+path);
		LoginService service = new LoginServiceImpl();
		
		User user = new User();
		log.info("BEGIN: ");
		
		//加过滤器、日志(OK)，权限管理，处理异常
		if("/jsp/login.do".equals(path)) {
			req.getRequestDispatcher("jsp/login.jsp").forward(req, res);
		}else if("/jsp/login_main.do".equals(path)) {
			String name = req.getParameter("userName");
			String pwd = req.getParameter("pwd");
			
			user.setUserName(name);
			user.setPwd(pwd);
			String isRight = service.checkUser(user);
			System.out.println("isRight is: "+isRight);
			//0-正确  1-用户不存在或密码不正确！ 2-用户名不正确！
//				req.getRequestDispatcher("customer.jsp").forward(req, res);
				//如果没有查到客户，
			JSONObject object = JSONObject.fromObject("{'user':"+isRight+"}");
			
			PrintWriter pw = res.getWriter();
			pw.println(object);
			pw.close();
		}if("/jsp/cus_login.do".equals(path)) {
			String phone = req.getParameter("phone");	
			
			int count =  service.chkCustomer(phone);
//			req.setAttribute("phone","12100000000");
			JSONObject object = JSONObject.fromObject("{'isExist':"+count+"}");
			PrintWriter pw = res.getWriter();
			pw.println(object);
			pw.close();
//			req.getRequestDispatcher("/jsp/main_page.jsp").forward(req, res);
		}
		log.info("END: ");
	}
}
