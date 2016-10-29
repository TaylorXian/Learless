package org.xman.xland.lear;

import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

/**
 * The three way of Maven running Java main.
 *
 * 1. mvn exec:java -Dexec.mainClass="org.xman.xland.lear.App"
 *
 * 
 * Reference
 * http://www.tuicool.com/articles/UJJvim
 */
public class App {

	private static String test(String string) {
		try {
			return URLDecoder.decode(string, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		System.out.println("URLDecoder decode empty string :");
		System.out.println(test(""));
	}

}
