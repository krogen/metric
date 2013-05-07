package yeray;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public final class FilesFolders implements Metric {

    private int num = 0;
    private File folder;
    private ArrayList<String> arrayListFiles = new ArrayList<>();

    public FilesFolders(File folder) {
        this.folder = folder;
        num = listNumFiles(folder, num);
    }

    public static boolean extension(File dir, String extension) {
        return dir.getName().endsWith(extension);
    }

    public int listNumFiles(File folder, int num) {
        if (isFolderExists(folder, num)) return num;
        num = getNumEffectiveFiles(folder, num);
        return num;
    }
    
    public ArrayList<String> getArrayListFiles(){
        return this.arrayListFiles;
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        num = listNumFiles(this.folder, num);
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        return null;
    }

    private int getNumFilesExtensions(File[] files, int x, int num) {
        if (extension(files[x], ".java")) {
            arrayListFiles.add(files[x].getAbsolutePath());
            num++;
        }
        return num;
    }

    private boolean isFolderExists(File folder, int num) {
        return (!folder.exists())?true:false;
    }

    private int getNumEffectiveFiles(File folder, int num) {
        File[] files = folder.listFiles();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                num = listNumFiles(files[x], num);
            }
            num = getNumFilesExtensions(files, x, num);
        }
        return num;
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
}
