package wit.comp1050;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Contact {

    public static void main(String[] args ) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Phonebook phoneBook = new Phonebook();

        while(true){
            System.out.print("$");

            String command = scanner.next();

            if(command.equals("add")){
                String name = scanner.next();
                String number = scanner.next();
                String email = scanner.next();
                String birth = scanner.next();
                phoneBook.addContact(name, number, email, birth);
            }
            else if(command.equals("find")){
                String name = scanner.next();
                phoneBook.find(name);
            }
            else if(command.equals("ViewAll")){
                phoneBook.getAllContacts();
            }
            else if(command.equals("delete")){
                String name = scanner.next();
                phoneBook.remove(name);
            }
            else if(command.equals("load")){
                String fileName = scanner.next();
                phoneBook.readFromFile(fileName);
            }
            else if(command.equals("save")){
                String fileName = scanner.next();
                phoneBook.saveToFile(fileName);
            }
            else if(command.equals("exit")){
                break;
            }
        }
        scanner.close();
    }
}

