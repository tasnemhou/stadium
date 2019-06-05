package service;

import dao.LoginDao;
import dao.LoginDaoImpl;
import dao.RegistDao;
import dao.RegistDaoImpl;
import entity.Customer;
import entity.DealInfo;
import entity.User;
import util.Util;

public class RegistServiceImpl implements RegistService {

	RegistDao dao = new RegistDaoImpl();
	
	@Override
	public void regist(User user) {
		String pwd = Util.getMd5(user.getPwd());
		user.setPwd(pwd);
		
		dao.regist(user);
	}
	
	@Override
	public void regist(Customer customer, DealInfo dealInfo) {
		
		String pwd = Util.getMd5(customer.getPwd());
		customer.setPwd(pwd);
		
		dao.regist(customer, dealInfo);
	}

}
