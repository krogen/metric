/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Atributtes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import Entities.Semaphore;
import Entities.StringOperator;
import Utils.Util;

/**
 *
 * @author Daniel
 */
public class NumberAttributeformethods {
     private Util util = new Util();
     private BufferedReader br;
     private String line;
     private String file;
     private boolean onClass = false;
     private boolean onMethods = false;
     private Semaphore semaphoreofattribute;
     private ArrayList<Integer> prueba;
     private ArrayList<String> listattribute;
     private ArrayList<String> lista;
     private StringOperator op;
     private int cont = 0;
     
    
    public NumberAttributeformethods(ArrayList<String> list){
        prueba = new ArrayList<>();
        listattribute = new ArrayList<>();
        listattribute = list;
        this.op = new StringOperator();
    }
    
    
    public ArrayList<Integer> getAttribute(String file) throws IOException{
        br = util.getBufferTextLines(file);
        semaphoreofattribute = new Semaphore();
        while ((line = br.readLine()) != null) {
            if(line.contains("class")) onClass = true;
            searchListAttribute();
        }
        return prueba;
    }
    
    public void searchListAttribute(){
         if(isFunction() && !line.contains("main"))inicializeattributemethods();
         if(onMethods == true)operatorSemaphore();
         
     }
    
    public void inicializeattributemethods(){
        onMethods = true;
        Copylist();
        cont = 0;
    }
    
    public void Copylist(){
        lista =  (ArrayList<String>)listattribute.clone();
    }
    
    public void operatorSemaphore(){
        semaphoreofattribute.getBracesLines(line);
        semaphoreofattribute.addListStringMethodsAndNumLines(line);
        if(semaphoreofattribute.StatusBraces()==0 && onMethods == true) contabilizeattributo();
        if(semaphoreofattribute.StatusBraces()>0)studyLine();
    }
    
    public void contabilizeattributo(){
        onMethods = false;
        prueba.add(cont);
        lista.clear();
     }
    
     public void studyLine(){
         if(op.isPatternCondition(line))return;
         else if(isattribute())cont++;
     }
     
     public Boolean isattribute(){
         for (String pattern : lista) {
            if (line.contains(pattern)) {
                lista.remove(pattern);
                return true;
            }
        }
        return false;
     }
     
    public boolean isFunction() {
        return (line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(op.getNameConstructs(file))) ? true : false;
    }
}
