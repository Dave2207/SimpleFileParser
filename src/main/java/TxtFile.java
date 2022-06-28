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

}
