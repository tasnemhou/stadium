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
			String sql = "select name,password from emp_user_info where password = ?";
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
	public String chkCustomer(String phone) {
		
		return null;
	}
}
