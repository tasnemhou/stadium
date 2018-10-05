package dao;

import entity.User;
import java.sql.SQLException;

public interface Dao {

	//登陆
	public String checkUser(String pwd);
	//
	public void regist(User user);
}
