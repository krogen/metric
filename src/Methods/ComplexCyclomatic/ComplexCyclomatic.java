package Methods.ComplexCyclomatic;

import Methods.ComplexCyclomatic.Conditions.NumberOfAnd;
import Methods.ComplexCyclomatic.Conditions.NumberOfDoubleCondition;
import Methods.ComplexCyclomatic.Conditions.NumberOfIf;
import Methods.ComplexCyclomatic.Conditions.NumberOfOr;
import Methods.ComplexCyclomatic.Exceptions.NumberOfTry;
import Methods.ComplexCyclomatic.Iterator.NumberOfFor;
import Methods.ComplexCyclomatic.Iterator.NumberOfForeach;
import Methods.ComplexCyclomatic.Iterator.NumberOfWhile;
import Methods.ComplexCyclomatic.Selection.NumberOfCase;
import Methods.ComplexCyclomatic.Selection.NumberOfContinue;
import Methods.ComplexCyclomatic.Selection.NumberOfDefault;
import Methods.Methods.MethodHash;
import Methods.Methods.MethodsFeatury;
import Package.Entities.Metric;
import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.IOException;
import java.util.HashMap;

public class ComplexCyclomatic implements Metric {
    
    public ComplexCyclomatic() {
    }

    public HashMap getListMethodsCyclomaticComplex(ReaderFile readerfile) throws IOException {
        MethodHash mh = new MethodHash(readerfile);
        MethodsFeatury method = new MethodsFeatury();
        HashMap complexcyclomatic = new HashMap();
        ReaderMethod readermethod;
        for (String line : readerfile.getArrayDataLines()) {
            if (method.isFunction(line)) {
                readermethod = new ReaderMethod(readerfile, mh.getNameMethod(line));
                complexcyclomatic.put(mh.getNameMethod(line), getNumComplex(readermethod));
            }
        }
        return complexcyclomatic;
    }

    private int getNumComplex(ReaderMethod reader) {
        int sum = 0;
        Metric[] metrics = initializeMetrics(reader);
        sum = sumarizeMetrics(metrics, sum);
        return sum;
    }

    private Metric[] initializeMetrics(ReaderMethod reader) {
         Metric metrics[] = {new NumberOfFor(reader),new NumberOfIf(reader),new NumberOfWhile(reader),
             new NumberOfTry(reader),new NumberOfForeach(reader),new NumberOfCase(reader),
             new NumberOfDefault(reader),new NumberOfContinue(reader),new NumberOfAnd(reader),
             new NumberOfOr(reader),new NumberOfDoubleCondition(reader)};
        return metrics;
    }

    private int sumarizeMetrics(Metric[] metrics, int sum) {
        for (Metric metric : metrics) {
            sum += metric.getCount();
        }
        return sum;
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
        throw new UnsupportedOperationException("Not supported yet.");
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
