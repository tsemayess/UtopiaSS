package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.UserRoleDAO;
import com.smoothstack.utopia.domains.UserRole;

public class UserRoleDAOTests {
	
	UserRoleDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new UserRoleDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}

	@Test
	public void readHP() throws Exception {
		UserRole r = new UserRole();
		r.setiD(1);
		System.out.println(dao.read(r));
	}
}
