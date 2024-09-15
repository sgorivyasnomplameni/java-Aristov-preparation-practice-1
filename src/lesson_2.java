import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class lesson_2 {
    public static void main(String[] args) {
        Scanner fileScanner;
        File HTMLFile = new File("index.html"); // или cp1251 но у меня это не сработало
        String currentLine; // текущая строка

        try {
            fileScanner = new Scanner(HTMLFile, "UTF-8");
            while (fileScanner.hasNext()) {
                currentLine = fileScanner.nextLine();
                // currentLine.charAt()
                // currentLine.length()
                // currentLine.contains("<em>");
                int startPos = currentLine.indexOf("<em>");
                if (startPos != -1) // в строке содержится тег ем
                {
                    String keyword="";
                    int i=startPos+4;
                    while(currentLine.charAt(i)!='<')
                    {
                        keyword=keyword+currentLine.charAt(i);
                        i++;
                    }
                    // System.out.print(currentLine.indexOf("<em>") + " "); // возвращает позицию
                    // System.out.println(currentLine);
                    System.out.println(keyword);
                }
            }
            fileScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
