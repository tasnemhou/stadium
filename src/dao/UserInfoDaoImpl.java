package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class UserInfoDaoImpl implements UserInfoDao {

	@Override
	public int getPhoneNo(String phone) {
		Connection con = null;
		int count = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "select count(1) from sts_customer_info where phone = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,phone);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				count = result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
		return count;
	}

}
