package yeray;

import java.io.IOException;

public class checkParameter {
    
    private int num = 0;
    private MethodsFeatury methods = new MethodsFeatury();
    
    public checkParameter(){
    }
    
    public void isParam(String line) {
        boolean flag =  false;
        for(int i=0; i<line.length();i++){
            if((line.charAt(i) == '(') && (line.charAt(i+1) !=(')'))){
                num++;
                flag = true;
            }
            if((flag==true) && (line.charAt(i)==',')){
                num++;
            }
        }
    }
    
    public int getParameter(ReaderFile readerfile) throws IOException {
        for (String line : readerfile.getArrayDataLines()) {
            if(methods.isFunction(line)) {
                isParam(line);
            }
        }
        return num;
    } 
}
