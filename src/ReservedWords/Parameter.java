package ReservedWords;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entities.Metric;
import Files.ReaderFile;

public final class Parameter implements Metric{
    
    private checkParameter checkParameter = new checkParameter();
    
    public Parameter(ReaderFile readerfile){
        count(readerfile);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void count(ReaderFile readerfile) {
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        try {
            return checkParameter.getListMethodsAndParams(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(Parameter.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
