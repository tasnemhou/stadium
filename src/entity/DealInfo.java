package entity;

import java.io.Serializable;

public class DealInfo implements Serializable {
	
	private static final long serialVersionUID = 6072419310888907015L;

	/** 客户id*/
	private String customerId;

	/**本次交易 的使用人*/
	private String customer;

	/**交易金额*/
	private String dealAmount;

	/** 交易次数（本次充值生效次数或本次消费生效次数）*/
	private String dealTimes;

	/** 余额*/
	private String balance;
	
	/** 剩余使用次数*/
	private String times;
	
	/**交易类型 0-充值  1-消费 2-免费（优惠）*/
	private String kind;
	
	/**客户类型 0-年卡会员  1-月卡会员  2-次卡会员  3-散客 */
	private String customerType;
	

	/** 交易方式  0-现金 1-会员卡 2-免费（优惠） */
	private String dealType;
	
	/** 交易日期*/
	private String dealDt;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getDealTimes() {
		return dealTimes;
	}

	public void setDealTimes(String dealTimes) {
		this.dealTimes = dealTimes;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getDealDt() {
		return dealDt;
	}

	public void setDealDt(String dealDt) {
		this.dealDt = dealDt;
	}
	
}
