package Class;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import Package.Utils.FilesUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Classes implements Metric {

    private FilesUtils fileutil = new FilesUtils();
    private int num = 0;

    public Classes(ReaderMethod reader) {
        count(reader);
    }

    public Classes(ReaderFile reader) {
        count(reader);
    }
    
    private int getClass(ReaderMethod readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, "class");
    }

    private int getClass(ReaderFile readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, "class ");
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = getClass(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            num = getClass(readermethod);
        } catch (IOException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
