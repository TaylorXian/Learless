package org.xman.xland.core.mybatis;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class PlainGenerator {

	public static void main(String[] args) {
		String configFile = "generatorConfig.xml";
		generate(configFile);
		generate("generatorConfig-auth.xml");
		generate("generatorConfig-resource.xml");
	}

	private static void generate(String resource) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		try {
			// SQLite
			File configFile = Resources.getResourceAsFile(resource);
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("warnings : ");
			for (String w : warnings) {
				System.out.println(w);
			}
			System.out.println("PlainGenerator is done.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
