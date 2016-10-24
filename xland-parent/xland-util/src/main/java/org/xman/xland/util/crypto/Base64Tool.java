package org.xman.xland.util.crypto;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Base64Tool {

	private static final char[] toBase64 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', '+', '/' };

	private static int[] fromBase64 = new int[128];

	static {
		Arrays.fill(fromBase64, -1);
		for (int i = 0; i < toBase64.length; i++) {
			fromBase64[toBase64[i]] = i;
		}
		fromBase64['='] = 0;
	}

	/**
	 * doPadding base64
	 * 
	 * @param origin
	 * @param charsetName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeBase64(final String source, String charsetName)
			throws UnsupportedEncodingException {
		byte[] src = null;
		try {
			src = source.getBytes(charsetName);
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
		byte[] dst = encode(src);

		return new String(dst, charsetName);
	}

	private static byte[] encode(byte[] src) {
		final int H_FF = 0xFF, H_3F = 0x3f;
		final char[] base64 = toBase64;
		int si = 0, sl = src.length, slen = sl / 3 * 3;
		int di = 0, dl = enLen(sl);
		byte[] dst = new byte[dl];
		while (si < slen) {
			int bits = (src[si++] & H_FF) << 16 | (src[si++] & H_FF) << 8
					| (src[si++] & H_FF);
			dst[di++] = (byte) base64[(bits >>> 18) & H_3F];
			dst[di++] = (byte) base64[(bits >>> 12) & H_3F];
			dst[di++] = (byte) base64[(bits >>> 6) & H_3F];
			dst[di++] = (byte) base64[bits & H_3F];
		}
		if (si < sl) {
			int b0 = src[si++] & H_FF;
			dst[di++] = (byte) base64[(b0 >>> 2) & H_3F];
			if (si == sl) {
				dst[di++] = (byte) base64[(b0 << 4) & H_3F];
				dst[di++] = '=';
				dst[di++] = '=';
			} else {
				int b1 = src[si++] & H_FF;
				dst[di++] = (byte) base64[(b0 << 4) & H_3F | (b1 >> 2)];
				dst[di++] = (byte) base64[(b1 << 4) & H_3F];
				dst[di++] = '=';
			}
		}
		return dst;
	}

	private static int enLen(int srclen) {
		// doPadding length
		return (srclen + 2) / 3 * 4;
	}

	private static int deLen(int srclen) {
		// doPadding length
		return srclen / 4 * 3;
	}

	public static String decodeBase64(final String source, String charsetName)
			throws UnsupportedEncodingException {
		byte[] src = null;
		try {
			src = source.replaceAll("", "").getBytes(charsetName);
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
		byte[] dst = new byte[deLen(src.length)];
		int len = decode(src, dst);

		byte[] dd = Arrays.copyOf(dst, len);
		return new String(dd, charsetName);
	}

	private static int decode(byte[] src, byte[] dst) {
		final int[] base64 = fromBase64;
		int si = 0, sl = src.length;
		int di = 0;
		while (si < sl) {
			int bits = (base64[src[si++]] & 0x3f) << 18 | 
					(base64[src[si++]] & 0x3f) << 12 |
					(base64[src[si++]] & 0x3f) << 6 |
					(base64[src[si++]] & 0x3f);
			dst[di++] = (byte) ((bits >> 16) & 0xFF);
			dst[di++] = (byte) ((bits >> 8) & 0xFF);
			dst[di++] = (byte) (bits & 0xFF);
		}
		

		return di;
	}

	
	
}
