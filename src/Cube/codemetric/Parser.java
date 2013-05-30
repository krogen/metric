package Cube.codemetric;

import Class.Afference.AfferenceCoupling;
import Class.Classes;
import Class.Construct.Construct;
import Class.Efference.EfferenceCoupling;
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
import Package.Packages.Packages;
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

public class Parser {

    private final DataStore dataStore;
    private File packages;

    public Parser(DataStore dataStore) {
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
        Entity component = new Entity("org.core", getDimension(DataStoreDefinition.MODULES));
        component.addFeature(DataStoreDefinition.NAME.getName(), "org.core");
        component.addFeature(DataStoreDefinition.TYPE.getName(), "Package");
        add(component);
    }

    private void insertClassEntity() {
        Entity component = new Entity("org.core.Parser", getDimension(DataStoreDefinition.MODULES));
        component.addFeature(DataStoreDefinition.NAME.getName(), "org.core.Parser");
        component.addFeature(DataStoreDefinition.TYPE.getName(), "Class");
        add(component);
    }

    private void insertMethodEntity() {
        Entity component = new Entity("org.core.Parser.execute", getDimension(DataStoreDefinition.MODULES));
        component.addFeature(DataStoreDefinition.NAME.getName(), "org.core.Parser.execute");
        component.addFeature(DataStoreDefinition.TYPE.getName(), "Method");
        add(component);
    }

    private void insertPackageTuple(File folder) throws FileNotFoundException, IOException {
        FilesFolders numfiles = new FilesFolders(folder);
        packages = folder;
        ArrayList<String> arrayfiles = numfiles.getArrayListFiles();
        for (String path : arrayfiles) {
            addTupleInCube(path, arrayfiles);
        }
    }

    private void addTupleInCube(String path, ArrayList<String> arrayfiles) throws IOException {
        ReaderFile readerfile;
        AfferenceCoupling afferencecoupling;
        State state;
        Tuple factShip;
        readerfile = new ReaderFile(path);
        afferencecoupling = new AfferenceCoupling(arrayfiles, readerfile);
        
        Context context = buildPackageContext();
        state = buildPackageState(readerfile, afferencecoupling);
        factShip = new Tuple(getCube(DataStoreDefinition.PACKAGE_CUBE), context, state);
        add(factShip);
        
        context = buildClassContext();
        state = buildClassState(readerfile, afferencecoupling);
        factShip = new Tuple(getCube(DataStoreDefinition.CLASS_CUBE), context, state);
        add(factShip);
        
        context = buildMethodContext();
        state = buildMethodState(readerfile);
        factShip = new Tuple(getCube(DataStoreDefinition.METHOD_CUBE), context, state);
        add(factShip);
    }

    private Context buildPackageContext() {
        Context context = new Context(new Date());
        context.put(DataStoreDefinition.MODULES.getName(), "org.core");
        return context;
    }

    private State buildPackageState(ReaderFile reader, AfferenceCoupling afference) throws IOException {
        State state = new State();
        int ite = 0;
        Metric metrics[] = initializeMetricsPackage(reader, afference);
        String metricdefinition[] = initializeMetricPackageDefinitions();
        return putMetricInStateCube(metrics, state, metricdefinition, ite);
    }
    
    private Context buildClassContext() {
        Context context = new Context(new Date());
        context.put(DataStoreDefinition.MODULES.getName(), "org.core.Parser");
        return context;
    }

    private State buildClassState(ReaderFile reader, AfferenceCoupling afference) throws IOException {
        State state = new State();
        int ite = 0;
        Metric metrics[] = initializeMetricsClass(reader, afference);
        String metricdefinition[] = initializeMetricsClassDefinitions();
        return putMetricInStateCube(metrics, state, metricdefinition, ite);
    }
    
    private Context buildMethodContext() {
        Context context = new Context(new Date());
        context.put(DataStoreDefinition.MODULES.getName(), "org.core.Parser.execute");
        return context;
    }

    private State buildMethodState(ReaderFile reader) throws IOException {
        State state = new State();
        putMethodNameMethodLineMethods(reader, state);
        putMethodNameMethodNumParameters(reader, state);
        return putCyclomaticComplexMethod(reader, state);
    }

    private Dimension getDimension(DimensionDefinition definition) {
        return getDataStore().getDimension(definition.getName());
    }

    private Cube getCube(CubeDefinition definition) {
        return getDataStore().getCube(definition.getName());
    }

    private void add(Entity entity) {
        getDataStore().insert(entity);
    }

    private void add(Tuple tuple) {
        getDataStore().insert(tuple);
    }
    
    private String[] initializeMetricPackageDefinitions() {
        String metricdefinition[] = {DataStoreDefinition.LINES_OF_CODE.getName(), DataStoreDefinition.EFFECTIVE_LINES_CODE.getName(),
            DataStoreDefinition.CLASSES.getName(), DataStoreDefinition.EFFERENT_COUPLING_LIBRARY.getName(), 
            DataStoreDefinition.AFFERENT_COUPLING.getName(), DataStoreDefinition.PACKAGES.getName(), DataStoreDefinition.FILESFOLDERS.getName()};
        return metricdefinition;
    }

    private Metric[] initializeMetricsPackage(ReaderFile reader, AfferenceCoupling afference) throws IOException {
        Metric metrics[] = {new Lines(reader), new LinesEffectives(reader), new Classes(reader), new EfferenceCoupling(reader), 
            afference,  new Packages(packages), new FilesFolders(packages)};
        return metrics;
    }
    
    private String[] initializeMetricsClassDefinitions() {
        String metricdefinition[] = {DataStoreDefinition.LINES_OF_CODE.getName(), DataStoreDefinition.EFFECTIVE_LINES_CODE.getName(),
            DataStoreDefinition.CONSTRUCTS.getName(), DataStoreDefinition.CLASSES.getName(), DataStoreDefinition.ATTRIBUTES.getName(), 
            DataStoreDefinition.METHODS.getName(), DataStoreDefinition.EFFERENT_COUPLING_LIBRARY.getName(), DataStoreDefinition.AFFERENT_COUPLING.getName()};
        return metricdefinition;
    }
    
    private Metric[] initializeMetricsClass(ReaderFile reader, AfferenceCoupling afference) throws IOException {
        Metric metrics[] = {new Lines(reader), new LinesEffectives(reader), new Construct(reader), new Classes(reader), 
            new Attribute(reader), new Methods(reader), new EfferenceCoupling(reader), afference };
        return metrics;
    }

    private State putMetricInStateCube(Metric[] metrics, State state, String[] metricdefinition, int ite) {
        for (String metric : metricdefinition) {
            if(ite < metricdefinition.length){
                state.put(metricdefinition[ite], (double) metrics[ite++].getCount());
            }
        }
        return state;
    }
    
    private State putMethodNameMethodNumParameters(ReaderFile reader, State state) throws NumberFormatException {
        Parameter parameter = new Parameter(reader);
        HashMap hm = parameter.getArrayInfo(reader);
        MetricDefinition METHODNAME;
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            METHODNAME = new MetricDefinition(DataStoreDefinition.METHOD_NAME + me.getKey().toString());
            state.put(METHODNAME.getName(), Double.parseDouble(me.getValue().toString()));
        }
        return state;
    }
    
    private State putMethodNameMethodLineMethods(ReaderFile reader, State state) throws NumberFormatException, FileNotFoundException, IOException {
        Methods method = new Methods(reader);
        HashMap hm = method.getArrayInfo(reader);
        MetricDefinition METHODNAME;
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            METHODNAME = new MetricDefinition(DataStoreDefinition.METHOD_LINES + me.getKey().toString());
            state.put(METHODNAME.getName(), Double.parseDouble(me.getValue().toString()));
        }
        return state;
    }
    
    private State putCyclomaticComplexMethod(ReaderFile reader, State state) throws NumberFormatException, IOException {
        ComplexCyclomatic complex = new ComplexCyclomatic();
        MetricDefinition METHODNAME;
        HashMap list = complex.getListMethodsCyclomaticComplex(reader);
        Set set = list.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            METHODNAME = new MetricDefinition(DataStoreDefinition.CYCLOMATIC_COMPLEXITY + me.getKey().toString());
            state.put(METHODNAME.getName(), Double.parseDouble(me.getValue().toString()));
        }
        return state;
    }
}
