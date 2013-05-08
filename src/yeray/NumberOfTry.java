package yeray;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eugenio
 */
public class NumberOfTry implements Metric {
    
    private FilesUtils fileutil = new FilesUtils();
    private int num = 0;

    public NumberOfTry(ReaderFile readerfile) {
        count(readerfile);
    }

    private int getTrys(ReaderFile readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile,"try");
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = getTrys(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(NumberOfTry.class.getName()).log(Level.SEVERE, null, ex);
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
