package yeray;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LinesEffectives implements Metric {

    private int num = 0;
    private ReaderFile readerfile;
    
    public LinesEffectives(ReaderFile readerfile) throws IOException{
        this.readerfile = readerfile;
        num = numLinesEffectives(readerfile);
    }

    public int numLinesEffectives(ReaderFile readerfile) throws IOException {
        getEffectiveLine(readerfile);
        return num;
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = numLinesEffectives(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(LinesEffectives.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        return null;
    }

    private void getEffectiveLine(ReaderFile readerfile) throws IOException {
        for (String line : readerfile.getArrayDataLines()) {
            if (!line.trim().equals("")) {
                num++;
            }
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
}
