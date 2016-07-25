package org.xman.xland.core;

import org.xman.xland.core.jdbc.PlainSQLiteJdbc;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Run Jdbc!");

		PlainSQLiteJdbc sqlite = new PlainSQLiteJdbc();
		sqlite.execute();
	}
}
