package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import common.Alert;
import entity.Customer;
import entity.DealInfo;
import entity.User;
import service.RegistService;
import service.RegistServiceImpl;

public class RegistServlet extends HttpServlet{
	private static final long serialVersionUID = -2262171915996965667L;
	Logger log = Logger.getLogger(RegistServlet.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		log.info(path);
		RegistService service = new RegistServiceImpl();
		
		if("/jsp/regist.re".equals(path)) {
			User user = new User();
			//注册员工
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
			
		}else if("/jsp/cus_reg.re".equals(path)) {
			//注册客户
			Customer customer = new Customer();
			customer.setName(req.getParameter("name"));
			customer.setPhone(req.getParameter("phone"));
			customer.setPwd(req.getParameter("pwd"));
			customer.setRegistDate(req.getParameter("registDt"));
			customer.setSex(req.getParameter("sex"));
			
			DealInfo info = new DealInfo();
			info.setDealAmount(Double.valueOf(req.getParameter("amount")));
			info.setDealTimes(Integer.valueOf(req.getParameter("dealTimes")));
			info.setCustomerType(req.getParameter("customerType"));
			service.regist(customer, info);
		}
	}
}
