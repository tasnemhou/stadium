package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class TestClass {
	public static void main(String[] args) {
//		test5();
//		test8();
		test9();
	}
	
	public static void test9() {
		Connection connection = DBUtil.getConnection();
		String sql = "insert into emp_hpf(id,name,age)values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql,new String[]{"id","name"});
			ps.setString(1,"1100");
			ps.setString(2,"hpf10");
			ps.setInt(3, 11);
			
			ps.executeUpdate();
			
			ResultSet keys = ps.getGeneratedKeys();
			while(keys.next()) {
				String id = keys.getString(1);
				String name = keys.getString(2);
				System.out.println(id+" "+name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("新增失败！",e);
		}finally {
			DBUtil.close(connection);
		}
	}
	
	public static void test8() {
		Connection connection = DBUtil.getConnection();
		try {
			String sql = "insert into emp_hpf (id,name,age,height)values (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			connection.setAutoCommit(false);
			for(int i=0;i<30;i++) {
				ps.setInt(1,1000+i);
				ps.setString(2,"hh"+i);
				ps.setInt(3,20+i);
				ps.setString(4, "0.8"+i);
				
				//将数据添加到缓存
				ps.addBatch();
				//满8条，就保存一次
				if(i%8==0) {
					ps.executeBatch();
					//执行一次清空一次
					ps.clearBatch();
				}
			}
			//避免有零头，单独执行一次
			ps.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
	}
	
	public static void test7() {
		Connection connection = DBUtil.getConnection();
		String sql = "select * from emp_hpf";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				String name = resultSet.getString("name");
				System.out.println("name is: "+name.trim());
			}
			ResultSetMetaData metaData = ps.getMetaData();
			System.out.println("metaData is: "+metaData);
			int columnCount = metaData.getColumnCount();
			System.out.println("columnCount is: "+columnCount);
			String label = metaData.getColumnLabel(3);
			System.out.println("label is: "+label);
			String columnName = metaData.getColumnName(3);
			System.out.println("columnName is : "+columnName);
			metaData.getColumnType(3);
			for(int i=1;i<5;i++) {
				System.out.println(i+" name is:"+metaData.getColumnName(i)+" type is: "+metaData.getColumnTypeName(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
	}
	public static void test6() {
		Connection connection = DBUtil.getConnection();
		String sql = "update emp_hpf set name = ? where id = ? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,"houpf1");
			ps.setString(2,"1211");
			int i = ps.executeUpdate();
			System.out.println("i is: "+i);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);
		}
	}
	public static void test5() {
		Connection connection = DBUtil.getConnection();
		String sql = "select * from emp_hpf";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery(sql);
			while(resultSet.next()) {
				String name = resultSet.getString("name");
				String id = resultSet.getString("id");
				System.out.println("name is: "+id+" "+name.trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("创建ps失败！",e);
		}finally {
			DBUtil.close(connection);
		}
	}
	public static void test4() {
		Connection connection = DBUtil.getConnection();
		System.out.println(connection.getClass().getName());;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from emp_hpf");
			while(resultSet.next()) {
				String name = resultSet.getString("name");
				System.out.println("name is: "+name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(connection);	
		}
	}
	
	public static void test3() {
		Connection con =  DBUtil.getConnection();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from emp_hpf");
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
	}
	
	public static void test2() {
		Connection con =  DBUtil.getConnection();
		try {
			Statement statement = con.createStatement();
			int execute = statement.executeUpdate("insert into emp_hpf(id,name,age) values('1221','hou',23)");
			System.out.println(execute);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
		}
	}
	
	@Test
	public static void test1() {
		Properties pro = new Properties();
		try {
			pro.load(TestClass.class.getClassLoader().getResourceAsStream("db.properties"));
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String password = pro.getProperty("password");
			System.out.println(driver+""+url+""+user+""+password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
