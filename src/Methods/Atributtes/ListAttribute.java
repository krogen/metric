package Methods.Atributtes;

import Package.Entities.Semaphore;
import Package.Entities.StringOperator;
import Package.Utils.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListAttribute {
    private Util util = new Util();
    private BufferedReader br;
    private String line;
    private Semaphore semaphoreofattribute;
    private StringOperator op;
    private PreferencAttribute preferencAttribute = new PreferencAttribute();
             
     public ListAttribute(){
       this.op = new StringOperator();
     }
  
    public ArrayList<String> getAttribute(String file) throws IOException {
        runfile(file);
        return preferencAttribute.ListAttribute();
    }
    
    public void runfile(String file) throws IOException{
        br = util.getBufferTextLines(file);
        semaphoreofattribute = new Semaphore();
        while ((line = br.readLine()) != null) { searchListAttribute(); }
    }
    
     public void searchListAttribute(){
         if (op.isFunction(line)) {preferencAttribute.insertMethods(true);}
         else if(preferencAttribute.OnMethods() == false && !line.contains("class")) studyLine();
         operatorSemaphore();
     } 
     
     public void operatorSemaphore(){
         semaphoreofattribute.getBracesLines(line);
         semaphoreofattribute.addListStringMethodsAndNumLines(line);
         if(semaphoreofattribute.StatusBraces()==0 && preferencAttribute.OnMethods() == true) preferencAttribute.insertMethods(false);
     }
     
     public void studyLine(){
        String palabraReservada = op.identificarpalabrareservada(line); 
        if(palabraReservada.length()>1){ CogerAtributo(palabraReservada); }
     }
    
     public void CogerAtributo(String palabraReservada){
         String aux= line;
         aux = aux.substring(aux.indexOf(palabraReservada)+palabraReservada.length(),aux.length());
         while(aux.length() != 0){
             if(aux.indexOf(" ")==0)aux = aux.substring(1,aux.length());
             else{
                 cogerNameString(aux.substring(aux.indexOf(" ")+1, aux.length()));
                 break;
             } 
         }       
     }
     
     public void cogerNameString(String aux){
         while(aux.length() != 0){
             if(aux.indexOf(" ")==0)aux = aux.substring(1,aux.length());
             else{
                 if(aux.indexOf(",") == -1){
                     preferencAttribute.insertAttributeList(aux.substring(0, aux.indexOf(";")));
                     break;
                 }
                 else{
                     preferencAttribute.insertAttributeList(aux.substring(0, aux.indexOf(",")));
                     aux = aux.substring(aux.indexOf(",")+1,aux.length());
                 }
             } 
         }       
     }  
}
