package test;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import java.sql.Connection;

public class Util {

	public static void main(String[] args) {
		Connection();
	}
	
	public static void Connection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "tianlan";
			con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
