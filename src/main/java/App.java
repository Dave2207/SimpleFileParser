import com.google.common.base.CharMatcher;
import com.google.common.io.Files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.StringTokenizer;

public class App {

    private static String pathToFile;
    public static void main(String[] args) throws IOException {
        pathToFile = args[0];
        while(true) {
            if (isValidPath(pathToFile)) {
                File f = new File(pathToFile);
                File processedDir = new File(pathToFile + "/processed");
                //Create processed Sub-directory if doesn't exist already
                if (!processedDir.exists()) {
                    processedDir.mkdir();
                }
                //For this exercise, we check if file is supported using this FilenameFilter. But for scalability this will have to change
                File[] filesInPath = f.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".txt");
                    }
                });

                for (File file : filesInPath) {
                    //Check if file is already processed
                    if (!isFileProcessed(processedDir, file)) {
                        //Process the file
                        TxtFile txt = new TxtFile(file);
                        String fileText = txt.parseFile();
                        //Print statistics
                        System.out.println("File: " + file.getName());
                        System.out.println("Total number of dots: " + dotsQty(fileText));
                        System.out.println("Total number of words: " + numberOfWords(fileText));
                        System.out.println("Most repeated word: " + mostRepeatedWord(fileText));
                        System.out.println("---------------------------------------------------------------------------");
                        //Copy file to "processed" sub-directory
                        try {
                            String newRoute = processedDir.getCanonicalPath() + File.separator + file.getName();
                            Files.copy(file, new File(newRoute));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("The path introduced is not a valid directory");
            }
        }
    }


    public static boolean isValidPath(String filePath){
        File file = new File(filePath);

        return file.isDirectory();
    }

    public static boolean isFileProcessed(File dir, File file) throws IOException {
        File child = new File(dir.getCanonicalPath() + File.separator + file.getName());
        return child.exists();
    }

    public static int dotsQty(String text) {
        return CharMatcher.is('.').countIn(text);
    }

    public static int numberOfWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static String mostRepeatedWord(String text) {
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
