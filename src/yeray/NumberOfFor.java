package yeray;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eugenio
 */
public class NumberOfFor implements Metric {

    private FilesUtils fileutil = new FilesUtils();
    private int num = 0;

    public NumberOfFor(ReaderFile readerfile) {
        count(readerfile);
    }

    private int getFors(ReaderFile readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, "for");
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = getFors(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(NumberOfFor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
