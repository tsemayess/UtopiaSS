package com.smoothstack.utopia.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
	public static final String driver = "com.mysql.cj.jdbc.Driver"; 
	public static final String url = "jdbc:mysql://localhost:3306/utopia"; 
	public static final String username = "root"; 
	public static final String password = "1083047@T.o."; 


	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection c = DriverManager.getConnection(url, username, password);
		c.setAutoCommit(false);
		return c;
	}

}
