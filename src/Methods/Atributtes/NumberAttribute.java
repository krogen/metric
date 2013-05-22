package Methods.Atributtes;

import Package.Entities.Semaphore;
import Package.Entities.StringOperator;
import Package.Utils.Util;
import java.io.BufferedReader;
import java.io.IOException;

public class NumberAttribute {
     private Util util = new Util();
     private BufferedReader br;
     private String line;
     private Semaphore semaphoreofattribute;
     private StringOperator op;
     private int NumberAttribute = 0;
     private PreferencAttribute preferencAttribute = new PreferencAttribute();
             
     public NumberAttribute(){
       this.op = new StringOperator();
     }
     
     public boolean isFunction(String line) {
        return (op.isConditionType(line) && !line.contains("class") && line.contains("{") &&line.contains("(")) ? true : false;
    }
    
     public int getAttribute(String file) throws IOException{
         runfile(file);
         return NumberAttribute;
     } 
     
     public void runfile(String file) throws IOException {
        br = util.getBufferTextLines(file);
        semaphoreofattribute = new Semaphore();
        while ((line = br.readLine()) != null) {searchListAttribute();}
    }
     
     public void searchListAttribute(){
         if (isFunction(line)) { preferencAttribute.insertMethods(true);}
         else if(preferencAttribute.OnMethods()==false && !line.contains("class")) studyLine();
         operatorSemaphore();
     } 
     
     public void operatorSemaphore(){ 
         semaphoreofattribute.getBracesLines(line);
         semaphoreofattribute.addListStringMethodsAndNumLines(line);
         if(semaphoreofattribute.StatusBraces()==0 && preferencAttribute.OnMethods()==true) preferencAttribute.insertMethods(false);
     }
    
     public void studyLine(){
        String palabraReservada = op.identificarpalabrareservada(line); 
        if(palabraReservada.length()>1) NumberAttribute+=numberAttributeLine(); 
     }
     
     public int numberAttributeLine(){
         int numberattribute = 1;
         while(line.length()>0){
             if(line.indexOf(",")> -1) line = line.substring(line.indexOf(",")+1, line.length());
             else break;
             numberattribute++;
         }
         return numberattribute;
     }
}
