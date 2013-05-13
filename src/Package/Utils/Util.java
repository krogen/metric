package Package.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Util {

    public Util() {
    }

    public String[] getWords(String line) {
        String[] words = line.split(" ");//[pal1,pal2,pal3]
        return words;
    }

    public BufferedReader getBufferTextLines(String file) throws IOException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        archivo = new File(file);
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
        return br;
    }

    public int getFilePattern(String file, String pattern) throws IOException {
        int num = 0;
        BufferedReader br = getBufferTextLines(file);
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.contains(pattern)) {
                num++;
            }
        }
        return num;
    }
    
}
