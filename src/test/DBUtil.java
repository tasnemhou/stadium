package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	//���ݿ����Ӳ���
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	//��ȡ�ļ�
	static{
		Properties property = new Properties();
		try {
			property.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			DRIVER = property.getProperty("driver");
			URL = property.getProperty("url");
			USER = property.getProperty("user");
			PASSWORD = property.getProperty("password");
			//��������һ�μ���
			Class.forName(DRIVER);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("db�ļ�����ʧ�ܣ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("��������ʧ�ܣ�");
		}
	}
	//��������
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ�����ʧ�ܣ�");
		}
		return connection;
	}
	
	public static void close(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�����ʧ�ܣ�",e);
			}
		}
		
	}
}
