package org.xman.xland.util.crypto;

import org.apache.commons.codec.digest.DigestUtils;
import org.xman.xland.util.common.BaseTool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestTool {

	public static String SHA_1 = "SHA-1";

	public static String sha1Hex(String input) {
		return digest(input, SHA_1, "UTF-8");
	}

	/**
	 * Algorithm
	 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">MessageDigest Algorithms</a>
	 *
	 * @param input
	 * @param algorithm
	 * @return
	 */
	public static String digest(String input, String algorithm) {
		return digest(input, algorithm, "UTF-8");
	}

	public static String digest(String input, String algorithm, String charsetName) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(input.getBytes(charsetName));
			byte[] buffer = md.digest();

			return BaseTool.dumpHex(buffer);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * The result is Same as Php hash_('whirlpool', $message). <br />
	 * <a href="http://www.larc.usp.br/~pbarreto/WhirlpoolPage.html">The WHIRLPOOL Hash Function</a>
	 *
	 * @param message message to encrypt(UTF-8 required)
	 * @return
	 * @throws RuntimeException UnsupportedEncodingException
	 */
	public static String whirlpool(String message) {
		try {
			byte[] digest = HmacTool.hash(message.getBytes("UTF-8"));
			return BaseTool.dumpHex(digest);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * pbkdf2 with Whirlpool hash algorithm.
	 *
	 *
	 * @param message
	 * @param salt
	 * @param iteration
	 * @param length
	 * @return
	 */
	public static String pbkdf2(String message, String salt, int iteration, int length) {
		int hLength = 64;
		int blockCount = (int) Math.ceil(length * 1.0D / hLength);
		byte[] last, xorsum, output = null;
		byte[] salt0 = BaseTool.getUTF8Bytes(salt);
		byte[] message0 = BaseTool.getUTF8Bytes(message);
		for (int i = 1; i <= blockCount; i++) {
			last = BaseTool.joinArray(salt0, BaseTool.int2BigEndianArray(i));
			// ??
			// I think the message is hmac's message and last is key,
			// but implementation of  the php pbkdf2 is opposite that the message is key, last is hmac's message.
			// So, here is the same with the php.
			last = xorsum = HmacTool.hmac(message0, last);
			for (int j = 1; j < iteration; j++) {
				last = HmacTool.hmac(message0, last);
				xorsum = BaseTool.xorTwoByteArray(xorsum, last);
			}
			output = output == null ? xorsum : BaseTool.joinArray(output, xorsum);
		}
		return BaseTool.dumpHex(output).substring(0, length);
	}

	public static String hashPassword(String password) {
		String salt = sha1Hex(password);
		return pbkdf2(password, salt, 1024, 128);
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
