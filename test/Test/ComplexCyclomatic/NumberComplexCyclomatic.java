package Test.ComplexCyclomatic;

import Methods.ComplexCyclomatic.ComplexCyclomatic;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberComplexCyclomatic {
    
    public NumberComplexCyclomatic() {
    }
    
    @Test
    public void NumberComplexCyclomatic() throws FileNotFoundException, IOException{
        HashMap hm;
        ReaderFile reader = new ReaderFile("src/Class/Afference/AfferenceCoupling.java");
        ComplexCyclomatic complexcyclomatic = new ComplexCyclomatic();        
        hm = complexcyclomatic.getListMethodsCyclomaticComplex(reader);
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            if(e.getKey().toString().contains("isImport(String line, int num)")){
                assertEquals(e.getValue(), 2);
            }
        }
    }
    
    @Test
    public void NumberComplexCyclomatic2() throws FileNotFoundException, IOException{
        HashMap hm;
        ReaderFile reader = new ReaderFile("src/Methods/ComplexCyclomatic/Conditions/NumberOfAnd.java");
        ComplexCyclomatic complexcyclomatic = new ComplexCyclomatic();        
        hm = complexcyclomatic.getListMethodsCyclomaticComplex(reader);
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            if(e.getKey().toString().contains("getCount()")){
                assertEquals(e.getValue(), 0);
            }
        }
    }
}
