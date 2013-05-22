package Test.Attribute;

import Methods.Atributtes.Attribute;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberAttributes {
    
    public NumberAttributes() {
    }
    
    @Test
    public void totalNumberAttributes() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Attribute numAttributes = new Attribute(reader);
        assertEquals(numAttributes.getCount(), 2);
    }
    
    @Test
    public void NumberAttributesByMethods() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Attribute numAttributes = new Attribute(reader);
        ArrayList<Integer> listNumberAttributes = new ArrayList();
        listNumberAttributes = numAttributes.AttributeForMethodo();
        
        for(int a=0; a<listNumberAttributes.size(); a++){
            System.out.println(listNumberAttributes.get(a));
        }
    }
}
