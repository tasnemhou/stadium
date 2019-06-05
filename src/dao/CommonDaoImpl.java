package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Dictionary;
import util.DBUtil;

public class CommonDaoImpl implements CommonDao {

	@Override
	public List<Dictionary> getDic() {
		List<Dictionary> list = new ArrayList<>();
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "SELECT id,name,flag from DICTIONARY";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Dictionary dic = new Dictionary();
				dic.setId(rs.getString(1));
				dic.setName(rs.getString(2));
				dic.setFlag(rs.getString(3));
				list.add(dic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败！");
		}finally {
			DBUtil.close(connection);
		}
		return list;
	}

}
