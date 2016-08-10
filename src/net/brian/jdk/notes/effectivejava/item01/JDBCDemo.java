package net.brian.jdk.notes.effectivejava.item01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
	public static void getJDBCConnection() {
		try {
			// This Driver class here is the service provider interface.
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/helloworld";
		String username = "brian";
		String password = "bqy@Home2016";
		// Connection is a service interface right here.
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String sql = "select name from user where gender=?";
		try {
			// public static Connection getConnection(String url, String user,
			// String password)
			// We have many other getConnection()s for service access api.
			// DriverManager, as a provider registration api, will implement
			// Connection interface in different ways.
			conn = DriverManager.getConnection(url, username, password);

			List advs = new ArrayList();
			if (conn != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "M");
				rs = stmt.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						System.out.println("JDBCDemo -- getJDBCConnection() -- resultSet:: " + rs.getString(1));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("JDBCDemo -- getJDBCConnection() -- conn:: " + conn);
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getJDBCConnection();
	}
}
