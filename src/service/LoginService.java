package service;

import entity.User;

public interface LoginService {

	//用户登陆
	public String checkUser(User user);
	
	//客户登陆验证
	public int chkCustomer(String phone);
}
