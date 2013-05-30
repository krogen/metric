package Methods.Methods;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Methods implements Metric {

    private int num = 0;
    private MethodHash methodhash;
    
    public Methods(ReaderFile reader) throws FileNotFoundException, IOException{
        methodhash = new MethodHash(reader);
        count(reader);
    }
    
    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = methodhash.getFunctions(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        try {
            return methodhash.getHashMapMethods(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }
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
