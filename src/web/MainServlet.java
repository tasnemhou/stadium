package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import common.Alert;
import entity.Dictionary;
import entity.User;
import service.Service;
import service.ServiceImpl;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(MainServlet.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res.setContentType("text/html");
//		res.setContentType("text/html;charset=utf-8");
		/*PrintWriter pw = res.getWriter();
		pw.println("<h1>2018/8/6</h1>");
		pw.close(); */
		
		
//		req.getRequestDispatcher("/test1.jsp").forward(req, res);
		
		String path = req.getServletPath();
		log.info("psth is: "+path);
		Service service = new ServiceImpl();
		
		User user = new User();
		log.info("BEGIN: ");
		
		//加过滤器、日志(OK)，权限管理，处理异常
		if("/jsp/getDic.do".equals(path)) {
			List<Dictionary> list = service.getDic();
			req.setAttribute("dictionary", list);
			req.getRequestDispatcher("regist_customer.jsp").forward(req, res);
			log.info(list);
		}else if("/jsp/login.do".equals(path)) {
			req.getRequestDispatcher("jsp/login.jsp").forward(req, res);
		}else if("/jsp/login_main.do".equals(path)) {
			String name = req.getParameter("userName");
			String pwd = req.getParameter("pwd");
			
			user.setUserName(name);
			user.setPwd(pwd);
			String isRight = service.checkUser(user);
			//0-正确  1-此用户不存在！ 2-用户名不正确！3-密码不正确
			if ("0".equals(isRight)) {
				req.getRequestDispatcher("jsp/login.jsp").forward(req, res);
			}else if("1".equals(isRight)) {
				
			}else if("2".equals(isRight)) {
				
			}else if("3".equals(isRight)) {
				
			}else {
				req.getRequestDispatcher("customer.jsp").forward(req, res);
			}
		}else if("/jsp/regist.do".equals(path)) {
			user.setUserName(req.getParameter("userName"));
			user.setPwd(req.getParameter("pwd"));
			user.setPhone(req.getParameter("phone"));
			String sex = req.getParameter("sex");
			user.setSex(sex.charAt(0));
			String level = req.getParameter("level");
			user.setLevel(level.charAt(0));
			//注册保存
			service.regist(user);
			
			String s = Alert.SAVESUC;
			
		}else if("/jsp/cus_login.do".equals(path)) {
			req.getRequestDispatcher("main_page.jsp").forward(req, res);
		}
		log.info("END: ");
	}
}
