package Methods.Atributtes;

import java.util.ArrayList;

public class PreferencAttribute {
     private String line;
     private boolean onMethods = false;
     private ArrayList<String> listResulAttribute = new ArrayList<>();
     
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
