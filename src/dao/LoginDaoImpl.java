package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Dictionary;
import entity.User;
import util.DBUtil;

public class LoginDaoImpl implements LoginDao {

	public String checkUser(String pwd) {
		Connection connection = null;
		String name = "";
		try {
			connection = DBUtil.getConnection();
			String sql = "select name,password from sts_user_info where password = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,pwd);
			ResultSet resultSet = ps.executeQuery(); 
			while(resultSet.next()) {
				name = resultSet.getString(1);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("建立联接失败！",e);
		}finally {
			DBUtil.close(connection);
		}
		return name;
	}

	@Override
	public int chkCustomer(String phone) {
		Connection con = null;
		int count = 0;
		try {
			con = DBUtil.getConnection();
			String sql = "select count(1) from sts_customer_info where phone = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				count = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("建立连接失败");
		} finally {
			DBUtil.close(con);
		}
		return count;
	}
}
