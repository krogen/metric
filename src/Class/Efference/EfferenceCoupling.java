package Class.Efference;

import Methods.ComplexCyclomatic.Iterator.NumberOfFor;
import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import Package.Utils.FilesUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EfferenceCoupling implements Metric {

    private FilesUtils fileutil = new FilesUtils();
    private int num = 0;

    public EfferenceCoupling(ReaderMethod reader) {
        count(reader);
    }

    public EfferenceCoupling(ReaderFile readerfile) {
        count(readerfile);
    }

    private int getImports(ReaderMethod readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, "import Package.");
    }

    private int getImports(ReaderFile readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, "import Package.");
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = getImports(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(NumberOfFor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        try {
            num = getImports(readermethod);
        } catch (IOException ex) {
            Logger.getLogger(NumberOfFor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
