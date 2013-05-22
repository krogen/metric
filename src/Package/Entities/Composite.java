package Package.Entities;

import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Composite implements Metric {

    private List<Metric> listMetrics = new ArrayList();
    private int i;

    @Override
    public void add(Metric d) {
        listMetrics.add(d);
    }

    @Override
    public void remove(Metric d) {
        listMetrics.remove(d);
    }

    @Override
    public Metric getChild(int i) {
        this.i = i;
        if (i < listMetrics.size()) {
            return listMetrics.get(i);
        }
        return null;
    }

    @Override
    public int getCount() {
        return this.getChild(this.i).getCount();
    }

    @Override
    public void count(ReaderFile readerfile) {
        //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void count(ReaderMethod readermethod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
