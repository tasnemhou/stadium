package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Customer;
import entity.DealInfo;
import entity.User;
import util.DBUtil;

public class RegistDaoImpl implements RegistDao {

	@Override
	public void regist(User user) {
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "insert into sts_user_info values(emp_seq.nextval,?,?,?,?,?)";
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
	public void regist(Customer customer, DealInfo dealInfo) {
		Connection con = null;
		try {
			String sqlCus = "insert into sts_customer_info (ID, NAME, PHONE,PASSWORD,SEX,REGISTDT) values(emp_seq.nextval,?,?,?,?,?)";
		    
			con = DBUtil.getConnection();
			
			con.setAutoCommit(false);   // 事物管理，取消自动提交
			PreparedStatement ps = con.prepareStatement(sqlCus,new String[]{"id"});
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getPhone());
			ps.setString(3, customer.getPwd());
			ps.setString(4, customer.getSex());
			ps.setString(5, customer.getRegistDate());
			
			ps.executeUpdate();
			ResultSet resultSet = ps.getGeneratedKeys();
			String key = "";
			while(resultSet.next()) {
				key = resultSet.getString(1);
			};
			
			System.out.println("the key is: "+key);
			String sqlDeal = "insert into sts_deal_info (CUSTOMERID,DEALAMOUNT,DEALTIMES,CUSTOMERTYPE,DEALDT) values(?,?,?,?,?)";
			
			PreparedStatement psDeal = con.prepareStatement(sqlDeal);
			psDeal.setString(1, key);
			psDeal.setDouble(2, dealInfo.getDealAmount());
			psDeal.setInt(3, dealInfo.getDealTimes());
			psDeal.setString(4, dealInfo.getCustomerType());
			psDeal.setString(5, customer.getRegistDate());
			
			psDeal.executeUpdate();
			
			con.commit();    //事物管理， 提交
		} catch (SQLException e) {
			try {
				con.rollback();     //事物管理， 如果失败，则回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}		
	}
	
}
