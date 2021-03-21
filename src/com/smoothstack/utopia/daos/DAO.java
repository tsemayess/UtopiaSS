package com.smoothstack.utopia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DAO<T> {

	protected static Connection connection = null;

	public DAO(Connection c) {
		connection = c;
	}

	protected void save(String sql, Object[] values) throws ClassNotFoundException, SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		int count = 1;
		for (Object o : values) {
			statement.setObject(count, o);
			count++;
		}
		statement.executeUpdate();
		
	}
	
	protected int savePK(String sql, Object[] values) throws ClassNotFoundException, SQLException {
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int count = 1;
		for (Object o : values) {
			statement.setObject(count, o);
			count++;
		}
		statement.executeUpdate();
		ResultSet rs = statement.getGeneratedKeys();
		while (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
		
	}

	public String read(String sql, Object[] values) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);

		int count = 1;
		for (Object o : values) {
			statement.setObject(count, o);
			count++;
		}
		ResultSet resultSet = statement.executeQuery();
		return extractString(resultSet);
	}

	public List<T> listAll(String sql, Object[] values) throws ClassNotFoundException, SQLException {
		PreparedStatement statement = connection.prepareStatement(sql);
		int count = 1;
		for (Object o : values) {
			statement.setObject(count, o);
			count++;
		}
		ResultSet resultSet = statement.executeQuery();
		return extractList(resultSet);

	}

	abstract public List<T> extractList(ResultSet resultSet) throws SQLException;
	abstract public String extractString(ResultSet resultSet) throws SQLException;
}
