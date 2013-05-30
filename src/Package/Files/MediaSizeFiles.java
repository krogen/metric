package Package.Files;

import Package.Entities.Metric;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public final class MediaSizeFiles implements Metric {

    private int num = 0;
    private File folder;
    private FilesFolders folders;
    private long size = 0;
    private ReaderFile readerfile = null;

    public MediaSizeFiles(File folder) {
        this.folder = folder;
        folders = new FilesFolders(folder);
        count(this.readerfile);
    }

    public int getSizeTotalFolder() {
        File file;
        ArrayList<String> arrayFiles = folders.getArrayListFiles();
        for (String path : arrayFiles) {
            file = new File(path);
            size += file.length();
        }
        return (int) size;
    }

    @Override
    public int getCount() {
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        num = (int) (getSizeTotalFolder() / this.folders.getCount());
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        return null;
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
