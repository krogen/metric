package Methods.ComplexCyclomatic.Selection;

import Methods.ComplexCyclomatic.Iterator.NumberOfFor;
import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import Package.Utils.FilesUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class NumberOfContinue implements Metric {

    private FilesUtils fileutil = new FilesUtils();
    private int num = 0;

    public NumberOfContinue(ReaderMethod readerfile) {
        count(readerfile);
    }

    private int getContinues(ReaderMethod readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, " continue");
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
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
            num = getContinues(readermethod);
        } catch (IOException ex) {
            Logger.getLogger(NumberOfFor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

