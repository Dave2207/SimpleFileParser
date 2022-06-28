import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static String pathToFile;
    private TxtFile logics = new TxtFile();
    public static void main(String[] args) throws IOException {
        pathToFile = args[0];
        //While(true) for the endless loop (Adding soon)
        if(isValidPath(pathToFile)){
            File f = new File(pathToFile);
            File processedDir = new File(pathToFile + "/processed");
            //Create processed Sub-directory if doesn't exist already
            if(!processedDir.exists()){
                processedDir.mkdir();
            }
            //For this exercise, we check if file is supported using this FilenameFilter. But for scalability this will have to change
            File[] filesInPath = f.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });

            for (File file: filesInPath) {
                //1. Check if file is already processed. DONE
                if(!isFileProcessed(processedDir, file)){
                    //2. Process the file

                } else {
                    break;
                }
                //3. Print statistics
                //4. Copy file to "processed" sub-directory
            }
        } else{
            System.out.println("The path introduced is not a valid directory");
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

}
