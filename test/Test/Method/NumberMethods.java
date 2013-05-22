package Test.Method;

import Methods.Methods.Methods;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberMethods {
    
    public NumberMethods() {
    }
    
    @Test
    public void NumberMethods() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Methods nummethods = new Methods(reader);
        assertEquals(nummethods.getCount(), 11);
    }
}
