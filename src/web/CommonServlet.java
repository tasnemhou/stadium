package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import entity.Dictionary;
import service.CommonService;
import service.CommonServiceImpl;

public class CommonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(CommonServlet.class);
	
	CommonService service = new CommonServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		
		if("/jsp/getDic.do".equals(path)) {
			List<Dictionary> list = service.getDic();
			req.setAttribute("dictionary", list);
			req.getRequestDispatcher("regist_customer.jsp").forward(req, res);
			log.info(list);
		}
	}
}
