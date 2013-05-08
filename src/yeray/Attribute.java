package yeray;

import java.io.IOException;
import java.util.ArrayList;

public class Attribute {

    private String path;
    private ArrayList<String> list;
    private NumberAttributeformethods listfor;
    private ListAttribute listattribute;
    private NumberAttribute NumAttribute;

    public Attribute(String path) {
        this.path = path;
    }

    public int NumberAttributeGlobal() throws IOException {
        NumAttribute = new NumberAttribute();
        AttributeForMethodo();
        return NumAttribute.getAttribute(path);
    }

    public void GetListAttribute() throws IOException {
        listattribute = new ListAttribute();
        list = listattribute.getAttribute(path);
    }

    public ArrayList<Integer> AttributeForMethodo() throws IOException {
        GetListAttribute();
        listfor = new NumberAttributeformethods(list);
        return listfor.getAttribute(path);
    }
}
