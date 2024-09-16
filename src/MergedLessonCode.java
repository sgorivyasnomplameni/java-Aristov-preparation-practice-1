import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class MergedLessonCode {
    public static void main(String[] args) {
        Scanner fileScanner;
        File htmlFile = new File("index.html");
        String currentLine;
        ArrayList<String> keywords = new ArrayList<>();

        try {
            fileScanner = new Scanner(htmlFile, "UTF-8");
            while (fileScanner.hasNext()) {
                currentLine = fileScanner.nextLine();

                int startPos = currentLine.indexOf("<em>");
                while (startPos != -1) {
                    int endPos = currentLine.indexOf("</em>", startPos);
                    if (endPos != -1) {
                        String keyword = "";
                        int i = startPos + 4;
                        while (i < endPos) {
                            keyword = keyword + currentLine.charAt(i);
                            i++;
                        }
                        keywords.add(keyword);
                        startPos = currentLine.indexOf("<em>", endPos + 5);
                    } else {
                        break;
                    }
                }

                startPos = currentLine.indexOf("<meta name=\"keywords\"");
                if (startPos != -1) {
                    String keyword = "";
                    int i = startPos + 31;
                    while (currentLine.charAt(i) != '"') {
                        keyword = keyword + currentLine.charAt(i);
                        i++;
                    }
                    String[] keywordsFromMetaTag = keyword.split(",");
                    for (String word : keywordsFromMetaTag) {
                        keywords.add(word.trim());
                    }
                }
            }

            for (String keyword : keywords) {
                System.out.println(keyword);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
