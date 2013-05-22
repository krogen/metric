package Test.Lines;

import Methods.Comments.BlockComments;
import Methods.Lines.LineComments;
import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberLineComments {
    
    public NumberLineComments() {
    }
    
    @Test
    public void NumberLineComments() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        LineComments numlinescomments = new LineComments(reader);
        assertEquals(numlinescomments.getCount(), 0);
    }
    
    @Test
    public void NumberBlockComments() throws FileNotFoundException, IOException{
        ReaderFile reader = new ReaderFile("src/Class/Classes.java");
        BlockComments numlinescomments = new BlockComments(reader);
        assertEquals(numlinescomments.getCount(), 0);
    }
}
