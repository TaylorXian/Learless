package org.xman.xland.util.common;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * Base Tool
 *
 * Created by xiandeb on 17/6/18.
 */
public class BaseTool {

    public static <T> T[] joinArrayGeneric(T[]... arrays) {
        int length = 0;
        for (T[] array : arrays) {
            length += array.length;
        }

        final T[] result = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);

        int offset = 0;
        for (T[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }

    public static byte[] joinArray(byte[] ... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }

        final byte[] result = new byte[length];

        int offset = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }

    public static String dumpHex(byte[] bytes) {
        final char[] hex = "0123456789abcdef".toCharArray();
        final char[] chars = new char[bytes.length * 2];
        for (int i = 0, j = 0; i < bytes.length; i++) {
            chars[j++] = hex[bytes[i] >>> 4 & 0x0000000F];
            chars[j++] = hex[bytes[i] & 0x0000000F];
        }

        return new String(chars);
    }

    public static byte[] getUTF8Bytes(String string) {
        try {
            return string.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static byte[] int2BigEndianArray(int i) {
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(i).array();
    }

    public static byte[] xorTwoByteArray(byte[] arr1, byte[] arr2) {
        byte[] re; int len;
        if (arr1.length > arr2.length) {
            re = Arrays.copyOf(arr1, arr1.length);
            len = arr2.length;
        } else {
            re = Arrays.copyOf(arr2, arr2.length);
            len = arr1.length;
        }
        for (int i = 0; i < len; i++) {
            re[i] = (byte) (arr1[i] ^ arr2[i]);
        }
        return re;
    }
}
