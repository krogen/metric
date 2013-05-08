package Lines;

import java.util.HashMap;
import Entities.Metric;
import Files.ReaderFile;

public final class Lines implements Metric {

    private int num = 0;
    private ReaderFile reader;
    
    public Lines(ReaderFile readerfile){
        this.reader = readerfile;
        count(readerfile);
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        num = readerfile.getNumLinesFile();
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


}
