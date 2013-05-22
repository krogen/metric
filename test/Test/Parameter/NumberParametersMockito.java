package Test.Parameter;

import Methods.Parameters.Parameter;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class NumberParametersMockito {
    

    
    public NumberParametersMockito() {
    }
    
    @Test
    public void constructMockTest() throws FileNotFoundException, IOException { 
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        Parameter listParameters = Mockito.mock(Parameter.class);
        Mockito.when(listParameters.getArrayInfo(reader)).thenReturn(new HashMap()); 
        Assert.assertEquals(new HashMap(), listParameters.getArrayInfo(reader));
    }
}
