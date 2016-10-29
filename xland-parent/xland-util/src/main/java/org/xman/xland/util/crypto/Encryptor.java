package org.xman.xland.util.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	public static void main(String[] args) {
		Encryptor en = new Encryptor();
		en.md5("中文", "UTF-8");
		en.md5("sdfasdf", "UTF-8");
		en.md5("国文", "UTF-8");
		en.md5("美剧", "UTF-8");
		System.out.println(en.dumpHex(new byte[] {1, 2, 3, 64, 65, 127, 72}));
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
		System.out.println(dumpHex(en));
	}

	public String dumpHex(byte[] bytes) {
		final char[] hex = "0123456789ABCDEF".toCharArray();
		final char[] chars = new char[bytes.length * 2];
		for (int i = 0, j = 0; i < bytes.length; i++) {
			chars[j++] = hex[bytes[i] >>> 4 & 0x0000000F];
			chars[j++] = hex[bytes[i] & 0x0000000F];
		}

		return new String(chars);
	}
}
