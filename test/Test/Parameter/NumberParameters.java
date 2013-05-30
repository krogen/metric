package Test.Parameter;

import Methods.Methods.Methods;
import Methods.Parameters.Parameter;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberParameters {
    
    public NumberParameters() {
    }
    
    @Test
    public void totalNumberParameter() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Parameter numparameters = new Parameter(reader);
        numparameters.getArrayInfo(reader);
        assertEquals(numparameters.getCount(), 10);
    }
       
    @Test
    public void NumberParameterByMethod() throws FileNotFoundException, IOException{
        HashMap hm;
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Parameter numparameters = new Parameter(reader);
        hm = numparameters.getArrayInfo(reader);
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            if(e.getKey().toString().contains("getClass(ReaderMethod readerfile)")){
                assertEquals(e.getValue(), 1);
            }
            if(e.getKey().toString().contains("getCount()")){
                assertEquals(e.getValue(), 0);
            }
        }
    }
    
    @Test
    public void NumberLinesByMethod() throws FileNotFoundException, IOException{
        HashMap hm;
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Methods method = new Methods(reader);
        hm = method.getArrayInfo(reader);
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            if(e.getKey().toString().contains("getClass(ReaderMethod readerfile)")){
                assertEquals(e.getValue(), 1);
            }
            if(e.getKey().toString().contains("count(ReaderFile readerfile)")){
                assertEquals(e.getValue(), 5);
            }
        }
    }
    
}
