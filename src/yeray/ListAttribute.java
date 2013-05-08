/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yeray;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class ListAttribute {

    private Util util = new Util();
    private BufferedReader br;
    private String line;
    private String file;
    private boolean onClass = false;
    private boolean onMethods = false;
    private Semaphore semaphoreofattribute;
    private ArrayList<String> prueba;
    private StringOperator op;

    public ListAttribute() {
        this.prueba = new ArrayList<>();
        this.op = new StringOperator();
    }

    public boolean isFunction() {
        return (line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(op.getNameConstructs(file))) ? true : false;
    }

    public boolean isClass() {
        return onClass;
    }

    public ArrayList<String> getAttribute(String file) throws IOException {
        br = util.getBufferTextLines(file);
        prueba.add("Clase" + " " + op.getNameConstructs(file));
        semaphoreofattribute = new Semaphore();
        while ((line = br.readLine()) != null) {
            if (line.contains("class")) {
                onClass = true;
            }
            searchListAttribute2();
        }
        System.out.println(prueba.size() - 1);
        return prueba;
    }

    public void searchListAttribute2() {//bien
        if (isFunction()) {
            onMethods = true;
        } else if (onMethods == false && onClass && !line.contains("class")) {
            studyLine();
        }
        operatorSemaphore();
    }

    public void operatorSemaphore() { // bien
        semaphoreofattribute.getBracesLines(line);
        semaphoreofattribute.addListStringMethodsAndNumLines(line);
        if (semaphoreofattribute.StatusBraces() == 0 && onMethods == true) {
            onMethods = false;
        }
    }
    /*
     public boolean isFunction(String line) {
     return (!isConditionType(line) && line.contains("{") && line.contains("(")) ? true : false;
     }
     */

    public void studyLine() {// bien
        String palabraReservada = op.identificarpalabrareservada(line);
        if (palabraReservada.length() > 1) {
            CogerAtributo(palabraReservada);
        }
    }

    public void CogerAtributo(String palabraReservada) { // se queda en este fichero por ahora
        String aux = line;
        aux = aux.substring(aux.indexOf(palabraReservada) + palabraReservada.length(), aux.length());
        while (aux.length() != 0) {
            if (aux.indexOf(" ") == 0) {
                aux = aux.substring(1, aux.length());
            } else {
                cogerNameString(aux.substring(aux.indexOf(" ") + 1, aux.length()), aux.substring(0, aux.indexOf(" ")));
                break;
            }
        }
    }

    public void cogerNameString(String aux, String tipo) {
        while (aux.length() != 0) {
            if (aux.indexOf(" ") == 0) {
                aux = aux.substring(1, aux.length());
            } else {
                //prueba.add(tipo + " " + aux.substring(0, aux.indexOf(";")));
                prueba.add(aux.substring(0, aux.indexOf(";")));
                break;
            }
        }
    }
}
