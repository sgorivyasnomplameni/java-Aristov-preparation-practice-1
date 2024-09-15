import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class lesson_1 {
    public static void main(String[] args) {
            Scanner fileScanner;
            File HTMLFile = new File("index.html"); // или cp1251 но у меня это не сработало

            try {
                fileScanner = new Scanner(HTMLFile, "UTF-8");
                while (fileScanner.hasNext()) {
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found");
            }

    }
}