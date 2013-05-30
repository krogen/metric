package Methods.ComplexCyclomatic.Conditions;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import Package.Utils.FilesUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class NumberOfIf implements Metric {

    private FilesUtils fileutil = new FilesUtils();
    private int num = 0;

    public NumberOfIf(ReaderMethod readerfile) {
        count(readerfile);
    }

    private int getIfs(ReaderMethod readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, "if");
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
            num = getIfs(readermethod);
        } catch (IOException ex) {
            Logger.getLogger(NumberOfIf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
