package wit.comp1050;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.management.openmbean.InvalidKeyException;
import java.io.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class EncryptedTextFile {

    static void fileProcessor(int cipherMode,String key,File inputFile,File outputFile){

        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IOException | java.security.InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public static void start() {
        String key = "This is a secret";
        File inputFile = new File("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\plaintext.txt");
        File encryptedFile = new File("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\encrypted.txt");
        File decryptedFile = new File("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\decrypted.txt");

        try {
            EncryptedTextFile.fileProcessor(Cipher.ENCRYPT_MODE,key,inputFile,encryptedFile);
            EncryptedTextFile.fileProcessor(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);
            System.out.println("Encrypt and Decrypt Done!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String readAll() throws IOException {

        try {
            File f1 = new File("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\encrypted.txt");
            File f2 = new File("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\decrypted.txt");

            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            BufferedReader br2 = new BufferedReader(new FileReader(f2));

            String st1;
            while ((st1 = br1.readLine()) != null)
                System.out.println("encrypted.txt file content: "+st1);
            String st2;
            while ((st2 = br2.readLine()) != null)
                System.out.println("decrypted.txt file content: "+st2);

        }   catch(Exception e) {
            System.out.println(e);
        }

        return toString();
    }


}




