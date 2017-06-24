package org.xman.xland.util;

import gnu.crypto.Registry;
import gnu.crypto.hash.HashFactory;
import gnu.crypto.hash.IMessageDigest;
import org.apache.commons.codec.digest.DigestUtils;
import org.xman.xland.util.crypto.Base64Tool;
import org.xman.xland.util.crypto.DigestTool;
import org.xman.xland.util.crypto.HmacTool;

import java.io.UnsupportedEncodingException;

/**
 * App Main Test.
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		String source = "any carnal pleasu";
		source = "abcdefg 中文";
		String charsetName = "UTF-8";
		String input = "中文123abc,./";
		System.out.println(DigestUtils.md5Hex(input));
		// 中文123abc,./ md5
		// 9ba58cffe5815ea9f365b86a3f473ad5 java DigestUtils.md5Hex("中文123abc,./")
		// 9ba58cffe5815ea9f365b86a3f473ad5 php md5('中文123abc,./')
		System.out.println(DigestUtils.sha1Hex(input));
		System.out.println(DigestTool.sha1Hex(input));
		// ec2f9a1f8f601dd5e6889d65204a7a998a0aa389 java DigestUtils.sha1Hex("中文123abc,./")
		// ec2f9a1f8f601dd5e6889d65204a7a998a0aa389 php sha1('中文123abc,./');
		System.out.println(gnuWhirlpool(input, "UTF-8"));
		System.out.println(gnuWhirlpool("中文123abc,./", "UTF-8"));
		System.out.println(gnuWhirlpool("中文123abc,./", "GBK"));
		try {
			System.out.println(DigestTool.whirlpool("中文123abc,./"));
			System.out.println(DigestTool.whirlpool("中文The quick brown fox jumps over the lazy dog"));
			String en = Base64Tool.encodeBase64(source, charsetName);
			System.out.println(en);
			String de = Base64Tool.decodeBase64(en, charsetName);
			System.out.println(de);
			System.out.println(HmacTool.hmac("key", "message"));
			System.out.println(HmacTool.hmac("key", input));
			// 64 bytes key
			String key = "0123456789:;ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			System.out.println(HmacTool.hmac(key, input));
			System.out.println(DigestTool.pbkdf2(input, "salt", 1024, 128));
			System.out.println(DigestTool.hashPassword(input));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		for (int i = 32; i < 130; i++) {
			System.out.printf("%c", i);
		}
	}

	/**
	 * The result is different with Php whirlpool algorithm.
	 *
	 * @param input
	 * @param charsetName
	 * @return
	 */
	private static String gnuWhirlpool(String input, String charsetName) {
		IMessageDigest md = HashFactory.getInstance(Registry.WHIRLPOOL_HASH);
		byte[] bytes;
		try {
			bytes = input.getBytes(charsetName);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		md.update(bytes, 0, bytes.length);
		byte[] digest = md.digest();
		return gnu.crypto.util.Util.toString(digest).toLowerCase();
	}

}
