package Methods.Atributtes;

import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Attribute implements Metric {

    private String path;
    private ArrayList<String> list;
    private int num;

    public Attribute(ReaderFile reader) {
        this.path = reader.getPath();
        count(reader);
    }

    public int NumberAttributeGlobal() throws IOException {
        NumberAttribute NumAttribute = new NumberAttribute();
        return NumAttribute.getAttribute(path);
    }

    public void GetListAttribute() throws IOException {
        ListAttribute listattribute = new ListAttribute();
        list = listattribute.getAttribute(path);
    }

    public ArrayList<Integer> AttributeForMethodo() throws IOException {
        GetListAttribute();
        NumberAttributeformethods listfor = new NumberAttributeformethods(list);
        return listfor.getAttribute(path);
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
        return num;
    }

    @Override
    public void count(ReaderFile readerfile) {
        try {
            num = NumberAttributeGlobal();
        } catch (IOException ex) {
            Logger.getLogger(Attribute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void count(ReaderMethod readermethod) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HashMap getArrayInfo(ReaderFile readerfile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
