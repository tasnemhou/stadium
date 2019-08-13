package service;

import dao.UserInfoDao;
import dao.UserInfoDaoImpl;

public class UserInfoServiceImpl implements UserInfoService {

	UserInfoDao dao = new UserInfoDaoImpl();
	@Override
	public int getPhoneNo(String phone) {
		return dao.getPhoneNo(phone);
	}

}
