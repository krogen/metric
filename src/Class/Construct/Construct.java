package Class.Construct;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Construct implements Metric{
    
    private int num = 0;
    private checkConstruct ckConstruct = new checkConstruct();
    
    public Construct(ReaderFile readerfile){
        count(readerfile);
    }
    
    private int getNumConstruct(ReaderFile readerfile) throws IOException{
        String file = readerfile.getPath();
        File f = new File(file);
        String[] namefile = f.getName().split(".java");
        return ckConstruct.getConstruct(readerfile, namefile[0]);
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = getNumConstruct(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(Construct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        return null;
    }

    @Override
    public void add(Metric d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Metric d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Metric getChild(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void count(ReaderMethod readermethod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
