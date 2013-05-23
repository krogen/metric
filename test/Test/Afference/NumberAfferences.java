package Test.Afference;

import Class.Afference.AfferenceCoupling;
import Package.Files.FilesFolders;
import Package.Files.ReaderFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberAfferences {
    
    public NumberAfferences() {
    }
    
    @Test
    public void NumberAfferences() throws FileNotFoundException, IOException{
        File folder = new File("src/");
        FilesFolders numfiles = new FilesFolders(folder);
        ArrayList<String> arrayfiles = numfiles.getArrayListFiles();
        ReaderFile reader = new ReaderFile("src/Class/Afference/AfferenceCoupling.java");
        AfferenceCoupling numAfferences = new AfferenceCoupling(arrayfiles, reader);
        assertEquals(numAfferences.getCount(), 1);
    }
    
    @Test
    public void NumberAfferences2() throws FileNotFoundException, IOException{
        File folder = new File("src/");
        FilesFolders numfiles = new FilesFolders(folder);
        ArrayList<String> arrayfiles = numfiles.getArrayListFiles();
        ReaderFile reader = new ReaderFile("src/Package/Utils/FilesUtils.java");
        AfferenceCoupling numAfferences = new AfferenceCoupling(arrayfiles, reader);
        assertEquals(numAfferences.getCount(), 18);
    }
}
