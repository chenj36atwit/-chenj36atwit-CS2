package wit.comp1050;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class CryptKeeper
{
    private static String SECRET_KEY = "m1ss10nImp0ssi31e";

    public static byte[] encrypt(String plainText)
    {
        byte[] encryptedIVAndText = null;

        String key = SECRET_KEY;
        byte[] clean = plainText.getBytes();

        try {
            // Generating IV.
            int ivSize = 16;
            // byte[] iv = new byte[ivSize];
            byte[] iv = {78, 97, 116, 105, 118, 101, 80, 82, 78, 71, 90, 109, 100, 102, 77, 75};
            // SecureRandom random = new SecureRandom();
            // random.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            // Hashing key.
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(key.getBytes("UTF-8"));
            byte[] keyBytes = new byte[16];
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            // Encrypt.
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(clean);

            // Combine IV and encrypted part.
            encryptedIVAndText = new byte[ivSize + encrypted.length];
            System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
            System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);
        } catch (Exception ex) {
            System.out.printf("CryptKeeper.encrypt() exception: %s%n", ex.getMessage());
        }

        return encryptedIVAndText;
    }

    public static String decrypt(byte[] encryptedIvTextBytes)
    {
        byte[] decrypted = null;
        String key = SECRET_KEY;

        int ivSize = 16;
        int keySize = 16;

        try {
            // Extract IV.
            byte[] iv = new byte[ivSize];
            System.arraycopy(encryptedIvTextBytes, 0, iv, 0, iv.length);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            // Extract encrypted part.
            int encryptedSize = encryptedIvTextBytes.length - ivSize;
            byte[] encryptedBytes = new byte[encryptedSize];
            System.arraycopy(encryptedIvTextBytes, ivSize, encryptedBytes, 0, encryptedSize);

            // Hash key.
            byte[] keyBytes = new byte[keySize];
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(key.getBytes());
            System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            // Decrypt.
            Cipher cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            decrypted = cipherDecrypt.doFinal(encryptedBytes);
        } catch (Exception ex) {
            System.out.printf("CryptKeeper.decrypt() exception: %s%n", ex.getMessage());
        }

        return new String(decrypted);
    }
}