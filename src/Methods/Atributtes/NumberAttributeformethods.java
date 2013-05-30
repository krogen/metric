package Methods.Atributtes;

import Package.Entities.Semaphore;
import Package.Entities.StringOperator;
import Package.Utils.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumberAttributeformethods {
     private Util util = new Util();
     private BufferedReader br;
     private String line;
     private Semaphore semaphoreofattribute;
     private ArrayList<Integer> prueba;
     private ArrayList<String> listattribute;
     private ArrayList<String> lista;
     private StringOperator op;
     private int cont = 0;
     private PreferencAttribute preferencAttribute = new PreferencAttribute();
     
    
    public NumberAttributeformethods(ArrayList<String> list){
        this.prueba = new ArrayList<>();
        listattribute = new ArrayList<>();
        listattribute = list;
        this.op = new StringOperator();
    }
    
    public ArrayList<Integer> getAttribute(String file) throws IOException{
        runfile(file);
        return prueba;
    }
    
    public void runfile(String file) throws IOException{
        br = util.getBufferTextLines(file);
        semaphoreofattribute = new Semaphore();
        while ((line = br.readLine()) != null) { searchListAttribute(); }
    }
    
    public void searchListAttribute(){
         if(op.isFunction(line) && !line.contains("main"))inicializeattributemethods();
         if(preferencAttribute.OnMethods() == true)operatorSemaphore();
         
     }
    
    public void inicializeattributemethods(){
        preferencAttribute.insertMethods(true);
        Copylist();
        cont = 0;
    }
    
    public void Copylist(){
        lista =  (ArrayList<String>)listattribute.clone();
    }
    
    public void operatorSemaphore(){
        semaphoreofattribute.getBracesLines(line);
        semaphoreofattribute.addListStringMethodsAndNumLines(line);
        if(semaphoreofattribute.StatusBraces()==0 && preferencAttribute.OnMethods() == true) contabilizeattributo();
        if(semaphoreofattribute.StatusBraces()>0)studyLine();
    }
    
    public void contabilizeattributo(){
        preferencAttribute.insertMethods(false);
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
}
