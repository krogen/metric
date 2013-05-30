package Package.Entities;

public class StringOperator {
    
    private String[] patterns = {"public", "private", "protected"};
  
    public boolean isConditionType(String line) {
        return (isPatternCondition(line)) ? true : false;
    }
    
     public boolean isPatternCondition(String line) {
        for (String pattern : patterns) {
            if (line.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
    
     public boolean isFunction(String line) {
        return (isConditionType(line) && !line.contains("class") &&line.contains("{") && line.contains("(")) ? true : false;
    }
     
     public String identificarpalabrareservada(String line){
         for (String pattern : patterns) {
            if (line.contains(pattern)) {
                return pattern;
            }
        }
         return "";
     }     
}
