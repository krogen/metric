package Test.Class;

import Class.Classes;
import Package.Files.FilesFolders;
import Package.Files.ReaderFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberClass {
    
    public NumberClass() {
    }
    
    @Test
    public void totalNumberClass() throws FileNotFoundException, IOException{
        File folder = new File("src");
        FilesFolders numClasses = new FilesFolders(folder);
        assertEquals(numClasses.getCount(), 56);
    }
    
    @Test
    public void NumberClassInPackageClass() throws FileNotFoundException, IOException{
        File folder = new File("src/Class");
        FilesFolders numClasses = new FilesFolders(folder);
        assertEquals(numClasses.getCount(), 6);
    }
    
    @Test
    public void NumberClassInPackageClassAfference() throws FileNotFoundException, IOException{
        File folder = new File("src/Class/Afference");
        FilesFolders numClasses = new FilesFolders(folder);
        assertEquals(numClasses.getCount(), 2);
    }
    
    @Test
    public void singleNumberClass() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Afference/AfferenceCoupling.java");
        Classes numClasses = new Classes(reader);
        assertEquals(numClasses.getCount(), 1);
    }
    
    @Test
    public void singleNumberClass2() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Classes numClasses = new Classes(reader);
        assertEquals(numClasses.getCount(), 1);
    }
    
}
