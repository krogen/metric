package org.codemetric;

import java.io.File;
import java.util.Date;

import org.codemetric.definition.CubeDefinition;
import org.codemetric.definition.DataStoreDefinition;
import org.codemetric.definition.DimensionDefinition;
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

	public void execute(File sourceFolder){
		insertPackageEntity();
		insertClassEntity();
		insertMethodEntity();
		insertPackageTuple();
	}

	private void insertPackageEntity() {
		Entity component = new Entity("org.codemetric", getDimension(DataStoreDefinition.MODULES));
		component.addFeature(DataStoreDefinition.NAME.getName(), "org.codemetric");
		component.addFeature(DataStoreDefinition.TYPE.getName(), "Package");
		add(component);
	}
	
	private void insertClassEntity() {
		Entity component = new Entity("org.codemetric", getDimension(DataStoreDefinition.MODULES));
		component.addFeature(DataStoreDefinition.NAME.getName(), "org.codemetric");
		component.addFeature(DataStoreDefinition.TYPE.getName(), "Class");
		add(component);
	}

	private void insertMethodEntity() {
		Entity component = new Entity("org.codemetric", getDimension(DataStoreDefinition.MODULES));
		component.addFeature(DataStoreDefinition.NAME.getName(), "org.codemetric");
		component.addFeature(DataStoreDefinition.TYPE.getName(), "Method");
		add(component);
	}
	
	private void insertPackageTuple() {
		Context context = buildPackageContext();
		State state = buildPackageState();
		Tuple factShip = new Tuple(getCube(DataStoreDefinition.PACKAGE_CUBE), context, state);
		add(factShip);
	}

	private Context buildPackageContext() {
		Context context = new Context (new Date());
		context.put(DataStoreDefinition.MODULES.getName(), "org.codemetric");
		return context;
	}

	private State buildPackageState() {
		State state = new State();
		state.put(DataStoreDefinition.LINES_OF_CODE.getName(), 5023.);
		state.put(DataStoreDefinition.CLASSES.getName(), 5.);
		state.put(DataStoreDefinition.EFFERENT_COUPLING_INTERNAL.getName(), 4.);
		state.put(DataStoreDefinition.EFFERENT_COUPLING_LIBRARY.getName(), 2.);
		state.put(DataStoreDefinition.AFFERENT_COUPLING.getName(), 4.);
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
