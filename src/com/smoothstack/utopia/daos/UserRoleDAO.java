package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.utopia.domains.Airplane;
import com.smoothstack.utopia.domains.UserRole;

public class UserRoleDAO extends DAO<UserRole> {

	public UserRoleDAO(Connection c) {
		super(c);
	}

	public UserRole getById(int id) throws ClassNotFoundException, SQLException {
		return super.listAll("select * from airplane where id = ?", new Object[] { id }).get(0);
	}

	@Override
	public List<UserRole> extractList(ResultSet resultSet) throws SQLException {
		List<UserRole> roles = new ArrayList<>();
		while (resultSet.next()) {
			UserRole role = new UserRole();

			role.setiD(resultSet.getInt("id"));
			roles.add(role);
		}

		return roles;
	}

	public String read(UserRole u) throws SQLException {
		return super.read("select * from user_role where id = ?", new Object[] { u.getiD() });
	}

	@Override
	public String extractString(ResultSet resultSet) throws SQLException {
		String result = "";
		while (resultSet.next()) {
			result += "User Role ID: " + resultSet.getString("id") + "\t\t" + resultSet.getString("name");
		}
		return result;
	}

}
