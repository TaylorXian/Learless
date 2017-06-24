package org.xman.xland.core.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.xman.xland.util.props.PropsUtil;

/**
 * SQLite JDBC Sample
 *
 * @see <a href="https://bitbucket.org/xerial/sqlite-jdbc">sqlite-jdbc</a>
 * @see <a href="https://bitbucket.org/xerial/sqlite-jdbc/wiki/Usage">wiki</a>
 * @author xiandeb
 */
public class PlainSQLiteJdbc extends JdbcBase {

	private String driver = null;

	private String url = null;

	private String schemaSql = null;

	private String query = null;

	public PlainSQLiteJdbc() {
		init();
	}

	protected void init() {
		String dbConfig = "db.config.properties";
		PropsUtil props = new PropsUtil(dbConfig);
		driver = props.getString("driver");
		url = props.getString("url");
		String schemaSqlFile = props.getString("schema.sql.file", "schema.sql");
		schemaSql = getSchemaSQL(schemaSqlFile);
		query = props.getString("query.sql", "SELECT * FROM x_fellow");
	}


	public void execute() {
		try {
			loadDriver(driver);
			createConnection(url);
			createStatement();

			// create schema
			// executeUpdate(schemaSql);
			// execute query
			ResultSet rs = executeQuery(query);
			// println ResultSet
			while (rs.next()) {
				// read the result set
				System.out.println("id = " + getInt(rs, "id"));
				System.out.println("name = " + getString(rs, "name"));
			}
		} catch (ClassNotFoundException e) {
			// load driver class error
			e.printStackTrace();
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	private String getSchemaSQL(String filepath) {
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream(filepath);
			return IOUtils.toString(input, defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(input);
		}
		throw new RuntimeException("can't find schema sql file: " + filepath);
	}

	/**
	 * UTF-8
	 *
	 * @return
	 */
	private Charset defaultCharset() {
		Charset charset = Charset.defaultCharset();
		return charset;
	}

}
