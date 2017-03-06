package org.xman.xland.util.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class DigestTool {

	static char[] hs = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String digest(String input, String algorithm) {
		return digest(input, algorithm, "UTF-8");
	}

	public static String digest(String input, String algorithm, String charsetName) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(input.getBytes(charsetName));
			byte[] buffer = md.digest();

			StringBuilder sb = new StringBuilder(buffer.length * 2);
			for (int i = 0; i < buffer.length; i++) {
				byte b = buffer[i];
				sb.append(hs[b >>> 4 & 0x0F]).append(hs[b & 0x0F]);
			}

			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		String algorithm = "md5";
		String input = "测试";

		System.out.println(digest(input, algorithm));
		System.out.println(DigestUtils.md5Hex(input));
		System.out.println(DigestUtils.sha256Hex(input));
		System.out.println(DigestUtils.sha512Hex(input));
	}

}
