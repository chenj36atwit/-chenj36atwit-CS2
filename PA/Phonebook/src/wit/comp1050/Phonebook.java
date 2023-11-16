package wit.comp1050;

import java.io.*;
import java.util.*;

public class Phonebook {

    private Hashtable phonebook;
    private String name;
    private String number;
    private String birth;
    private String email;

    public Phonebook(){
        this.phonebook = new Hashtable();
    }

    public void addContact(String name, String number, String email, String birth){
        if(this.phonebook.containsKey(email)){
            System.out.println(email+ " exists.");
        }
        else {
            this.phonebook.put(name, number);
            this.phonebook.put(email, birth);
            System.out.println(name+" was added successfully.");
        }
    }

    public void find (String name){
        if(this.phonebook.containsKey(name)){
            String number = (String) this.phonebook.get(name);
            System.out.println(name+"'s number is "+number+" and "+ "their email is: "+email+" and date of birth: "+birth+" .");
        } else {
            System.out.println("No person named '"+name+"' exists.");
        }
    }

    public void getAllContacts(){
        Enumeration names;
        names = this.phonebook.keys();
        int total = 0;
        while(names.hasMoreElements()) {
            String str = String.valueOf(names.nextElement());
            System.out.println(str + " " + this.phonebook.get(str));
            total++;
        }
        System.out.println("Total "+total+" persons.");
    }

    public void remove(String name){
        if(this.phonebook.containsKey(name)){
            this.phonebook.remove(name);
            System.out.println(name+" was deleted successfully.");
        } else {
            System.out.println("No person named '"+name+"' exists.");
        }
    }

    public void saveToFile(String fileName) throws IOException{
        FileWriter fw = new FileWriter("phonebook.out");
        Enumeration names = this.phonebook.keys();
        Enumeration nums = this.phonebook.elements();
        Enumeration mails = this.phonebook.elements();
        Enumeration bdays = this.phonebook.elements();
        int total=0;
        while(names.hasMoreElements()){
            String name = String.valueOf(names.nextElement());
            String num = String.valueOf(nums.nextElement());
            String mail = String.valueOf(mails.nextElement());
            String bday = String.valueOf(bdays.nextElement());
            fw.write(name+" "+num+" "+mail+" "+bday+" \r\n");
            total++;
        }
        System.out.println("Saved "+total+ " persons");
        fw.close();
    }

    public void readFromFile(String fileName) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("phonebook.out"));
        String line = read.readLine();
        int total = 0;
        while (line != null) {
            String[] arr = line.split(" ");
            String name = arr[0];
            String num = arr[1];
            String mail = arr[2];
            String bday = arr[3];

            this.phonebook.put(name, num);
            total++;
            line = read.readLine();
        }
        System.out.println("Total "+total+" persons.");
        read.close();
    }
}
