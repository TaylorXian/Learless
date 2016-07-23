package org.xman.xland.core.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.xman.xland.core.domain.Fellow;
import org.xman.xland.core.persistence.FellowMapper;

public class PlainMybatis {

	private String resource = "mybatis-config.xml";
	private SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) throws IOException {
		PlainMybatis mybatis = new PlainMybatis();
		mybatis.runFromAnnotation();
//		mybatis.runFromXml();
	}

	public void runFromAnnotation() throws IOException {
		buildingSqlSessionFactory();

		SqlSession session = sqlSessionFactory.openSession();
		int id = 1;
		FellowMapper mapper = session.getMapper(FellowMapper.class);
		Fellow fellow = mapper.selectByPrimaryKey(id);
		System.out.println(fellow.getName());
	}

	public void runFromXml() throws IOException {
		buildingSqlSessionFactoryFromXml();

		SqlSession session = sqlSessionFactory.openSession();
		int id = 1;
		FellowMapper mapper = session.getMapper(FellowMapper.class);
		Fellow fellow = mapper.findByIdXml(id);
		System.out.println(fellow.getName());
	}

	/**
	 * Building SqlSessionFactory from XML
	 * 
	 * @throws IOException
	 */
	private void buildingSqlSessionFactoryFromXml() throws IOException {
		InputStream inputStream = getInputStream();
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	private InputStream getInputStream() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return inputStream;
	}

	/**
	 * Building SqlSessionFactory without XML
	 * 
	 * @throws IOException
	 */
	private void buildingSqlSessionFactory() throws IOException {
		DataSource dataSource = getDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development",
				transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(FellowMapper.class);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}

	private DataSource getDataSource() throws IOException {
		DataSourceFactory dataSourceFactory = new PooledDataSourceFactory();
		Properties props = Resources.getResourceAsProperties("db.config.properties");
		dataSourceFactory.setProperties(props);
		return dataSourceFactory.getDataSource();
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
