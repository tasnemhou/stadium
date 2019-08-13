package dao;

public interface UserInfoDao {
	
	//查询客户手机号码是否已存在
	public int getPhoneNo(String phone);

}
