package dao;

import entity.Customer;
import entity.DealInfo;
import entity.User;

public interface RegistDao {

	//注册 员工
	public void regist(User user);
	
	//注册 客户
	public void regist(Customer customer,DealInfo dealInfo);
}
