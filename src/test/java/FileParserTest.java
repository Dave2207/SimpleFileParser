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
        assert App.dotsQty(fileW.toString()) == expected;
        myFile.delete();
    }
//
//    @Test
//    public void testMostRepeatedWord() throws IOException{
//        String expected = "word";
//        File myFile = new File("repeated.txt");
//        FileWriter fileW = new FileWriter(myFile);
//        fileW.write("word. Most repeated word is word");
//        fileW.close();
//        assert App.mostRepeatedWord(fileW.toString()).equalsIgnoreCase(expected);
//        myFile.delete();
//    }
//
//    @Test
//    public void testNumberOfWords() throws IOException {
//        int expected = 3;
//        File myFile = new File("file2.txt");
//        FileWriter fileW = new FileWriter(myFile);
//        fileW.write("A new thing");
//        fileW.close();
//        assert App.numberOfWords(fileW.toString()) == expected;
//        myFile.delete();
//    }
}
