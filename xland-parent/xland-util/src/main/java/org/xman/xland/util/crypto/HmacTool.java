package org.xman.xland.util.crypto;

import org.apache.commons.codec.binary.Hex;
import org.xman.xland.util.common.BaseTool;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Hmac Tool
 *
 * Created by xiandeb on 17/6/18.
 */
public class HmacTool {
    private static int BLOCK_SIZE = 64;

    /**
     * hamc with whirlpool<br />
     *
     * <a href="https://en.wikipedia.org/wiki/Hash-based_message_authentication_code">hamc</a>
     *
     * @param key key
     * @param message message
     * @return
     */
    public static String hmac(String key, String message) {
        return hmac(key, message, "UTF-8");
    }

    public static String hmac(String key, String message, String charsetName) {
        try {
            byte[] key0 = key.getBytes(charsetName);
            byte[] message0 = message.getBytes(charsetName);
            return Hex.encodeHexString(hmac(key0, message0));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static byte[] hmac(byte[] key, byte[] message) {
        byte[] key0 = key;
        if (key.length > BLOCK_SIZE) {
            key0 = hash(key);
        }
        if (key.length < BLOCK_SIZE) {
            key0 = Arrays.copyOf(key, BLOCK_SIZE);
        }
        byte[] o_key_pad = new byte[BLOCK_SIZE];
        byte[] i_key_pad = new byte[BLOCK_SIZE];
        for (int i = 0; i < BLOCK_SIZE; i++) {
            o_key_pad[i] = (byte) (0x5c ^ key0[i]);
            i_key_pad[i] = (byte) (0x36 ^ key0[i]);
        }
        return hash(BaseTool.joinArray(o_key_pad, hash(BaseTool.joinArray(i_key_pad, message))));
    }

    /**
     * whirlpool hash with blocksize 64bytes
     *
     * @param input
     * @return
     */
    public static byte[] hash(byte[] input) {
        Whirlpool w = new Whirlpool();
        byte[] digest = new byte[Whirlpool.DIGESTBYTES];
        w.NESSIEinit();
        w.NESSIEadd(input);
        w.NESSIEfinalize(digest);
        return digest;
    }

}
