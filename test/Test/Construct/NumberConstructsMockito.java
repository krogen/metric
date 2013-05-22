package Test.Construct;

import Class.Construct.Construct;
import java.io.FileNotFoundException;
import java.io.IOException;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class NumberConstructsMockito {
    
    public NumberConstructsMockito() {
    }
    
    @Test
    public void constructMockTest() throws FileNotFoundException, IOException {
        Construct numConstructs = Mockito.mock(Construct.class);
        Mockito.when(numConstructs.getCount()).thenReturn(new Integer(2));
        Assert.assertEquals(2, numConstructs.getCount());
    }
    
}
