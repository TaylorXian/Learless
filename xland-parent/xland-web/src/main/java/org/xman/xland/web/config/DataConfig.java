package org.xman.xland.web.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@MapperScan("org.xman.xland.core.persistence")
public class DataConfig {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(org.sqlite.JDBC.class);
		dataSource.setUrl("jdbc:sqlite:xland.db");
		dataSource.setUsername("");
		dataSource.setPassword("");

		return dataSource;
	}

	/**
	 * @param dataSource
	 * @deprecated
	 */
	protected void createTable(SimpleDriverDataSource dataSource) {
		System.out.println("Creating tables");
		// create a table and populate some data
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "drop table if exists fellows";
		jdbcTemplate.execute(sql);
		sql = "create table fellows(id serial, name varchar(255), email varchar(255))";
		jdbcTemplate.execute(sql);
		sql = "INSERT INTO fellows(name, email) values (?,?)";
		jdbcTemplate.update(sql, "admin", "admin@gmail.com");
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("org.xman.xland.core.domain");
		return sessionFactory;
	}
}
