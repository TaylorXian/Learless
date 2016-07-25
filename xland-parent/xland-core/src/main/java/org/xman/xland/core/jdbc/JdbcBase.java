package org.xman.xland.core.jdbc;

import java.sql.*;

public abstract class JdbcBase {

	private Connection connection = null;
	private Statement statement = null;

	/**
	 * set statement timeout to 30 sec.
	 */
	protected int sm_timeout = 30;

	/**
	 * Initialize jdbc configuration.
	 */
	abstract protected void init();

	protected void loadDriver(String driver) throws ClassNotFoundException {
		// load the sqlite-JDBC driver using the current class loader
		Class.forName(driver);
	}

	/**
	 * create a database connection
	 * 
	 * @param url
	 * @throws SQLException
	 */
	protected void createConnection(String url) throws SQLException {
		connection = DriverManager.getConnection(url);
	}

	protected void createStatement() throws SQLException {
		statement = connection.createStatement();
		statement.setQueryTimeout(sm_timeout);
	}

	protected void executeUpdate(String update) throws SQLException {
		statement.executeUpdate(update);
	}

	protected ResultSet executeQuery(String query) throws SQLException {
		return statement.executeQuery(query);
	}

	protected String getString(ResultSet rs, String column) throws SQLException {
		return rs.getString(column);
	}

	protected int getInt(ResultSet rs, String column) throws SQLException {
		return rs.getInt(column);
	}

	abstract public void execute();

	protected void close() {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			// statement close failed.
			System.err.println(e);
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// connection close failed.
			System.err.println(e);
		}
	}
}
