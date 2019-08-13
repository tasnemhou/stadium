package service;

import org.apache.commons.lang.StringUtils;

import dao.LoginDao;
import dao.LoginDaoImpl;
import entity.User;
import util.Util;

public class LoginServiceImpl implements LoginService {

	LoginDao dao = new LoginDaoImpl();
	
	public String checkUser(User user) {
		String password = Util.getMd5(user.getPwd());
		//0-正确  1-用户名或密码不正确或用户不存在
		String userName = dao.checkUser(password);
		String res = "0"; 
		if(StringUtils.isBlank(userName)||(!user.getUserName().equals(userName))) {
			res = "1";
		}
		return res;
	}

	@Override
	public int chkCustomer(String phone) {
		int count = dao.chkCustomer(phone);
		return count;
	}
	
}
