/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods.Atributtes;

import Package.Utils.Util;
import Package.Entities.StringOperator;
import Package.Entities.Semaphore;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import Package.Files.ReaderFile;

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

    public ListAttribute(String file) {
        this.prueba = new ArrayList<>();
        this.op = new StringOperator();
        this.file = file;
    }

    public boolean isFunction() {
        return (line.contains("void") || line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains(op.getNameConstructs(file))) ? true : false;
    }

    public boolean isClass() {
        return onClass;
    }

    public ArrayList<String> getAttribute(ReaderFile readerfile) throws IOException {
        br = util.getBufferTextLines(readerfile.getPath());
        prueba.add("Clase" + " " + op.getNameConstructs(readerfile.getPath()));

        semaphoreofattribute = new Semaphore();
           while ((line = br.readLine()) != null) {

            System.out.println(line);
            if (line.contains("class")) {
                onClass = true;
            }
            searchListAttribute2();
        }
       // System.out.println(prueba.size() - 1);
        onMethods = false;
        onClass = false;
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
