import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static String pathToFile = "";
    private static ArrayList<File> myFiles;

    public static void main(String[] args){
        pathToFile = args[0];
        //Se abre un loop para recorrer el directorio. Validar primero si es un directorio
        if(isValidPath(pathToFile)){
            File f = new File(pathToFile);
            String[] pathNames = f.list();

            for (String pathName: pathNames) {
                System.out.println(pathName);
            }
        } else{
            System.out.println("The path introduced is not a valid directory");
        }
    }


    public static boolean isValidPath(String filePath){
        File file = new File(filePath);

        return file.isDirectory();
    }


}
