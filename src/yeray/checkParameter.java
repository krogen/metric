package yeray;

import java.io.IOException;
import java.util.HashMap;

public class checkParameter {
    
    private int num;
    private MethodsFeatury methods = new MethodsFeatury();
    
    public checkParameter(){}
    
    private void contentComma(String line, int i) {
        if((line.charAt(i)==',')){
            num++;
        }
    }
    
    public void isParam(String line) {
        num = 0;
        for(int i=0; i<line.length();i++){
            if((line.charAt(i) == '(') && (line.charAt(i+1) !=(')'))){
                num++;
            }
            contentComma(line, i);
        }
    }
    
    public HashMap getListMethodsAndParams(ReaderFile readerfile) throws IOException {
        MethodHash mh = new MethodHash(readerfile);
        HashMap listMethodsAndParams = new HashMap();
        for (String line : readerfile.getArrayDataLines()) { 
            getNumParameters(line, mh, listMethodsAndParams);
        }
        return listMethodsAndParams;
    } 

    private void getNumParameters(String line, MethodHash mh, HashMap listMethodsAndParams) {
        if(methods.isFunction(line)) {
            isParam(mh.getNameMethod(line));
            addListMethodsAndParams(listMethodsAndParams, mh, line);
        }
    }

    private void addListMethodsAndParams(HashMap listMethodsAndParams, MethodHash mh, String line) {
        listMethodsAndParams.put(mh.getNameMethod(line), num);
    }
    
}
