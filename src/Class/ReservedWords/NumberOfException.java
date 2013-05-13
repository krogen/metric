/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.ReservedWords;

import Package.Utils.FilesUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import Package.Entities.Metric;
import Package.Files.ReaderFile;

/**
 *
 * @author Eugenio
 */
public class NumberOfException implements Metric{
    
    private FilesUtils fileutil = new FilesUtils();
    private int num = 0;

    public NumberOfException(ReaderFile readerfile) {
        count(readerfile);
    }

    private int getExceptions(ReaderFile readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, "exception");
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = getExceptions(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(NumberOfException.class.getName()).log(Level.SEVERE, null, ex);
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