package Package.Entities;

import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.util.HashMap;

public interface Metric {
    public abstract void add(Metric d);
    public abstract void remove(Metric d); 
    public abstract Metric getChild(int i); 
    public abstract int getCount();
    public abstract void count(ReaderFile readerfile);
    public abstract void count(ReaderMethod readermethod);
    public abstract HashMap getArrayInfo(ReaderFile readerfile);
}
