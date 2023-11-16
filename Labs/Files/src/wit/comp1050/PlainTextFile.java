package wit.comp1050;

import java.io.*;
import java.nio.file.Path;

import java.io.IOException;
import java.util.Scanner;

public class PlainTextFile {

    private static Scanner sc = new Scanner(System.in);

    public String readAll() throws IOException {

        try {
            File f1 = new File("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\plaintext.txt");
            File f2 = new File("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\appendtext.txt");

            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            BufferedReader br2 = new BufferedReader(new FileReader(f1));

            String st1;
            while ((st1 = br1.readLine()) != null)
                System.out.println("Plaintext.txt file content: "+st1);
            String st2;
            while ((st2 = br2.readLine()) != null)
                System.out.println("Appendtext.txt file content: "+st2);

        } catch(Exception e) {
                System.out.println(e);
            }

        return toString();
    }

    public String write(String text) throws IOException {

        try{
            FileWriter fw = new FileWriter("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\plaintext.txt");
            fw.write(text);
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("PlainText Successfull");

        return text;
    }

    public String append(String text) throws IOException
    {

        try {
            String data = (text);
            File f1 = new File("D:\\Dev\\Labs\\Files\\src\\wit\\comp1050\\appendtext.txt");
            if(!f1.exists()) {
                f1.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(data);
            bw.close();
            System.out.println("Done");
        } catch(IOException e){
            e.printStackTrace();
        }

        return text;

    }

    // Fields
    protected Path _path;



}
