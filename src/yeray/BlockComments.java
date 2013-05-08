/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yeray;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eugenio
 */
public class BlockComments implements Metric {
    
    //private FilesUtils fileutil = new FilesUtils();
    private int num = 0;

    public BlockComments(ReaderFile readerfile) {
        count(readerfile);
    }
    
    private int getBlockComments(ReaderFile readerfile) throws IOException {
        boolean IsTheSymbol = false;
        for (String line : readerfile.getArrayDataLines()){
            if (line.contains("/*")) IsTheSymbol = true;
            if (line.contains("*/") && IsTheSymbol == true) num++;
        }
        return num;
        
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = getBlockComments(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(BlockComments.class.getName()).log(Level.SEVERE, null, ex);
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
