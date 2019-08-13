package service;

import java.util.List;
import java.util.Map;

import entity.Customer;
import entity.DealInfo;

public interface DealDetailInfoService {
	/**
	 * @param info
	 * intr:交易明细
	 */
	public List<Map<String,Object>> getDealDetailInfo(DealInfo info);
	
	/**
	 * @param info
	 * intr:用户信息查询
	 */
	public Map<String,Object> getUserDealInfo(String phone);
	
	/**
	 * @param phone
	 * @return 
	   *     用户交易信息新增
	 */
	public int insertDealInfo(DealInfo info,Customer cus);
}
