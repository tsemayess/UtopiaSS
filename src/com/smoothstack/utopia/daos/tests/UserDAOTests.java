package com.smoothstack.utopia.daos.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smoothstack.utopia.controllers.Util;
import com.smoothstack.utopia.daos.UserDAO;
import com.smoothstack.utopia.domains.User;

public class UserDAOTests {

	UserDAO dao;
	Connection conn;

	@Before
	public void openConnection() throws ClassNotFoundException, SQLException {
		Util util = new Util();
		conn = util.getConnection();
		dao = new UserDAO(conn);
	}

	@After
	public void closeConnection() throws SQLException {
		if (!conn.isClosed()) {
			conn.close();
		}
	}
	
	@Test
	public void getByLoginHP() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setUsername("batman");
		u.setPassword("batmanisawesome");
		System.out.println(dao.read(dao.getByLogin(u)));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getByLoginFP() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setUsername("batman");
		u.setPassword("batman");
		System.out.println(dao.read(dao.getByLogin(u)));
	}
	
	@Test
	public void getByiDHP() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setiD(1);
		System.out.println(dao.read(dao.getById(u.getiD())));
	}
	
	@Test
	public void readAllHP() throws ClassNotFoundException, SQLException {
		List<User> users = dao.listAll();
		users.forEach(a -> {
			try {
				System.out.println(dao.read(a));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	
		
	}
	
	@Test
	public void listAll() throws ClassNotFoundException, SQLException {
		dao.readAll();
	}
	
	@Test
	public void delete() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setiD(5);
		
		dao.delete(u);
		conn.commit();
	}
	@Test
	public void updatePhone() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setiD(2);
		u.setPhone("(888) 888-8888");
		
		System.out.println(dao.read(u));
		dao.updatePhone(u);
		conn.commit();
		System.out.println(dao.read(u));
	}
	@Test
	public void updateEmail() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setiD(2);
		u.setEmail("barry.allen@starlabs.com");
		
		System.out.println(dao.read(u));
		dao.updateEmail(u);
		conn.commit();
		System.out.println(dao.read(u));
	}
	@Test
	public void updatePassword() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setiD(2);
		u.setPassword("simpfoririswestallen");
		
		System.out.println(dao.read(u));
		dao.updatePassword(u);
		conn.commit();
		
	}
	
	@Test
	public void updateUsername() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setiD(2);
		u.setUsername("thefastestmanalive*");
		
		System.out.println(dao.read(u));
		dao.updateUsername(u);
		conn.commit();
		
		System.out.println(dao.read(u));
	}
	
	
	@Test
	public void updateLastHP() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setiD(2);
		u.setLastName("Allen");
		
		System.out.println(dao.read(u));
		dao.updateLast(u);
		conn.commit();
		
		System.out.println(dao.read(u));
	}
	
	@Test
	public void updateFirstHP() throws ClassNotFoundException, SQLException {
		User u  = new User();
		u.setiD(2);
		u.setFirstName("Barry");
		
		System.out.println(dao.read(u));
		dao.updateFirst(u);
		conn.commit();
		
		System.out.println(dao.read(u));
	}
	
	@Test
	public void addHP() throws ClassNotFoundException, SQLException {
		User u = new User();
		
		u.setRole(3);
		u.setFirstName("Diana");
		u.setLastName("Prince");
		u.setUsername("wonderwoman");
		u.setPassword("I<3Themyiscira");
		u.setEmail("diana.prince@unitednations.org");
		u.setPhone("(555) 555-1984");
		
		dao.add(u);
		conn.commit();
	}
	
	@Test
	public void readHP() throws SQLException {
		User u = new User();
		u.setiD(1);
		System.out.println(dao.read(u));
	}

}
