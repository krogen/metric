package Test.Efference;

import Class.Efference.EfferenceCoupling;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberEfferences {
    
    public NumberEfferences(){}
    
    @Test
    public void NumberEfferences() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Efference/EfferenceCoupling.java");
        EfferenceCoupling numEfferences = new EfferenceCoupling(reader);
        assertEquals(numEfferences.getCount(), 4);
    }
    
    @Test
    public void NumberEfferences2() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Package/Utils/FilesUtils.java");
        EfferenceCoupling numEfferences = new EfferenceCoupling(reader);
        assertEquals(numEfferences.getCount(), 2);
    }
}
