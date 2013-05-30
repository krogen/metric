package Methods.Methods;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.util.HashMap;

public final class MethodsLines implements Metric {

    private int num = 0;
    
    public MethodsLines(ReaderFile reader){
        count(reader);
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

    @Override
    public void count(ReaderMethod readermethod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
