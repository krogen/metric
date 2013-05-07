/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yeray;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class PreferencAttribute {
     private Util util = new Util();
     private BufferedReader br;
     private String line;
     private String file;
     private boolean onClass = false;
     private boolean onMethods = false;
     private Semaphore semaphoreofattribute;
     private ArrayList<String> prueba;
     private String[] patterns = {"public", "private", "protected"};
    
}
