package Test.Parser;

import Class.Classes;
import Methods.Lines.LinesEffectives;
import Methods.Methods.MediaLinesMethods;
import Methods.Methods.Methods;
import Package.Files.FilesFolders;
import Package.Files.MediaSizeFiles;
import Package.Files.ReaderFile;
import Package.Packages.Packages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class Parser {
    
    public Parser() {
    }
    
    @Test
    public void ResultParser() throws FileNotFoundException, IOException{
        double percentEffectives = 0.;
        int totalLines = 0;
        int totalEffectives = 0;
        MediaLinesMethods medialinesmethods = null;

        ReaderFile reader = new ReaderFile("src/Class/Classes.java");

        File folder = new File("src");

        FilesFolders numfiles = new FilesFolders(folder);

        Classes numclasses = new Classes(reader);

        Packages packages = new Packages(new File("src"));

        ArrayList<String> arrayfiles = numfiles.getArrayListFiles();

        for (String path : arrayfiles) {

            System.out.println("-------" + path + "-------");

            reader = new ReaderFile(path);

            LinesEffectives lineseffectives = new LinesEffectives(reader);

            Methods numMethods = new Methods(reader);

            if (numMethods.getCount() > 0) {
                medialinesmethods = new MediaLinesMethods(reader);
            }
            
            
            MediaSizeFiles mediasize = new MediaSizeFiles(folder);

            System.out.println("Numero de ficheros .java en el directorio: " + numfiles.getCount());

            System.out.println("Numero de paquetes efectivos del directorio: " + packages.getCount());

            System.out.println("Numero de clases del fichero: " + numclasses.getCount());
      
            System.out.println("Tamaño total de ficheros del directorio en (bytes): " + mediasize.getSizeTotalFolder() + " bytes");
            
            System.out.println("Tamaño Medio de ficheros del directorio en (bytes): " + mediasize.getCount());

            System.out.println("Numero de lineas: " + reader.getNumLinesFile());

            totalLines += reader.getNumLinesFile();

            System.out.println("Numero de lineas efectivas: " + lineseffectives.getCount());

            totalEffectives += lineseffectives.getCount();

            System.out.println("Numero de lineas totales: " + totalLines);

            System.out.println("Numero total de lineas efectivas: " + totalEffectives);

            percentEffectives = (totalEffectives * 100) / totalLines;

            System.out.println("Porcentaje de lineas efectivas: " + percentEffectives + " %");

            System.out.println("Numero de metodos y constructores: " + numMethods.getCount());

            if (numMethods.getCount() > 0) {
                if (medialinesmethods.getCount() > 4) {
                    System.out.println("Media de lineas de codigo efectivas de metodos y constructores: " + medialinesmethods.getCount() + " <=====");
                } else {
                    System.out.println("Media de lineas de codigo efectivas de metodos y constructores: " + medialinesmethods.getCount());
                }
            }
            
            HashMap hm = numMethods.getArrayInfo(reader);

            Set set = hm.entrySet();
            Iterator i = set.iterator();
            System.out.println("Numero de lineas efectivas de los metodos por separado: ");
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
