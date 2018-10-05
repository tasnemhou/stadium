package service;

import entity.User;

public interface Service {

	//用户注册
	public void regist(User user);
		
	//用户登陆
	public String checkUser(User user);
	
	
}
