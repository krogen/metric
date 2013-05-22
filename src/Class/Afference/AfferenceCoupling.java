package Class.Afference;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AfferenceCoupling implements Metric {

    private ReaderFile reader;
    private ReaderFile readerpath;
    private ArrayList<String> pathfolders;

    public AfferenceCoupling(ArrayList<String> pathfolders, ReaderFile reader) {
        this.pathfolders = pathfolders;
        this.reader = reader;
    }

    private int getAfferenceImports() throws FileNotFoundException, IOException {
        int num = 0;
        for (String path : pathfolders) {
            readerpath = new ReaderFile(path);
            num = getImportsAfferences(num);
        }
        return num;
    }

    private int getImportsAfferences(int num) throws IOException {
        for (String line : readerpath.getArrayDataLines()) {
            num = isImport(line, num);
        }
        return num;
    }

    private int isImport(String line, int num) {
        if (line.contains("import") && line.contains(getPath(reader))) {
            num++;
        }
        return num;
    }

    private String getPath(ReaderFile readerfile) {
        String file = readerfile.getPath();
        File f = new File(file);
        String[] namefile = f.getName().split(".java");
        return namefile[0];
    }

    @Override
    public void add(Metric d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Metric d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Metric getChild(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCount() {
        try {
            return getAfferenceImports();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfferenceCoupling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AfferenceCoupling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void count(ReaderFile readerfile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void count(ReaderMethod readermethod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
