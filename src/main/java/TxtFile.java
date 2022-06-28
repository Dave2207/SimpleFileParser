import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
