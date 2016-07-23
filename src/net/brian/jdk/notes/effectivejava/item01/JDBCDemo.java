package net.brian.jdk.notes.effectivejava.item01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
	public static void getJDBCConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/helloworld";
		String username = "brian";
		String password = "bqy@Home2016";
		// Connection is a service interface right here.
		Connection conn = null;
		try {
			// public static Connection getConnection(String url, String user, String password)
			// We have many other getConnection()s for service access api.
			// DriverManager, as a provider registration api, will implement Connection interface in different ways.
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("JDBCDemo -- getJDBCConnection() -- conn:: " + conn);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getJDBCConnection();
	}
}
