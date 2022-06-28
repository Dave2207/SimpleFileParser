import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileParserTest {
    @Test
    public void testDotsQty() throws IOException {
        int expected = 2;
        File myFile = new File("filename.txt");
        FileWriter fileW = new FileWriter(myFile);
        fileW.write("This is a test. The result needs to be 2.");
        fileW.close();
        TxtFile myTxt = new TxtFile(myFile);
        assert myTxt.dotsQty(fileW.toString()) == expected;
        myFile.delete();
    }

//    @Test
//    public void testWordsCount() throws IOException {
//        int expected = 10;
//        File myFile = new File("file2.txt");
//        FileWriter fileW = new FileWriter(myFile);
//        fileW.write("This is a test. The result needs to be ten.");
//        fileW.close();
//        TxtFile myTxt = new TxtFile(myFile);
//        assert myTxt.numberOfWords(fileW.toString()) == expected;
//        myFile.delete();
//    }
}
