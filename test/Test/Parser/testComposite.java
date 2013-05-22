package Test.Parser;

import Class.Classes;
import Class.Construct.Construct;
import Methods.Atributtes.Attribute;
import Methods.ComplexCyclomatic.Conditions.NumberOfIf;
import Methods.ComplexCyclomatic.Iterator.NumberOfFor;
import Methods.ComplexCyclomatic.Iterator.NumberOfWhile;
import Methods.Lines.Lines;
import Methods.Lines.LinesEffectives;
import Methods.Methods.MediaLinesMethods;
import Methods.Methods.Methods;
import Methods.Parameters.Parameter;
import Package.Entities.Composite;
import Package.Entities.Metric;
import Package.Files.FilesFolders;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import Package.Packages.Packages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class testComposite {
    
    public testComposite() {
    }
    
    @Test
    public void ResultTestComposite() throws FileNotFoundException, IOException{

        Attribute atributes;
        MediaLinesMethods medialinesmethods = null;

        ReaderFile readerfile = new ReaderFile("src/Package/Files/FilesFolders.java");
        ReaderMethod readermethod = new ReaderMethod(readerfile, "");

        File folder = new File("src");

        FilesFolders numfiles = new FilesFolders(folder);

        Classes numclasses = new Classes(readerfile);

        Packages packages = new Packages(new File("src"));

        ArrayList<String> arrayfiles = numfiles.getArrayListFiles();

        for (String path : arrayfiles) {

            System.out.println("-------" + path + "-------");

            readerfile = new ReaderFile(path);

            Metric composite = new Composite();

            Metric clases = new Classes(readerfile);
            Metric methods = new Methods(readerfile);
            Metric lineseffectives = new LinesEffectives(readerfile);
            Metric lines = new Lines(readerfile);
            atributes = new Attribute(readerfile);
            Metric construct = new Construct(readerfile);
            Metric parameters = new Parameter(readerfile);
            parameters.getArrayInfo(readerfile);
            Metric numfor = new NumberOfFor(readermethod);
            Metric numif = new NumberOfIf(readermethod);
            Metric numwhile = new NumberOfWhile(readermethod);

            composite.add(clases);
            composite.add(methods);
            composite.add(lines);
            composite.add(lineseffectives);
            composite.add(construct);
            composite.add(parameters);
            composite.add(numfor);
            composite.add(numif);
            composite.add(numwhile);

            int i = 0;
            while (i < 9) {
                System.out.println(composite.getChild(i).getCount());
                i++;
            }
            //System.out.println(atributes.NumberAttributeGlobal());
            System.out.println("------------------------------------------------------------");
        }
    
    }
}
