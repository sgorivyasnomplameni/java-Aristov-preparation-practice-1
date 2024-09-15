import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class lesson_3 {
    public static void main(String[] args) {
        Scanner fileScanner;
        File HTMLFile = new File("index.html"); // или cp1251 но у меня это не сработало
        String currentLine; // текущая строка
        ArrayList<String> keywords = new ArrayList<String>();

        try {
            fileScanner = new Scanner(HTMLFile, "UTF-8");
            while (fileScanner.hasNext()) {
                currentLine = fileScanner.nextLine();
                // currentLine.charAt()
                // currentLine.length()
                // currentLine.contains("<em>");
                int startPos = currentLine.indexOf("<em>"); // начальная позиция мета тега
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
                    keywords.add(keyword);

                }

                startPos = currentLine.indexOf("<meta name=\"keywords\"");
                if (startPos != -1) {
                    String keyword="";
                    int i=startPos+31;

                    while(currentLine.charAt(i)!='"') {
                        keyword=keyword+currentLine.charAt(i);
                        i++;
                    }
                    String[] KeywordsFromMetaTag;
                    KeywordsFromMetaTag=keyword.split(",");
                    for(int j=0;j<KeywordsFromMetaTag.length-1;j++)
                    {
                        keywords.add(KeywordsFromMetaTag[j]);
                    }

                }

            }


            for (int i = 0; i < keywords.size(); i++) {
               System.out.println(keywords.get(i));
             } // динамический массив в который записаны ключевые слова



            fileScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
