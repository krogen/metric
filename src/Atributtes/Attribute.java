package Atributtes;

import java.io.IOException;
import java.util.ArrayList;
import Files.ReaderFile;

public class Attribute {

    private String path;
    private ArrayList<String> list;
    private NumberAttributeformethods listfor;
    private ListAttribute listattribute;
    private NumberAttribute NumAttribute;
    private ReaderFile reader;

    public Attribute(String path, ReaderFile reader) throws IOException {
        this.path = path;
        this.reader = reader;
        NumberAttributeGlobal();
        GetListAttribute();
        AttributeForMethodo();
        
    }

    public int NumberAttributeGlobal() throws IOException {
        NumAttribute = new NumberAttribute();
        AttributeForMethodo();
        return NumAttribute.getAttribute(path);
    }

    public void GetListAttribute() throws IOException {
        listattribute = new ListAttribute(this.path);
        list = listattribute.getAttribute(this.reader);
    }

    public ArrayList<Integer> AttributeForMethodo() throws IOException {
        GetListAttribute();
        listfor = new NumberAttributeformethods(list);
        return listfor.getAttribute(path);
    }
}
