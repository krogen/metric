
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Atributtes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Entities.Semaphore;
import Entities.StringOperator;
import Utils.Util;

/**
 *
 * @author usuario
 */
public class NumberAttribute {
     private Util util = new Util();
     private BufferedReader br;
     private String line;
     private String file;
     private boolean onClass = false;
     private boolean onMethods = false;
     private Semaphore semaphoreofattribute;
     private ArrayList<String> prueba;
     private String[] patterns = {"public", "private", "protected"};
     private StringOperator op;
     private int NumberAttibute = 0;
             
     public NumberAttribute(){
       this.op = new StringOperator();
     }
     
     public boolean isFunction() {
        return (line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(op.getNameConstructs(file))) ? true : false;
    }
    
     public boolean isClass(){
         return onClass;
     } 
     
     public int getAttribute(String file) throws IOException {
        br = util.getBufferTextLines(file);
        semaphoreofattribute = new Semaphore();
        while ((line = br.readLine()) != null) {
            if(line.contains("class")) onClass = true;
            searchListAttribute2();
        }
        return NumberAttibute;
    }
     
     public void searchListAttribute2(){
         if (isFunction()) { onMethods = true;}
         else if(onMethods == false   && onClass && !line.contains("class")) studyLine();
         operatorSemaphore();
     } 
     
     public void operatorSemaphore(){ 
         semaphoreofattribute.getBracesLines(line);
         semaphoreofattribute.addListStringMethodsAndNumLines(line);
         if(semaphoreofattribute.StatusBraces()==0 && onMethods == true) onMethods = false;
     }
    
     public void studyLine(){
        String palabraReservada = op.identificarpalabrareservada(line); 
        if(palabraReservada.length()>1)NumberAttibute++; 
     }  
}
