package Test.Package;

import Package.Packages.Packages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberPackages {
    
    public NumberPackages() {
    }
    
    @Test
    public void totalNumberPackagesSRC() throws FileNotFoundException, IOException{
        File folder = new File("src");
        Packages numPackages = new Packages(folder);
        assertEquals(numPackages.getCount(), 18);
    }
    
    @Test
    public void NumberPackagesClass() throws FileNotFoundException, IOException{
        File folder = new File("src/Class");
        Packages numPackages = new Packages(folder);
        assertEquals(numPackages.getCount(), 3);
    }
    
    @Test
    public void NumberPackagesMethods() throws FileNotFoundException, IOException{
        File folder = new File("src/Methods");
        Packages numPackages = new Packages(folder);
        assertEquals(numPackages.getCount(), 9);
    }
    
    @Test
    public void totalNumberPackagesTest() throws FileNotFoundException, IOException{
        File folder = new File("test");
        Packages numPackages = new Packages(folder);
        assertEquals(numPackages.getCount(), 12);
    }
}
