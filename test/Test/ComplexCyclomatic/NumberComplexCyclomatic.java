package Test.ComplexCyclomatic;

import Methods.ComplexCyclomatic.ComplexCyclomatic;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
            System.out.println(e.getKey() + " " + e.getValue());
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
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
    
    /*@Test
    public void NumberComplexCyclomatic3() throws FileNotFoundException, IOException{
        
        System.out.println("-------------");
        HashMap hm;
        ReaderFile reader = new ReaderFile("D:\\JAD\\Docs\\Proyectos\\JAVA\\NetBeans\\PractHPS\\src\\evaluator\\CalculatorSolver.java");
        ComplexCyclomatic complexcyclomatic = new ComplexCyclomatic();        
        hm = complexcyclomatic.getListMethodsCyclomaticComplex(reader);
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }*/
    
}
