package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public void regist(Customer customer, DealInfo dealInfo) {
		Connection con = null;
		try {
			String sqlDeal = "insert into emp_deal_info (CUSTOMERID,DEALAMOUNT,DEALTIMES,CUSTOMERTYPE,DEALDT) values(emp_seq.nextval,?,?,?,?)";
			String sqlCus = "insert into emp_customer_info (ID, NAME, PHONE,PASSWORD,SEX,REGISTDT) values(emp_seq.nextval,?,?,?,?,?)";
		    
			con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlCus);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getPhone());
			ps.setString(3, customer.getPwd());
			ps.setString(4, customer.getSex());
			ps.setString(5, customer.getRegistDate());
			
			ps.execute();
			
			PreparedStatement psDeal = con.prepareStatement(sqlDeal);
			psDeal.setString(1, dealInfo.getDealAmount());
			psDeal.setString(2, dealInfo.getDealTimes());
			psDeal.setString(3, dealInfo.getCustomerType());
			psDeal.setString(4, customer.getRegistDate());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				e.getMessage();
				
			}
		}
		
	}
	
}
