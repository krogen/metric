package Test.Lines;

import Methods.Lines.LinesEffectives;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberLinesEffectives {
    
    public NumberLinesEffectives() {
    }
    
    @Test
    public void NumberLinesEffectives() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        LinesEffectives numlineseffectives = new LinesEffectives(reader);
        assertEquals(numlineseffectives.getCount(), 61);
    }
}
