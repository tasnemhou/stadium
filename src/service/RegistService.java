package service;

import entity.Customer;
import entity.DealInfo;
import entity.User;

public interface RegistService {

	//注册 员工
	public void regist(User user);
	
	//注册客户
	public void regist(Customer customer,DealInfo dealInfo);

}
