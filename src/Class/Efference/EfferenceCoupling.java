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

public final class EfferenceCoupling implements Metric {

    private ReaderFile readerfile;
    private FilesUtils fileutil = new FilesUtils();
    private int num = 0, numPackageEfferences;

    public EfferenceCoupling(ReaderMethod reader) {
        count(reader);
    }

    public EfferenceCoupling(ReaderFile readerfile) {
        this.readerfile = readerfile;
        count(readerfile);
    }

    private int getImports(ReaderMethod readerfile) throws IOException {
        return fileutil.getFilePattern(readerfile, "import");
    }

    private int getImports(ReaderFile readerfile) throws IOException { 
        String namepackage = getPackage(this.readerfile.getPath());
        int numEfferences = fileutil.getFilePatternEfference(readerfile, namepackage.replaceFirst("/", "."));
        numPackageEfferences = fileutil.getEfferencePackage();
        return numEfferences;
    }
    
    public int getPackageEfference(){
        return numPackageEfferences;
    }
    
    private String getPackage(String path){
        String namepackage;
        namepackage = limitString(path, 0);
        return namepackage;
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

    private String limitString(String path, int n){
        if(path.contains("\\")){
            String namepackage = path.substring(path.compareTo("src\\")*-1, path.length());
            return namepackage.substring(0, getLimitPathFinal(namepackage, n));
        }else{
            return path.substring(getLimitPathPrinciple(path)+1, getLimitPathFinal(path, n));
        }
    }

    private int getLimitPathPrinciple(String path) {
        for(int i=0; i < path.length(); i++){
            if(path.charAt(i)=='/'){
                return i;
            }
        }
        return 0;
    }
    
    private int getLimitPathFinal(String namepackage, int n) {
        for(int i=0; i < namepackage.length(); i++){
            if((namepackage.charAt(i)=='\\') || (namepackage.charAt(i)=='/')){
                n = i;
            } 
        }
        return n;
    }
}
