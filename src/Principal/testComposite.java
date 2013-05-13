/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Class.ReservedWords.Parameter;
import Class.ReservedWords.Construct;
import Class.ReservedWords.Packages;
import Package.Files.FilesFolders;
import Methods.Lines.LinesEffectives;
import Class.ReservedWords.NumberOfFor;
import Class.ReservedWords.NumberOfIf;
import Class.ReservedWords.NumberOfSwitch;
import Methods.Lines.Lines;
import Package.Entities.Composite;
import Methods.Atributtes.Attribute;
import Methods.Methods.MediaLinesMethods;
import Class.Classes;
import Methods.Methods.Methods;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author yeray
 */
public class testComposite {

    public static void main(String[] args) throws IOException {
        Attribute atributes;
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

            Metric composite = new Composite();

            Metric clases = new Classes(reader);
            Metric methods = new Methods(reader);
            Metric lineseffectives = new LinesEffectives(reader);
            Metric lines = new Lines(reader);
            atributes = new Attribute(path,reader);
            Metric construct = new Construct(reader);
            Metric parameters = new Parameter(reader);
            Metric numfor = new NumberOfFor(reader);
            Metric numif = new NumberOfIf(reader);
            Metric numswitch = new NumberOfSwitch(reader);

            composite.add(clases);
            composite.add(methods);
            composite.add(lines);
            composite.add(lineseffectives);
            composite.add(construct);
            composite.add(parameters);
            composite.add(numfor);
            composite.add(numif);
            composite.add(numswitch);

            int i = 0;
            while (i < 9) {
                System.out.println(composite.getChild(i).getCount());
                i++;
            }
            System.out.println(atributes.NumberAttributeGlobal());
            System.out.println("------------------------------------------------------------");
        }
    }
}
