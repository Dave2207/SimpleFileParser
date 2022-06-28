import com.google.common.base.CharMatcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TxtFile{

    private File fileName;

    public TxtFile() {
        super();

    }

    public String parseFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        StringBuilder parsedText = new StringBuilder();
        while (sc.hasNextLine()){
            parsedText.append(sc.nextLine());
        }
        return parsedText.toString();
    }

    public int dotsQty(String text){
        return CharMatcher.is('.').countIn(text);
    }

    public int numberOfWords(String text){
        if(text == null || text.isEmpty()){
            return 0;
        }
        StringTokenizer tokens = new StringTokenizer(text);
        return tokens.countTokens();
    }

    public String mostRepeatedWord(String text){
        return "";
    }
}
