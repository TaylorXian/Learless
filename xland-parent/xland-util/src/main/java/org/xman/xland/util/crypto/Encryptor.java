package org.xman.xland.util.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	public static void main(String[] args) {
		Encryptor en = new Encryptor();
		en.md5("中文", "UTF-8");
	}

	private void md5(String source, String charsetName) {
		byte[] en = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			en = md5.digest(source.getBytes(charsetName));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(en);
	}

}
