package Package.Utils;

import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.IOException;
import java.util.ArrayList;

public class FilesUtils {

    private int num;
    private  boolean IsTheSymbol = false;
    private ArrayList<String> list = new ArrayList();

    public FilesUtils() {
    }

    public int getFilePattern(ReaderMethod reader, String pattern) throws IOException {
        for (String line : reader.getLinesOfMethod()) {
            IsTheSymbol = isInitialBlockComment(line, IsTheSymbol);
            sumarizePatterns(line, pattern, IsTheSymbol);
            isFinalBlockComment(line, IsTheSymbol);
        }
        return num;
    }

    public int getFilePattern(ReaderFile reader, String pattern) throws IOException {
        for (String line : reader.getArrayDataLines()) {
            IsTheSymbol = isInitialBlockComment(line, IsTheSymbol);
            sumarizePatterns(line, pattern, IsTheSymbol);
            isFinalBlockComment(line, IsTheSymbol);
        }
        return num;
    }
    
    public int getFilePatternEfference(ReaderFile reader, String pattern) throws IOException {
        for (String line : reader.getArrayDataLines()) {
            IsTheSymbol = isInitialBlockComment(line, IsTheSymbol);
            sumarizePatternsEfference(line, pattern, IsTheSymbol);
            isFinalBlockComment(line, IsTheSymbol);
        }
        return num;
    }

    private boolean isInitialBlockComment(String line, boolean IsTheSymbol) {
        if(line.contains("//") || line.contains("/*")) {
            IsTheSymbol = true;
        }
        return IsTheSymbol;
    }

    private void isFinalBlockComment(String line, boolean IsTheSymbol) {
        if(line.contains("//") || line.contains("*/") && IsTheSymbol == true) {
            this.IsTheSymbol = false;
        }
    }

    private void sumarizePatterns(String line, String pattern, boolean IsTheSymbol) {
        if (line.contains(pattern) && (!line.contains("return")) && (!line.contains("<?")) && IsTheSymbol == false) {
            num++;
        }else if(pattern.equals("//") && line.contains("//")){
            num++;
        }
    }
    
    private void sumarizePatternsEfference(String line, String pattern, boolean IsTheSymbol) {
        if (line.contains("import ") && (!line.contains(pattern)) && (!line.contains("java.")) 
                && (!line.contains("org.")) && (!line.contains("junit.")) && IsTheSymbol == false) {
            calculatePackageEfferences(line);   
            num++;
        }
    }
    
    private void calculatePackageEfferences(String line){
        int fini=0;
        for(int i=0; i < line.length(); i++){
            if(line.charAt(i) =='.'){
                fini=i;
            }
        }
        addListPackages(line, fini);  
    }

    private void addListPackages(String line, int fini) {
        if(list.isEmpty()){
            list.add(line.substring(0, fini));
        }else if(!list.contains(line.substring(0, fini))){
                list.add(line.substring(0, fini));
        }
    }
    
    public int getEfferencePackage(){
        return list.size();
    }
}
