package yeray;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Parser {

    public static void main(String[] args) throws IOException {

        MediaLinesMethods medialinesmethods = null;

        ReaderFile reader = new ReaderFile("/Users/gloriav/NetBeansProjects/metric/src/yeray/FilesFolders.java");

        File folder = new File("/Users/gloriav/NetBeansProjects/metric/src/");

        FilesFolders numfiles = new FilesFolders(folder);

        Classes numclasses = new Classes(reader);

        Packages packages = new Packages(new File("/Users/gloriav/NetBeansProjects/metric/src"));

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

            System.out.println("Tamaño Medio de ficheros del directorio en (bytes): " + mediasize.getCount());

            System.out.println("Numero de lineas: " + reader.getNumLinesFile());

            System.out.println("Numero de lineas efectivas: " + lineseffectives.getCount());

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

        Metric composite = new Composite();
        Metric clases = new Classes(reader);
        Metric methods = new Methods(reader);
        composite.add(clases);
        composite.add(methods);

        System.out.println(composite.getChild(0).getCount());
        System.out.println(composite.getChild(1).getCount());
    }
}
