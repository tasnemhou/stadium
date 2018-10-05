package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {

		private static BasicDataSource source;
		static {
			Properties pro = new Properties();
			try {
				pro.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
				String driver = pro.getProperty("driver");
				String url = pro.getProperty("url");
				String user = pro.getProperty("user");
				String password= pro.getProperty ("password");
				String initSize = pro.getProperty ("initSize");
				String maxSize = pro.getProperty ("maxSize");
//				String minSize = pro.getProperty ("minSize");
				String maxIdle = pro.getProperty ("maxldle");
				String minIdle = pro.getProperty ("minldle");
				String maxWait = pro.getProperty ("maxWait");
				
				source = new BasicDataSource();
				source.setDriverClassName(driver);
				source.setUrl(url);
				source.setUsername(user);
				source.setPassword(password);
				source.setInitialSize(Integer.parseInt(initSize));
				source.setMaxActive(Integer.parseInt(maxSize));
//				source.setMinIdle(Integer.parseInt(minIdle));
//				source.setMaxIdle(Integer.parseInt(maxIdle));
//				source.setMaxWait(Integer.parseInt(maxWait));
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("db文件加载失败！",e);
			} 
		}
		
		//建立连接
		public static Connection getConnection() throws SQLException {
			return source.getConnection();
		}
		
		//关闭连接
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
