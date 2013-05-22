package Test.Lines;

import Methods.Lines.Lines;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberLines {
    
    public NumberLines(){
    }
    
    @Test
    public void NumberLines() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Lines numlines = new Lines(reader);
        assertEquals(numlines.getCount(), 75);
    }
    
}
