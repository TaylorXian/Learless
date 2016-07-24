package org.xman.xland.web.config;

import java.io.IOException;
import java.sql.Driver;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.xman.xland.core.mybatis.MybatisDataSource;
import org.xman.xland.util.props.PropsUtil;

@Configuration
@MapperScan("org.xman.xland.core.persistence")
public class DataConfig {

	private DataSource createSimpleDataSource() throws ClassNotFoundException {
		PropsUtil props = new PropsUtil("db.config.properties");
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass((Class<? extends Driver>) Class.forName(props.getString("driver")));
		dataSource.setUrl(props.getString("url"));
		dataSource.setUsername("");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public DataSource dataSource() {
		try {
			return MybatisDataSource.create("db.config.properties");
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * @param dataSource
	 * @deprecated
	 */
	protected void createTable(DataSource dataSource) {
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
