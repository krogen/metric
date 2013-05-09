package org.codemetric;

import java.io.File;
import org.sumus.dwh.datastore.DataStore;
import org.sumus.dwh.datastore.DataStoreException;

public class Main {

	public static void main(String[] args) throws DataStoreException {
		//checkArgs(args);
		DataStore dataStore = createDataStore(new File ("/Users/gloriav/NetBeansProjects/dataStore/"));
		MockParser parser = new MockParser(dataStore);
		parser.execute(new File("/Users/gloriav/NetBeansProjects/metric/src/"));
		dataStore.save();
                
                System.out.println(dataStore.getCubes());
                
	}

	private static DataStore createDataStore(File folder) {
		DataStoreFactory factory = new DataStoreFactory(folder);
		DataStore dataStore = factory.createDataStore();
		return dataStore;
	}

	private static void checkArgs(String[] args) {
		checkIsNotNull(args);
		checkSourceExists(new File (args[0]));
		checkTargetNotExists(new File (args[1]));
	}

	private static void checkSourceExists(File sourceDirectory) {
		if(!sourceDirectory.exists())
			throw new RuntimeException("Source path does not exist");
	}
	
	private static void checkTargetNotExists(File targetDirectory) {
		if(targetDirectory.exists())
			throw new RuntimeException("Target path does not exist");
	}

	private static void checkIsNotNull(String[] args) {
		if(args[0] == null || args[1] == null)
			throw new RuntimeException("Paths not introduced");
	}

}
