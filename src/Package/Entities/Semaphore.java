package Package.Entities;

public class Semaphore {
    
    private int braces = 0;
    private StringOperator stringoperator;
    
    public Semaphore(){
        stringoperator = new StringOperator();
    }
    
    public void getBracesLines(String line) {
        if (stringoperator.isConditionType(line) && line.contains("{")) braces++;    
    }
    
    public void addListStringMethodsAndNumLines(String line) {
        if (line.contains("}")) braces--;  
    }
    
    public int StatusBraces(){
       return this.braces;
    }  
}
