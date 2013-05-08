package Entities;

import Files.ReaderFile;
import java.util.HashMap;

public interface Metric {
    public abstract void add(Metric d);
    public abstract void remove(Metric d); 
    public abstract Metric getChild(int i); 
    public abstract int getCount();
    public abstract void count(ReaderFile readerfile);
    public abstract HashMap getArrayInfo(ReaderFile readerfile);
}
