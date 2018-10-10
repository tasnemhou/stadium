package dao;

import entity.Dictionary;
import entity.User;
import java.sql.SQLException;
import java.util.List;

public interface Dao {

	//登陆
	public String checkUser(String pwd);
	//注册
	public void regist(User user);
	//获取数据字典
	public List<Dictionary> getDic();
	
}
