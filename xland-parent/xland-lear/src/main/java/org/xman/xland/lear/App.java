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

	private static String urlDecode(String string) {
		try {
			return URLDecoder.decode(string, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	static final int MAXIMUM_CAPACITY = 1 << 30;

	public static void main(String[] args) {
		System.out.println("URLDecoder decode empty string :");
		System.out.println(urlDecode(""));
		for (int i = 0; i < 10000; i ++) {
			System.out.println(i + " " + tableSizeFor(i));
		}
	}

	/**
	 * Returns a power of two size for the given target capacity.
	 *
	 * @param cap
	 * @return
     */
	static int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

}
