/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yeray;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Attribute {
     private String path;
     private ArrayList<String> list;
     
     public Attribute(String path){
         this.path = path;
     }
     
     public int NumberAttributeGlobal() throws IOException{
        NumberAttribute NumAttribute = new NumberAttribute();
        AttributeForMethodo();
        return NumAttribute.getAttribute(path);
     }
     
     public void GetListAttribute() throws IOException{
        ListAttribute listattribute = new ListAttribute();
        list = listattribute.getAttribute(path);
     }
     
     public ArrayList<Integer> AttributeForMethodo() throws IOException{
        GetListAttribute();
        NumberAttributeformethods listfor = new NumberAttributeformethods(list);
        return listfor.getAttribute(path);
     }   
}
