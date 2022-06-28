import com.google.common.base.CharMatcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TxtFile {

    private File fileName;

    public TxtFile(File fileName) {
        this.fileName = fileName;
    }

    public String parseFile() throws FileNotFoundException {
        Scanner sc = new Scanner(fileName);

        StringBuilder parsedText = new StringBuilder();
        while (sc.hasNextLine()) {
            parsedText.append(sc.nextLine());
        }
        return parsedText.toString();
    }

    public int dotsQty(String text) {
        return CharMatcher.is('.').countIn(text);
    }

    public int numberOfWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        StringTokenizer tokens = new StringTokenizer(text);
        return tokens.countTokens();
    }

    public String mostRepeatedWord(String text) {
        String[] arr = text.split(" ");
        int maxFreq = 0;
        String mostRepeated = null;

        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (temp.equalsIgnoreCase(arr[j]))
                    count++;
            }
            if (maxFreq < count) {
                maxFreq = count;
                mostRepeated = temp;
            }
        }
        return mostRepeated;
    }
}
