package entity;

public class DealDetail {

	/** 用户id */
	private String customerId;
	
	/** 交易起始日期 */
	private String begDate;
	
	/** 交易截止日期 */
	private String endDate;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
