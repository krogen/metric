package Cube.codemetric;

import Class.Classes;
import Class.ReservedWords.AfferenceCoupling;
import Class.ReservedWords.Construct;
import Class.ReservedWords.NumberOfImports;
import Class.ReservedWords.Packages;
import Class.ReservedWords.Parameter;
import Cube.codemetric.definition.CubeDefinition;
import Cube.codemetric.definition.DataStoreDefinition;
import Cube.codemetric.definition.DimensionDefinition;
import Cube.codemetric.definition.MetricDefinition;
import Methods.Lines.LinesEffectives;
import Methods.Methods.Methods;
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
        Packages packages = new Packages(folder);
        ArrayList<String> arrayfiles = numfiles.getArrayListFiles();
        Context context;
        AfferenceCoupling afferencecoupling;
        State state;
        Tuple factShip;
        ReaderFile readerfile;
        for (String path : arrayfiles) {
            readerfile = new ReaderFile(path);
            afferencecoupling = new AfferenceCoupling(arrayfiles, readerfile);
            context = buildPackageContext(path);
            state = buildPackageState(readerfile, afferencecoupling);
            factShip = new Tuple(getCube(DataStoreDefinition.PACKAGE_CUBE), context, state);
            add(factShip);
        }
    }

    private Context buildPackageContext(String path) {
        Context context = new Context(new Date());
        context.put(DataStoreDefinition.MODULES.getName(), path);
        return context;
    }

    private State buildPackageState(ReaderFile reader, AfferenceCoupling afference) throws IOException {
        State state = new State();
        LinesEffectives lineseffectives = new LinesEffectives(reader);
        Classes numclasses = new Classes(reader);
        Methods numMethods = new Methods(reader);
        NumberOfImports imports = new NumberOfImports(reader);
        Parameter parameters = new Parameter(reader);
        Construct constructs = new Construct(reader);

        state.put(DataStoreDefinition.LINES_OF_CODE.getName(), (double) reader.getNumLinesFile());
        state.put(DataStoreDefinition.EFFECTIVE_LINES_CODE.getName(), (double) lineseffectives.getCount());
        state.put(DataStoreDefinition.METHODS.getName(), (double) numMethods.getCount());
        state.put(DataStoreDefinition.CLASSES.getName(), (double) numclasses.getCount());
        state.put(DataStoreDefinition.EFFERENT_COUPLING_LIBRARY.getName(), (double) imports.getCount());
        state.put(DataStoreDefinition.PARAMETERS.getName(), (double) parameters.getCount());
        HashMap hm = parameters.getArrayInfo(reader);
        MetricDefinition METHODNAME;
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            METHODNAME = new MetricDefinition("NUMPARAMETERSFORMETHOD: " + me.getKey().toString());
            state.put(METHODNAME.getName(), Double.parseDouble(me.getValue().toString()));
        }
        state.put(DataStoreDefinition.CONSTRUCTS.getName(), (double) constructs.getCount());

        state.put(DataStoreDefinition.AFFERENT_COUPLING.getName(), (double) afference.getCount());

        System.out.println(reader.getPath() + " -> " + (double) afference.getCount());

        return state;
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
}
