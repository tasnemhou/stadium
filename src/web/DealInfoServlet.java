package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import entity.Customer;
import entity.DealInfo;
import net.sf.json.JSONObject;
import service.DealDetailInfoService;
import service.DealDetailInfoServiceImpl;
import util.DateUtil;
import util.NumberUtil;

public class DealInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(DealInfoServlet.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log.info("BEGIN:");
		String path = req.getServletPath();
		DealDetailInfoService service = new DealDetailInfoServiceImpl();
		if("/jsp/DealDetail.deal".equals(path)) {
			DealInfo info = new DealInfo();
			//交易明细查询 
			info.setCustomerId(req.getParameter("customerId"));
			info.setPageNumber(Integer.valueOf(req.getParameter("pageNumber")));
			info.setPageSize(Integer.valueOf(req.getParameter("pageSize")));
			System.out.println("pageNumber is: "+req.getParameter("pageNumber"));;
			System.out.println("pageSize is: "+req.getParameter("pageSize"));;
			List<Map<String, Object>> list = service.getDealDetailInfo(info);
			
			JSONObject obj = new JSONObject();
			obj.put("list", list);
			obj.put("count", 5);
			
			log.info(obj.toString());
			PrintWriter pw = res.getWriter();
	
			pw.print(obj.toString());
			pw.close();
			
		}else if("/jsp/customer.deal".equals(path)) {
			String phone = req.getParameter("phone");
			Map<String, Object> map = service.getUserDealInfo(phone);
			JSONObject obj = new JSONObject();
			obj.put("userInfo", map);
			
			PrintWriter writer = res.getWriter();
			writer.print(obj.toString());
			writer.close();
		}else if("/jsp/customerDeal.deal".equals(path)) {
			DealInfo info = new DealInfo();
			Customer cus = new Customer();
			info.setIsPay(req.getParameter("isPay"));
			info.setCustomerType(req.getParameter("customerType") );
			cus.setBegDate(req.getParameter("begDt").replaceAll("-", ""));
			cus.setEndDate(req.getParameter("endDt").replaceAll("-", ""));
			cus.setLastTimes(NumberUtil.parseInteger(req.getParameter("lastTimes")));
			info.setCustomer(req.getParameter("customer"));
			info.setKind(req.getParameter("dealKind"));
			info.setDealTimes(NumberUtil.parseInteger(req.getParameter("dealTimes")) );
			info.setDealType(req.getParameter("dealType") );
			info.setDealAmount(NumberUtil.parseDouble(req.getParameter("amount")) );
			
			info.setCustomerId(req.getParameter("customerId") );
//			info.setBalance(NumberUtil.parseInteger(req.getParameter("balance")) );
			info.setDealDt(DateUtil.getCurrentDate());
			
			int i = service.insertDealInfo(info,cus);
			JSONObject obj = JSONObject.fromObject("{'i':"+i+"}");
			
			PrintWriter writer = res.getWriter();
			writer.print(obj);
			writer.close();
		}
		
		log.info("END");
	}
}
