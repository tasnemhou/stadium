package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	//数据库连接参数
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	//获取文件
	static{
		Properties property = new Properties();
		try {
			property.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			DRIVER = property.getProperty("driver");
			URL = property.getProperty("url");
			USER = property.getProperty("user");
			PASSWORD = property.getProperty("password");
			//驱动加载一次即可
			Class.forName(DRIVER);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("db文件加载失败！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("驱动加载失败！");
		}
	}
	//建立连接
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败！");
		}
		return connection;
	}
	
	public static void close(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭连接失败！",e);
			}
		}
		
	}
}
