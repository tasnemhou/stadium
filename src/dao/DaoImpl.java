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

public class DaoImpl implements Dao {

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
	public void regist(User user) {
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into emp_user_info values(emp_seq.nextval,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2,user.getPhone());
			ps.setString(3, user.getPwd());
			ps.setString(4,String.valueOf(user.getLevel()));
			ps.setString(5, String.valueOf(user.getSex()));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("建立连接失败！",e);
		}finally {
			DBUtil.close(connection);
		}		
	}

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
