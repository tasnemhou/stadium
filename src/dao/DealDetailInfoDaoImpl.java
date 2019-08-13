package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Customer;
import entity.DealInfo;
import util.DBUtil;

public class DealDetailInfoDaoImpl implements DealDetailInfoDao {

	@Override
	public List<Map<String, Object>> getDealDetailInfo(DealInfo info) {
		Connection con = null;
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			con = DBUtil.getConnection();
//			String sql = "SELECT t.customerid,t.customer,t.dealamount,t.dealtimes,t.kind,t.customertype,t.dealtype,t.dealdt FROM sts_deal_info t WHERE t.customerid = ?";
			String sql = "SELECT * FROM (\r\n" + 
							"  SELECT  ROW_NUMBER() OVER (ORDER BY dealdt,kind) rn,\r\n" + 
							"          t.customerid,\r\n" + 
							"          t.customer,\r\n" + 
							"          t.dealamount,\r\n" + 
							"          t.dealtimes,\r\n" + 
							"          t.kind,\r\n" + 
							"          t.customertype,\r\n" + 
							"          t.dealtype,\r\n" + 
							"          t.dealdt\r\n" + 
							"   FROM STS_DEAL_INFO t\r\n" + 
							"  WHERE t.CUSTOMERID = ?\r\n" + 
							" )WHERE rn >= "+info.getPageNumber()+" and rn <= "+info.getPageSize()+"\r\n" + 
							"";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, info.getCustomerId());
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				Map<String, Object> map = new HashMap<String,Object>();
				map.put("customerId", result.getString("customerid"));
				map.put("customer", result.getString("customer"));
				map.put("dealDt", result.getString("dealdt"));
				map.put("dealAmount", result.getDouble("dealamount"));
				map.put("dealTimes", result.getInt("dealtimes"));
				map.put("dealType", result.getInt("dealtype"));
				map.put("dealKind", result.getString("kind"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return list;
	}

	@Override
	public Map<String, Object> getUserDealInfo(String phone) {
		Connection con = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			con = DBUtil.getConnection();
			String userInfo = "SELECT    t.customer,\r\n" + 
								"        t.dealamount,\r\n" + 
								"        t.dealtimes,\r\n" + 
								"        t.balance,\r\n" + 
								"        m.lasttimes,\r\n" + 
								"        m.begdate,\r\n" + 
								"        m.enddate,\r\n" + 
								"        t.kind,\r\n" + 
								"        t.customertype,\r\n" + 
								"        t.dealtype,\r\n" + 
								"        t.dealdt,\r\n" + 
								"        m.id,\r\n" + 
								"        m.name,\r\n" + 
								"        m.registdt\r\n" + 
								"FROM STS_DEAL_INFO t\r\n" + 
								"JOIN STS_CUSTOMER_INFO m\r\n" + 
								"ON t.customerid = m.id\r\n" + 
								"WHERE m.phone   = ?";
			PreparedStatement ps = con.prepareStatement(userInfo);
			ps.setString(1,phone);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				map.put("customer", 	result.getString("customer"));
				map.put("dealamount", 	result.getDouble("dealamount"));
				map.put("dealtimes", 	result.getInt("dealtimes"));
				map.put("balance", 		result.getDouble("balance"));
				map.put("lastTimes", 	result.getInt("lasttimes"));
				map.put("dealamount", 	result.getBigDecimal("dealamount"));
				map.put("dealtimes", 	result.getBigDecimal("dealtimes"));
				map.put("balance", 		result.getBigDecimal("balance"));
				map.put("kind", 		result.getString("kind"));
				map.put("customertype", result.getString("customertype"));
				map.put("dealtype", 	result.getString("dealtype"));
				map.put("dealdt", 		result.getString("dealdt"));
				map.put("customerId", 	result.getString("id"));
				map.put("name", 		result.getString("name"));
				map.put("registDt", 	result.getString("registDt"));
				map.put("begDate", 	    result.getString("begdate"));
				map.put("endDate", 	    result.getString("enddate"));
			}
			
			/*ResultSetMetaData data = resultSet.getMetaData();
			for(int i=1;i<=data.getColumnCount();i++) {
				System.out.println(data.getColumnType(i));
				System.out.println(data.getColumnTypeName(i));
				System.out.println(data.getColumnName(i));
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
		return map;
	}

	@Override
	public int insertDealInfo(DealInfo info,Customer cus) {
		Connection con = null;
		int flag = 0;
		try {
			con = DBUtil.getConnection();
			
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tianlan");*/
		    
			Statement statement = con.createStatement();
			
			String dealSql =  "INSERT INTO   STS_DEAL_INFO (\r\n" + 
										"    CUSTOMERID,\r\n" + 
										"    CUSTOMER,\r\n" + 
										"    DEALAMOUNT,\r\n" + 
										"    DEALTIMES,\r\n" + 
										"    KIND,\r\n" + 
										"    CUSTOMERTYPE,\r\n" + 
										"    DEALTYPE,\r\n" + 
										"    DEALDT,\r\n" + 
										"    ISPAY\r\n" + 
							     "  ) VALUES(\r\n" + 
							"    '"+info.getCustomerId()+"',\r\n" + 
							"    '"+info.getCustomer()+"',\r\n" + 
							"    '"+info.getDealAmount()+"',\r\n" + 
							"    '"+info.getDealTimes()+"',\r\n" + 
							"    '"+info.getKind()+"',\r\n" + 
							"    '"+info.getCustomerType()+"',\r\n" + 
							"    '"+info.getDealType()+"',\r\n" + 
							"    '"+info.getDealDt()+"',\r\n" + 
							"    '"+info.getIsPay()+"'\r\n" + 
							"  )";
			
			statement.addBatch(dealSql);
			
			//只有用户充值时，才更新用户表
			if("1".equals(info.getIsPay())) {
				String cusSql = "UPDATE STS_CUSTOMER_INFO\r\n" + 
						"SET BEGDATE   = '"+cus.getBegDate()+"',\r\n" + 
						"    ENDDATE   = '"+cus.getEndDate()+"',\r\n" + 
						"    LASTTIMES = '"+cus.getLastTimes()+"'\r\n" + 
						"WHERE ID        ='"+info.getCustomerId()+"'";
				statement.addBatch(cusSql);
			}
			
			System.out.println(statement.toString());
			statement.executeBatch();
			
			statement.clearBatch();
//			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/finally {
			DBUtil.close(con);
		}
		return flag;  //能走到这一步，说明执行成功
	}
}
