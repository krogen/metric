package Methods.Parameters;

import Methods.Methods.MethodHash;
import Methods.Methods.MethodsFeatury;
import Package.Files.ReaderFile;
import java.io.IOException;
import java.util.HashMap;

public class checkParameter {

    private int num;
    private MethodsFeatury methods = new MethodsFeatury();

    public checkParameter() {
    }

    private void contentComma(String line, int i) {
        if ((line.charAt(i) == ',')) {
            num++;
        }
    }

    public boolean isParam(String line) {
        num = 0;
        boolean isNotMethod = true;
        for (int i = 0; i < line.length(); i++) {
            if ((line.charAt(i) == '(') && (line.charAt(i + 1) != (')'))) {
                num++;
            }
            if (line.charAt(i) == '{') {
                isNotMethod = false;
            }
            contentComma(line, i);
        }
        return isNotMethod;
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
        if (methods.isFunction(line)) {
            if (isParam(mh.getNameMethod(line))) {
                addListMethodsAndParams(listMethodsAndParams, mh, line);
            }
        }
    }

    private void addListMethodsAndParams(HashMap listMethodsAndParams, MethodHash mh, String line) {
        listMethodsAndParams.put(mh.getNameMethod(line), num);
    }
}
