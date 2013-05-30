package Methods.Methods;

import Package.Files.ReaderFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class MethodHash {

    private String line;
    private int num = 0;
    private ReaderFile readerFile;
    private MethodsFeatury methods = new MethodsFeatury();
    private MethodsName methodsname = new MethodsName();
    private int iterator = 0;

    public MethodHash(ReaderFile reader) throws FileNotFoundException, IOException {
        readerFile = reader;
    }

    private void getListMethodAndNumCodeLines(String method, int braces, HashMap listMethodsAndLines) throws IOException {
        iterator = 0;
        while (iterator < readerFile.getNumLinesFile()) {
            line = readerFile.getLineWithPosition(iterator);
            if (methods.isFunction(line)) {
                method = line;
                num = 0;
                braces = 0;
            }
            braces = getBracesLines(braces);
            braces = addListStringMethodsAndNumLines(braces, listMethodsAndLines, method);
            num++;
            iterator++;
        }
    }

    private int addListStringMethodsAndNumLines(int braces, HashMap listMethodsAndLines, String method) {
        if (line.contains("}")) {
            if (braces == 0) {
                insertMethodHashmap(listMethodsAndLines, method);
            }
            braces--;
        }
        return braces;
    }

    public String getNameMethod(String line) {
        String name = "";
        boolean flag = false;
        name = getName(line, name, flag);
        return methods.reverseString(name);
    }

    private String getName(String line, String name, boolean flag) {
        if (methods.isFunction(line)) {
            name = methodsname.getNameMethodsLines(line, flag, name);
        }
        return name;
    }

    public HashMap getHashMapMethods(ReaderFile readerfile) throws IOException {
        num = 0;
        String method = "";
        HashMap listMethodsAndLines = getMethodList(method);
        return listMethodsAndLines;
    }

    public HashMap getMethodList(String method) throws IOException {
        int braces = 0;
        HashMap listMethodsAndLines = new HashMap();
        getListMethodAndNumCodeLines(method, braces, listMethodsAndLines);
        return listMethodsAndLines;
    }

    public int getFunctions(ReaderFile readerfile) throws IOException {
        iterator = 0;
        while (iterator < readerfile.getNumLinesFile()) {
            line = readerfile.getLineWithPosition(iterator);
            num = countLines(num);
            iterator++;
        }
        return num;
    }

    private int countLines(int num) {
        if (methods.isFunction(line)) {
            num++;
        }
        return num;
    }

    private int getBracesLines(int braces) {
        if (methods.isConditionType(line) && line.contains("{")) {
            braces++;
        }
        return braces;
    }

    private void insertMethodHashmap(HashMap listMethodsAndLines, String method) {
        if (num == 0) {
            listMethodsAndLines.put(getNameMethod(method), num);
        } else {
            listMethodsAndLines.put(getNameMethod(method), num - 1);
        }
    }
}
