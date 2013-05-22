package Methods.Atributtes;

import Package.Entities.Semaphore;
import Package.Utils.Util;
import java.io.BufferedReader;
import java.util.ArrayList;

public class PreferencAttribute {
     private Util util = new Util();
     private BufferedReader br;
     private String line;
     private boolean onMethods = false;
     private Semaphore semaphoreofattribute = new Semaphore();;
     private ArrayList<String> listResulAttribute = new ArrayList<>();;
     
     public PreferencAttribute(){ 
     }
     
     public void insertAttributeList(String attribute){
         listResulAttribute.add(attribute);
     }
     
      public ArrayList<String> ListAttribute(){
          return listResulAttribute;
      }
     
     public void insertLine(String line){
         this.line = line;
     }
    
     public String readline(){
         return this.line;
     }
     
     public void insertMethods(boolean status){
         this.onMethods = status;
     }
     
     public boolean OnMethods(){
         return this.onMethods;
     }
}
