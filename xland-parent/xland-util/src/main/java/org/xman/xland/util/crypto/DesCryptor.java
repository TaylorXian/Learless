package org.xman.xland.util.crypto;

import org.apache.commons.codec.binary.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


/**
 * <a href="http://www.avajava.com/tutorials/lessons/how-do-i-encrypt-and-decrypt-files-using-des.html">
 *     How do I encrypt and decrypt files using DES</a>
 * <a href="http://stackoverflow.com/questions/5520640/encrypting-and-decrypting-using-java">
 *     encrypting-and-decrypting-using-java</a>
 * <a href="https://www.mkyong.com/java/jce-encryption-data-encryption-standard-des-tutorial/">
 *     jce des</a>
 * <a href="https://www.owasp.org/index.php/Using_the_Java_Cryptographic_Extensions">
 *     Using_the_Java_Cryptographic_Extensions</a>
 *
 * Created by xianjy on 2016/10/24.
 */
public class DesCryptor {


    private static Cipher ecipher;
    private static Cipher dcipher;

    private static SecretKey key;

    public static void main(String[] args) {

        try {
            // generate secret key using DES algorithm
            key = KeyGenerator.getInstance("DES").generateKey();

            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");

            // initialize the ciphers with the given key
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);

            String encrypted = encrypt("This is a classified message!");
            String decrypted = decrypt(encrypted);

            System.out.println("Decrypted: " + decrypted);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm:" + e.getMessage());
            return;
        } catch (NoSuchPaddingException e) {
            System.out.println("No Such Padding:" + e.getMessage());
            return;
        } catch (InvalidKeyException e) {
            System.out.println("Invalid Key:" + e.getMessage());
            return;
        }

    }

    public static String encrypt(String str) {
        try {
            // encode the string into a sequence of bytes using the named charset
            // storing the result into a new byte array.
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);
            // encode to base64
            enc = Base64.encodeBase64(enc);
            return new String(enc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String str) {
        try {
            // decode with base64 to get bytes
            byte[] dec = Base64.decodeBase64(str.getBytes());
            byte[] utf8 = dcipher.doFinal(dec);
            // create new string based on the specified charset
            return new String(utf8, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}