package org.xman.xland.util.crypto;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;


/**
 * <a href="https://my.oschina.net/kkrgwbj/blog/655215">
 *     JAVA DES加密和解密工具类</a>
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

    private final static String DES = "DES";

    public static void main(String[] args) {
        try {
            // initialize the ciphers with the given key
            String data = "123 456";
            String key = "1qaz@WSX";
            String encrypted = encrypt("This is a classified message!", key);
            String decrypted = decrypt(encrypted, key);
            System.out.println("Decrypted: " + decrypted);

            String encryptedF = encryptFile(".gitignore", key);
            System.out.println(encryptedF);
            Files.write(Paths.get(".encryptedF"), encryptedF.getBytes());
            System.out.println("Decrypted: " + decryptFile(".encryptedF", key));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String encryptFile(String path, String key) {
        byte[] bs = null;
        try {
            bs = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        byte[] en = encrypt(bs, key.getBytes());
        return Base64.encodeBase64String(en);
    }

    public static String decryptFile(String path, String key) {
        byte[] bs = null;
        try {
            bs = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        bs = Base64.decodeBase64(new String(bs));
        byte[] de = decrypt(bs, key.getBytes());
        return new String(de);
    }

    public static String encrypt(String data, String key) {
        byte[] en = encrypt(data.getBytes(), key.getBytes());
        return Base64.encodeBase64String(en);
    }

    public static String decrypt(String data, String key) {
        byte[] bs = Base64.decodeBase64(data);
        byte[] de = decrypt(bs, key.getBytes());
        return new String(de);
    }

    private static byte[] encrypt(byte[] data, byte[] key) {
        // 生成一个可以信任的随机数源
        SecureRandom sr = new SecureRandom();
        try {
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(key);

            // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey secretKey = keyFactory.generateSecret(dks);

            // Cipher 对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);

            return cipher.doFinal(data);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static byte[] decrypt(byte[] data, byte[] key) {
        // 生成一个可以信任的随机数源
        SecureRandom sr = new SecureRandom();
        try {
            // 从原始密钥数据创建DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(key);

            // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey secretKey = keyFactory.generateSecret(dks);

            // Cipher 对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);

            return cipher.doFinal(data);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}