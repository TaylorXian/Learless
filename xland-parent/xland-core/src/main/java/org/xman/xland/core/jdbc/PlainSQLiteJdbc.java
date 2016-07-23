package org.xman.xland.core.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;

/**
 * SQLite JDBC Sample
 *
 * @see <a href="https://bitbucket.org/xerial/sqlite-jdbc">sqlite-jdbc</a>
 * @see <a href="https://bitbucket.org/xerial/sqlite-jdbc/wiki/Usage">wiki</a>
 * @author xiandeb
 */
public class PlainSQLiteJdbc {

	public static void main(String[] args) {
		
		String jdbcDriver = "org.sqlite.JDBC";
		try {
			// load the sqlite-JDBC driver using the current class loader
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		String url = "jdbc:sqlite:xland.db";
		Connection connection = null;
		try {
			// create a database connection
			connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			String sql = getSchameSQL();
			statement.executeUpdate(sql);
			ResultSet rs = statement.executeQuery("SELECT * FROM x_fellow");
			while (rs.next()) {
				// read the result set
				System.out.println("id = " + rs.getInt("id"));
				System.out.println("name = " + rs.getString("name"));
			}
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.out.println(e.getMessage());
		} finally {
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

	private static String getSchameSQL() {
		Charset charset = Charset.defaultCharset();
		System.out.println(charset);
		Resources.setCharset(charset);
		String resource = "schema.sql";
		try {
			InputStream input = Resources.getResourceAsStream(resource);
			return IOUtils.toString(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
