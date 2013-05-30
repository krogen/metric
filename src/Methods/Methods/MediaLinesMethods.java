package Methods.Methods;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MediaLinesMethods implements Metric {

    private int num = 0;
    private Methods methods;
    private Methods numMethods;

    public MediaLinesMethods(ReaderFile readerfile) throws FileNotFoundException, IOException {
        methods = new Methods(readerfile);
        numMethods = new Methods(readerfile);
        count(readerfile);
    }

    private int getCalculateMediaLinesMethods(HashMap mapinfo) {
        num = 0;
        Set set = mapinfo.entrySet();
        Iterator i = set.iterator();
        getMediaLines(i);
        return (num / numMethods.getCount());
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        num = getCalculateMediaLinesMethods(methods.getArrayInfo(readerfile));
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        return methods.getArrayInfo(readerfile);
    }

    private void getMediaLines(Iterator i) {
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            num += (int) me.getValue();
        }
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
