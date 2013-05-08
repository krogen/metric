/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yeray;

import java.io.File;

/**
 *
 * @author Daniel
 */
public class StringOperator {
    private String[] patterns = {"public", "private", "protected"};
    private String line;
    private File f;
    
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
    
    public String getNameConstructs(String filename) {
        f = new File(filename);
        String[] namefile = f.getName().split(".java");
        return namefile[0];
    }
    
    public boolean isFunction(String file) {
        return (line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(getNameConstructs(file))) ? true : false;
    }
    
    
    /*
      public boolean isFunction(String line) {
        return (!isConditionType(line) && line.contains("{") && line.contains("(")) ? true : false;
    }
     */
    /*
     public void studyLine(){
         if(line.contains("private")) CogerAtributo();
     }
     */ 
     /*
     public void CogerAtributo(){
         String aux= line;
         aux = aux.substring(aux.indexOf("private")+8,aux.length());
         while(aux.length() != 0){
             if(aux.indexOf(" ")==0)aux = aux.substring(1,aux.length());
             else{
                 cogerNameString(aux.substring(aux.indexOf(" ")+1, aux.length()),aux.substring(0, aux.indexOf(" ")));
                 break;
             } 
         }
     }
     public void cogerNameString(String aux,String tipo){
         while(aux.length() != 0){
             if(aux.indexOf(" ")==0)aux = aux.substring(1,aux.length());
             else{
                 //prueba.add(tipo + " " + aux.substring(0, aux.indexOf(";")));
                 break;
             } 
         }
         
     }
      */
     public String identificarpalabrareservada(String line){
         for (String pattern : patterns) {
            if (line.contains(pattern)) {
                return pattern;
            }
        }
         return "";
     }     
}
