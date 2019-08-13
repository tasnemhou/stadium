package entity;

import java.io.Serializable;

public class DealInfo implements Serializable {
	
	private static final long serialVersionUID = 6072419310888907015L;

	/** 客户id*/
	private String customerId;

	/**本次交易 的使用人*/
	private String customer;

	/**交易金额*/
	private Double dealAmount;

	/** 交易次数（本次充值生效次数或本次消费生效次数）*/
	private Integer dealTimes;

	/** 余额*/
//	private Integer balance;
	
	/**交易类型 0-充值  1-消费 */
	private String kind;
	
	/**客户类型 0-年卡会员  1-月卡会员  2-次卡会员  3-散客 */
	private String customerType;
	

	/** 交易方式  0-现金 1-会员卡 2-免费（优惠） */
	private String dealType;
	
	/** 交易日期*/
	private String dealDt;
	
	/** 1-会员充值  2-会员消费  3-散客消费 */
	private String isPay;
	
	/** 页数 */
	private Integer pageNumber;
	
	/** 每页的记录数 */
	private Integer pageSize;
	
	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

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

	public Double getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(Double dealAmount) {
		this.dealAmount = dealAmount;
	}

	public Integer getDealTimes() {
		return dealTimes;
	}

	public void setDealTimes(Integer dealTimes) {
		this.dealTimes = dealTimes;
	}

/*	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}*/

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

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
}
