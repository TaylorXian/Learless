package org.xman.xland.core;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.xman.xland.util.props.PropsUtil;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testPropsUtil() {
		PropsUtil props = new PropsUtil("db.config.properties");
		String url = props.getString("driver");
		System.out.println("url is " + url);
		assertTrue(url.equals("org.sqlite.JDBC"));
		assertTrue(true);
	}

}
