package Class.complexcyclomatic;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import java.util.HashMap;

/**
 *
 * @author yeray
 */
public class ComplexCyclomatic implements Metric{
    public ComplexCyclomatic(){
        
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
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void count(ReaderFile readerfile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
