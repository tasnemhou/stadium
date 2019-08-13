package entity;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	/** id*/
	private String id;
	
	/** 客户姓名*/
	private String name;
	
	/**密码*/
	private String pwd;
	
	/** 联系电话*/
	private String phone;

	/** 客户性别 0-男  1-女*/
	private String sex;

	/** 客户注册日期*/
	private String registDate;

	/** 年/月 卡用户 起始日期*/
	private String begDate;
	
	/** 年/月 卡用户 截止日期*/
	private String endDate;
	
	/** 剩余次数*/
	private Integer lastTimes;
	
	public Integer getLastTimes() {
		return lastTimes;
	}

	public void setLastTimes(Integer lastTimes) {
		this.lastTimes = lastTimes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getBegDate() {
		return begDate;
	}

	public void setBegDate(String begDate) {
		this.begDate = begDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
