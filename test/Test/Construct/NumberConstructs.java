package Test.Construct;

import Class.Construct.Construct;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberConstructs {

    public NumberConstructs() {
    }
    
    @Test
    public void NumberConstruc() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Construct numconstruct = new Construct(reader);
        assertEquals(numconstruct.getCount(), 2);
    }
}
