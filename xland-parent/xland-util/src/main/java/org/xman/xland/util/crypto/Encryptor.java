package org.xman.xland.util.crypto;

import org.xman.xland.util.common.BaseTool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	public static void main(String[] args) {
		System.out.println(Encryptor.md5("中文", "UTF-8"));
		System.out.println(Encryptor.md5("sdfasdf", "UTF-8"));
		System.out.println(Encryptor.md5("国文", "UTF-8"));
		System.out.println(Encryptor.md5("美剧", "UTF-8"));
		System.out.println(BaseTool.dumpHex(new byte[] {1, 2, 3, 64, 65, 127, 72}));
	}

	public static String md5(String source, String charsetName) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] en = md5.digest(source.getBytes(charsetName));
			return BaseTool.dumpHex(en);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
