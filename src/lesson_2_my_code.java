import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lesson_2_my_code {
    public static void main(String[] args) {
        Scanner fileScanner;
        File htmlFile = new File("index.html");
        String currentLine;

        try {
            fileScanner = new Scanner(htmlFile, "UTF-8");
            while (fileScanner.hasNext()) {
                currentLine = fileScanner.nextLine();

                int startPos = currentLine.indexOf("<em>");
                while (startPos != -1) {
                    int endPos = currentLine.indexOf("</em>", startPos);
                    if (endPos != -1) {
                        // Извлечение текста между тегами <em> и </em>
                        String keyword = "";
                        int i = startPos + 4; // Начинаем после <em>
                        while (i < endPos) {
                            keyword = keyword + currentLine.charAt(i);
                            i++;
                        }
                        System.out.println(keyword);

                        // Ищем следующий тег <em> в той же строке
                        startPos = currentLine.indexOf("<em>", endPos + 5);
                    } else {
                        // Если закрывающий тег не найден, выходим из цикла
                        break;
                    }
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
