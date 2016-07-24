package org.xman.xland.core.mybatis;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;

public class MybatisDataSource {

	/**
	 * Create a pooled data source.
	 * 
	 * @param filepath
	 * @return
	 * @throws IOException
	 */
	public static DataSource create(String filepath) throws IOException {
		DataSourceFactory dsFactory = new PooledDataSourceFactory();
		Properties props = Resources.getResourceAsProperties(filepath);
		dsFactory.setProperties(props);
		return dsFactory.getDataSource();
	}

}
