package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.daos.AirplaneTypeDAO;
import com.smoothstack.utopia.daos.DAO;
import com.smoothstack.utopia.domains.AirplaneType;
import com.smoothstack.utopia.domains.Route;
import com.smoothstack.utopia.domains.User;
import com.smoothstack.utopia.domains.UserRole;

public class UserDAO extends DAO<User> {

	Connection c;

	public UserDAO(Connection c) {
		super(c);
		this.c = c;
	}

	public void add(User u) throws ClassNotFoundException, SQLException {
		save("insert into user (role_id, given_name, family_name, username, email, password, phone) values (?, ?, ?, ?, ?, ?, ?)", 
				new Object[] {u.getRole(), u.getFirstName(), u.getiD(), u.getFirstName(), u.getLastName(), u.getUsername(),
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
	public void updatEmail(User u) throws ClassNotFoundException, SQLException {
		save("update user set email = ? where id = ?", new Object[] {u.getEmail(), u.getiD()});
	}
	
	public void updatePhone(User u) throws ClassNotFoundException, SQLException {
		save("update user set phone = ? where id = ?", new Object[] {u.getPhone(), u.getiD()});
	}
	
	public void delete(User u) throws ClassNotFoundException, SQLException {
		save("delete from user where id = ?", new Object[] {u.getiD()});
	}
	
	public List<User> listAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return super.listAll("select * from user", new Object[] {});
	}
	
	public User getByLogin(User u) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from user where username = ? AND password = ?", new Object[] {u.getUsername(), u.getPassword()}).get(0);
	}
	
	public User getById(User u) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from user where id = ?", new Object[] {u.getiD()}).get(0);
	}

	@Override
	public List<User> extractList(ResultSet resultSet) throws SQLException {
		List<User> users = new ArrayList<>();
		while (resultSet.next()) {
			User u = new User();

			u.setiD(resultSet.getInt(resultSet.getInt("id")));
			u.setFirstName(resultSet.getString("given_name"));
			u.setLastName(resultSet.getString("last_name"));
			u.setUsername(resultSet.getString("username"));
			u.setRole(resultSet.getInt("role_id"));
			users.add(u);
		}
		return users;
	}


	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while (resultSet.next()) {

			UserRoleDAO role = new UserRoleDAO(c);
			UserRole r = new UserRole();
			r.setiD(resultSet.getInt("username"));

			result += "User ID Number: " + resultSet.getString("id") + "\nRole: " + r.getName() + "\nFirstName: "
					+ resultSet.getString("given_name") + "\nLast Name: " + resultSet.getString("family_name")
					+ "\n Username: " + resultSet.getString("username") + "\nEmail: " + resultSet.getString("email")
					+ "\nPhone: " + resultSet.getString("phone");

		}
		return result;
	}

}
