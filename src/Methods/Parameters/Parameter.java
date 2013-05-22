package Methods.Parameters;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parameter implements Metric{
    
    private HashMap hm;
    
    private checkParameter checkParameter = new checkParameter();
    
    public Parameter(ReaderFile readerfile){
        count(readerfile);
    }

    @Override
    public int getCount() {
        int totalNumParameters = 0;
        if (hm != null) {
            Iterator it = hm.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                totalNumParameters += Integer.parseInt(e.getValue().toString());
            }
            return totalNumParameters;
        }else{ return 0;} 
    }

    @Override
    public void count(ReaderFile readerfile) {
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        try {
            return hm = checkParameter.getListMethodsAndParams(readerfile);
        } catch (IOException ex) {
            Logger.getLogger(Parameter.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
