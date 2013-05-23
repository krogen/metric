package Cube.codemetric;

import Class.Afference.AfferenceCoupling;
import Class.Afference.NumberOfImports;
import Class.Classes;
import Class.Construct.Construct;
import Cube.codemetric.definition.CubeDefinition;
import Cube.codemetric.definition.DataStoreDefinition;
import Cube.codemetric.definition.DimensionDefinition;
import Cube.codemetric.definition.MetricDefinition;
import Methods.Atributtes.Attribute;
import Methods.ComplexCyclomatic.ComplexCyclomatic;
import Methods.Lines.Lines;
import Methods.Lines.LinesEffectives;
import Methods.Methods.Methods;
import Methods.Parameters.Parameter;
import Package.Entities.Metric;
import Package.Files.FilesFolders;
import Package.Files.ReaderFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.sumus.dwh.cube.Cube;
import org.sumus.dwh.datastore.Context;
import org.sumus.dwh.datastore.DataStore;
import org.sumus.dwh.datastore.Entity;
import org.sumus.dwh.datastore.State;
import org.sumus.dwh.datastore.Tuple;
import org.sumus.dwh.dimension.Dimension;

public class MockParser {

    private final DataStore dataStore;

    public MockParser(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public DataStore getDataStore() {
        return dataStore;
    }

    public void execute(File sourceFolder) throws FileNotFoundException, IOException {
        insertPackageEntity();
        insertClassEntity();
        insertMethodEntity();
        insertPackageTuple(sourceFolder);
    }

    private void insertPackageEntity() {
        Entity component = new Entity("Package", getDimension(DataStoreDefinition.MODULES));
        component.addFeature(DataStoreDefinition.NAME.getName(), "Package");
        component.addFeature(DataStoreDefinition.TYPE.getName(), "Package");
        add(component);
    }

    private void insertClassEntity() {
        Entity component = new Entity("Class", getDimension(DataStoreDefinition.MODULES));
        component.addFeature(DataStoreDefinition.NAME.getName(), "Class");
        component.addFeature(DataStoreDefinition.TYPE.getName(), "Class");
        add(component);
    }

    private void insertMethodEntity() {
        Entity component = new Entity("Methods", getDimension(DataStoreDefinition.MODULES));
        component.addFeature(DataStoreDefinition.NAME.getName(), "Methods");
        component.addFeature(DataStoreDefinition.TYPE.getName(), "Method");
        add(component);
    }

    private void insertPackageTuple(File folder) throws FileNotFoundException, IOException {
        FilesFolders numfiles = new FilesFolders(folder);
        ArrayList<String> arrayfiles = numfiles.getArrayListFiles();
        for (String path : arrayfiles) {
            addTupleInCube(path, arrayfiles);
        }
    }

    private void addTupleInCube(String path, ArrayList<String> arrayfiles) throws IOException {
        ReaderFile readerfile;
        AfferenceCoupling afferencecoupling;
        Context context;
        State state;
        Tuple factShip;
        readerfile = new ReaderFile(path);
        afferencecoupling = new AfferenceCoupling(arrayfiles, readerfile);
        context = buildPackageContext(path);
        state = buildPackageState(readerfile, afferencecoupling);
        factShip = new Tuple(getCube(DataStoreDefinition.PACKAGE_CUBE), context, state);
        add(factShip);
    }

    private Context buildPackageContext(String path) {
        Context context = new Context(new Date());
        context.put(DataStoreDefinition.MODULES.getName(), path);
        return context;
    }

    private State buildPackageState(ReaderFile reader, AfferenceCoupling afference) throws IOException {
        State state = new State();
        int ite = 0;
        Metric metrics[] = initializeMetrics(reader, afference);
        String metricdefinition[] = initializeMetricDefinitions();
        return putMetricInStateCube(metrics, state, metricdefinition, ite);
        //putMethodNameParameters(metrics, reader, state);
        //return putCyclomaticComplexMethod(reader, state);
    }

    private Dimension getDimension(DimensionDefinition definition) {
        return getDataStore().getDimension(definition.getName());
    }

    private Cube getCube(CubeDefinition definition) {
        return getDataStore().getCube(definition.getName());
    }

    private void add(Entity entity) {
        
        //System.out.println(entity.getFeatureMap().values());
        
        getDataStore().insert(entity);
    }

    private void add(Tuple tuple) {
        
        System.out.println("adios");
        //System.out.println(tuple.getState().values());
        
        
        getDataStore().insert(tuple);
    }

    private String[] initializeMetricDefinitions() {
        String metricdefinition[] = {DataStoreDefinition.LINES_OF_CODE.getName(), DataStoreDefinition.EFFECTIVE_LINES_CODE.getName(),
            DataStoreDefinition.CLASSES.getName(), DataStoreDefinition.PARAMETERS.getName(), DataStoreDefinition.CONSTRUCTS.getName(),
            DataStoreDefinition.ATTRIBUTES.getName(), DataStoreDefinition.AFFERENT_COUPLING.getName()};
        return metricdefinition;
    }

    private Metric[] initializeMetrics(ReaderFile reader, AfferenceCoupling afference) throws IOException {
        Metric metrics[] = {new Lines(reader), new LinesEffectives(reader), new Classes(reader), new Methods(reader),
            new NumberOfImports(reader), new Parameter(reader), new Construct(reader), new Attribute(reader), afference};
        return metrics;
    }

    private State putMetricInStateCube(Metric[] metrics, State state, String[] metricdefinition, int ite) {
        for (String metric : metricdefinition) {
            if(ite<metricdefinition.length){
                state.put(metricdefinition[ite], (double) metrics[ite].getCount());
            }   
            ite++;
        }
        return state;
    }

    private void putMethodNameParameters(Metric[] metrics, ReaderFile reader, State state) throws NumberFormatException {
        HashMap hm = metrics[5].getArrayInfo(reader);
        MetricDefinition METHODNAME;
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            METHODNAME = new MetricDefinition(DataStoreDefinition.METHOD_NAME + me.getKey().toString());
            state.put(METHODNAME.getName(), Double.parseDouble(me.getValue().toString()));
        }
    }
    
    private State putCyclomaticComplexMethod(ReaderFile reader, State state) throws NumberFormatException, IOException {
        ComplexCyclomatic complex = new ComplexCyclomatic();
        MetricDefinition METHODNAME;
        HashMap list = complex.getListMethodsCyclomaticComplex(reader);
        Set set2 = list.entrySet();
        Iterator i2 = set2.iterator();
        while (i2.hasNext()) {
            Map.Entry me2 = (Map.Entry) i2.next();
            METHODNAME = new MetricDefinition(DataStoreDefinition.CYCLOMATIC_COMPLEXITY + me2.getKey().toString());
            state.put(METHODNAME.getName(), Double.parseDouble(me2.getValue().toString()));
        }
        return state;
    }
}
