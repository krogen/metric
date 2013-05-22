package Test.Import;

import Class.Afference.NumberOfImports;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberImports {
    
    public NumberImports() {
    }
    
    @Test
    public void totalNumberClass() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        NumberOfImports numOfImports = new NumberOfImports(reader);
        assertEquals(numOfImports.getCount(), 8);
    }
    
}
