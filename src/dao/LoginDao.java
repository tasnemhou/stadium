package dao;

import entity.Dictionary;
import entity.User;
import java.sql.SQLException;
import java.util.List;

public interface LoginDao {

	//员工登陆
	public String checkUser(String pwd);
	
	//客户登陆验证
	public String chkCustomer(String phone);
	
}
