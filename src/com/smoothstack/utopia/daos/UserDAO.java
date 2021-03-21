package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.smoothstack.utopia.daos.DAO;
import com.smoothstack.utopia.domains.User;
import com.smoothstack.utopia.domains.UserRole;

public class UserDAO extends DAO<User> {

	Connection c;

	public UserDAO(Connection c) {
		super(c);
		this.c = c;
	}

	public int add(User u) throws ClassNotFoundException, SQLException {
		return savePK("insert into user (role_id, given_name, family_name, username, email, password, phone) values (?, ?, ?, ?, ?, ?, ?)", 
				new Object[] {u.getRole(), u.getFirstName(), u.getLastName(), u.getUsername(),
				u.getEmail(), u.getPassword(), u.getPhone()});
	}
	
	public void updateFirst(User u) throws ClassNotFoundException, SQLException {
		save("update user set given_name = ? where id = ?", new Object[] {u.getFirstName(), u.getiD()});
	}
	
	public void updateLast(User u) throws ClassNotFoundException, SQLException {
		save("update user set family_name = ? where id = ?", new Object[] {u.getLastName(), u.getiD()});
	}
	public void updateUsername(User u) throws ClassNotFoundException, SQLException {
		save("update user set username = ? where id = ?", new Object[] {u.getUsername(), u.getiD()});
	}
	
	public void updatePassword(User u) throws ClassNotFoundException, SQLException {
		save("update user set password = ? where id = ?", new Object[] {u.getPassword(), u.getiD()});
	}
	public void updateEmail(User u) throws ClassNotFoundException, SQLException {
		save("update user set email = ? where id = ?", new Object[] {u.getEmail(), u.getiD()});
	}
	
	public void updatePhone(User u) throws ClassNotFoundException, SQLException {
		save("update user set phone = ? where id = ?", new Object[] {u.getPhone(), u.getiD()});
	}
	
	public void delete(User u) throws ClassNotFoundException, SQLException {
		save("delete from user where id = ?", new Object[] {u.getiD()});
	}
	
	public void readAll() throws ClassNotFoundException, SQLException {
		listAll().forEach(a -> {
			try {
				System.out.println(read(a));
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	public void readAllEmployees() throws ClassNotFoundException, SQLException {
		listAllEmployees().forEach(a -> {
			try {
				System.out.println(read(a));
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	public void readAllTravellers() throws ClassNotFoundException, SQLException {
		listAllTravellers().forEach(a -> {
			try {
				System.out.println(read(a));
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	public List<User> listAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from user", new Object[] {});
	}
	
	public List<User> listAllEmployees() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from user where role_id = 1", new Object[] {});
	}
	
	public List<User> listAllTravellers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from user where role_id = 3", new Object[] {});
	}
	
	public User getByLogin(User u) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from user where username = ? AND password = ?", new Object[] {u.getUsername(), u.getPassword()}).get(0);
	}
	public User getByIdRole(int id, int role) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from user where id = ? AND role_id = ?", new Object[] {id, role}).get(0);
	}
	
	public User getById(int id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from user where id = ?", new Object[] {id}).get(0);
	}

	@Override
	public List<User> extractList(ResultSet resultSet) throws SQLException {
		List<User> users = new ArrayList<>();
		while (resultSet.next()) {
			User u = new User();

			u.setiD(resultSet.getInt("id"));
			u.setFirstName(resultSet.getString("given_name"));
			u.setLastName(resultSet.getString("family_name"));
			u.setUsername(resultSet.getString("username"));
			u.setRole(resultSet.getInt("role_id"));
			u.setPassword(resultSet.getString("password"));
			users.add(u);
		}
		return users;
	}
	

	public String read(User u) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.read("select * from user where id = ?", new Object[] { u.getiD() });
	}
	
	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while (resultSet.next()) {

			UserRole r = new UserRole();
			r.setiD(resultSet.getInt("role_id"));

			result += "User Account Number: " + resultSet.getInt("id") + "\nRole:\t\t" + r.getName() + "\nFirst Name:\t"
					+ resultSet.getString("given_name") + "\nLast Name:\t" + resultSet.getString("family_name")
					+ "\nUsername:\t" + resultSet.getString("username") + "\nEmail:\t\t" + resultSet.getString("email")
					+ "\nPhone:\t\t" + resultSet.getString("phone");

		}
		return result;
	}

}
