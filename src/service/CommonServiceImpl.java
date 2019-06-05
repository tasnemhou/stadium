package service;

import java.util.List;

import dao.CommonDao;
import dao.CommonDaoImpl;
import entity.Dictionary;

public class CommonServiceImpl implements CommonService {

	CommonDao dao = new CommonDaoImpl();
	@Override
	public List<Dictionary> getDic() {
		return dao.getDic();
	}

}
