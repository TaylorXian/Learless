package org.xman.xland.util;

import java.io.UnsupportedEncodingException;

import org.xman.xland.util.crypto.Base64Tool;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		String source = "any carnal pleasu";
		source = "abcd";
		String charsetName = "UTF-8";
		try {
			String en = Base64Tool.encodeBase64(source, charsetName);
			System.out.println(en);
			String de = Base64Tool.decodeBase64(en, charsetName);
			System.out.println(de);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
