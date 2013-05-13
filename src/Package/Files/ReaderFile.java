package Package.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class ReaderFile {

    private ArrayList<String> ArrayDataLinesFile = new ArrayList<>();
    private File file = null;
    private FileReader filereader = null;
    private BufferedReader buffer = null;
    private int numLinesOfFile = 0;
    
    private String path;

    public ReaderFile(String routeFile) throws FileNotFoundException, IOException {
        file = new File(routeFile);
        filereader = new FileReader(file);
        buffer = new BufferedReader(filereader);
        ArrayDataLinesFile = getArrayDataLines();
        path = routeFile;
    }

    public ArrayList<String> getArrayDataLines() throws IOException {
        String line;
        while ((line = buffer.readLine()) != null) {
            ArrayDataLinesFile.add(line);
            numLinesOfFile++;
        }
        return ArrayDataLinesFile;
    }

    public int getNumLinesFile() {
        return numLinesOfFile;
    }

    public String getLineWithPosition(int position) {
        return ArrayDataLinesFile.get(position);
    }

    public File getFile() {
        return file;
    }

    public FileReader getFileReader() {
        return filereader;
    }
    
    public String getPath(){
        return path;
    }
}
