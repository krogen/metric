package Package.Packages;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.File;
import java.util.HashMap;

public final class Packages implements Metric {

    private int numpackages = 0;
    private int num = 0;
    private File folder;

    public Packages(File folder) {
        this.folder = folder;
        numpackages = listNumPackages(folder, 0);
    }

    public static boolean extension(File dir, String extension) {
        return dir.getName().endsWith(extension);
    }

    public int listNumPackages(File folder, int packages) {
        if (isFolderExists(folder)) return numpackages;
        getNumPackagesFiles(folder);
        numPackages();
        return numpackages;
    }

    @Override
    public int getCount() {
        return numpackages;
    }

    @Override
    public void count(ReaderFile readerfile) {
        numpackages = listNumPackages(this.folder, 0);
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        return null;
    }

    private void numPackages() {
        if(num > 0){
            numpackages++;
            num = 0;
        }
    }

    private void getNumFilesExtension(File[] files, int x) {
        if (extension(files[x], ".java")) {
            num++;
        }
    }

    private void isDirectory(File[] files, int x) {
        if (files[x].isDirectory()) {
            numpackages = listNumPackages(files[x], numpackages);
        }
    }

    private boolean isFolderExists(File folder) {
        if (!folder.exists()) {
            return true; //TODO:exception
        }
        return false;
    }

    private void getNumPackagesFiles(File folder) {
        File[] files = folder.listFiles();
        for (int x = 0; x < files.length; x++) {
            isDirectory(files, x);
            getNumFilesExtension(files, x);
        }
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
    public void count(ReaderMethod readermethod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
