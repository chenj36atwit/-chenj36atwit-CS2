package wit.comp1050;

import java.util.Scanner;

import java.io.IOException;
import java.nio.file.*;

public class JFind
{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        System.out.println("Enter the file path you want to search: ");
        String x = sc.nextLine();
        System.out.println("Enter the type of file you want to search (Start with . ): ");
        String y = sc.nextLine();
        Path start = FileSystems.getDefault().getPath(x);

            Files.walk(start)
                    .filter(path -> path.toFile().isFile())
                    .filter(path -> path.toString().endsWith(y))
                    .forEach(System.out::println);
            System.exit(0);
    }
}
