package Class.Construct;

import Package.Files.ReaderFile;
import java.io.IOException;

public class checkConstruct {
    private int num = 0;
    
    public checkConstruct(){}
    
    public int getConstruct(ReaderFile readerfile, String path) throws IOException {
        for (String line : readerfile.getArrayDataLines()) {
            if(line.contains(" " + path.concat("(")) && (!line.contains("//")) && (!line.contains("/*")) && (!line.contains("*/"))) {
                num++;
            }
        }
        return num;
    }   
}
