package service;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;

import dao.Dao;
import dao.DaoImpl;
import entity.User;
import util.Util;

public class ServiceImpl implements Service {

	Dao dao = new DaoImpl();
	
	@Override
	public void regist(User user) {
		String pwd = Util.getMd5(user.getPwd());
		user.setPwd(pwd);
		
		dao.regist(user);
	}
	
	public String checkUser(User user) {
		String password = Util.getMd5(user.getPwd());
		String userName = dao.checkUser(password);
		String res = ""; //0-正确  1-此用户不存在！ 2-用户名不正确！3-密码不正确
		if(StringUtils.isBlank(userName)) {
			res = "1";
		}
		if(!user.getUserName().equals(userName)) {
			res = "2";
		}
		return res;
	}
}
