package service;

import java.util.List;
import java.util.Map;

import dao.DealDetailInfoDao;
import dao.DealDetailInfoDaoImpl;
import entity.Customer;
import entity.DealInfo;

public class DealDetailInfoServiceImpl implements DealDetailInfoService {

	DealDetailInfoDao dao = new DealDetailInfoDaoImpl();
	@Override
	public List<Map<String, Object>> getDealDetailInfo(DealInfo info) {
		List<Map<String, Object>> list = dao.getDealDetailInfo(info);
		return list;
	}
	@Override
	public Map<String, Object> getUserDealInfo(String phone) {
		Map<String, Object> map = dao.getUserDealInfo(phone);
		return map;
	}
	@Override
	public int insertDealInfo(DealInfo info,Customer cus) {
		return dao.insertDealInfo(info,cus);
	}

}
