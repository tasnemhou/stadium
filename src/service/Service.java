package service;

import java.util.List;

import entity.Dictionary;
import entity.User;

public interface Service {

	//用户注册
	public void regist(User user);
		
	//用户登陆
	public String checkUser(User user);
	
	//获取数据字典
	public List<Dictionary> getDic();
}
