package Package.Files;

import Methods.Methods.MethodHash;
import Methods.Methods.MethodsFeatury;
import Package.Entities.Semaphore;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderMethod {

    private ReaderFile reader;
    private String nameMethod;
    private Semaphore semaphore;
    private MethodHash methodhash;
    private MethodsFeatury method;
    private Boolean copy;

    public ReaderMethod(ReaderFile reader, String nameMethod) throws FileNotFoundException, IOException {
        this.reader = reader;
        this.nameMethod = nameMethod;
        this.methodhash = new MethodHash(reader);
        this.semaphore = new Semaphore();
        this.copy = false;
        this.method = new MethodsFeatury();
    }

    public ArrayList<String> getLinesOfMethod() throws IOException {
        ArrayList<String> arrayListLinesMethod = new ArrayList<String>();
        readBlockMethod(arrayListLinesMethod);
        return arrayListLinesMethod;
    }

    private void isMethodEquals(String line) {
        if (this.nameMethod.equals(methodhash.getNameMethod(line))) {
            copy = true;
        }
    }

    private void addList(ArrayList<String> arrayListLinesMethod, String line) {
        if (copy == true) {
            arrayListLinesMethod.add(line);
        }
    }

    private void isNotMethodEqual(String line) {
        if(method.isFunction(line) && !this.nameMethod.equals(methodhash.getNameMethod(line))){
            copy = false;
        }
    }

    private void readBlockMethod(ArrayList<String> arrayListLinesMethod) throws IOException {
        for (String line : this.reader.getArrayDataLines()) {
            isMethodEquals(line);
            addList(arrayListLinesMethod, line);
            isNotMethodEqual(line);
        }
    }
}
