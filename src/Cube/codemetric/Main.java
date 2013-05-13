package Cube.codemetric;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.sumus.dwh.datastore.DataStore;
import org.sumus.dwh.datastore.DataStoreException;

public class Main {

    public static void main(String[] args) throws DataStoreException, FileNotFoundException, IOException {
        String arguments[] = {"/Users/gloriav/NetBeansProjects/dataStore/", "/Users/gloriav/NetBeansProjects/metric/src/"};
        init(arguments);
    }

    private static void init(String[] args) throws FileNotFoundException, DataStoreException, IOException {
        //checkArgs(args);
        dataStoreDelete();
        DataStore dataStore = createDataStore(new File(args[0]));
        MockParser parser = new MockParser(dataStore);
        parser.execute(new File(args[1]));
        dataStore.save();
    }

    private static void dataStoreDelete() {
        deleteWithChildren("/Users/gloriav/NetBeansProjects/dataStore/CodeMetrics");
    }

    private static boolean deleteWithChildren(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return file.delete();
        }
        return Main.deleteChildren(file) && file.delete();
    }

    private static boolean deleteChildren(File dir) {
        File[] children = dir.listFiles();
        boolean childrenDeleted = true;
        for (int i = 0; children != null && i < children.length; i++) {
            File child = children[i];
            if (child.isDirectory()) {
                childrenDeleted = Main.deleteChildren(child) && childrenDeleted;
            }
            if (child.exists()) {
                childrenDeleted = child.delete() && childrenDeleted;
            }
        }
        return childrenDeleted;
    }

    private static DataStore createDataStore(File folder) {
        DataStoreFactory factory = new DataStoreFactory(folder);
        DataStore dataStore = factory.createDataStore();
        return dataStore;
    }

    private static void checkArgs(String[] args) {
        checkIsNotNull(args);
        checkSourceExists(new File(args[1]));
        checkTargetNotExists(new File(args[0]));
    }

    private static void checkSourceExists(File sourceDirectory) {
        if (!sourceDirectory.exists()) {
            throw new RuntimeException("Source path does not exist");
        }
    }

    private static void checkTargetNotExists(File targetDirectory) {
        if (targetDirectory.exists()) {
            throw new RuntimeException("Target path does not exist");
        }
    }

    private static void checkIsNotNull(String[] args) {
        if (args[0] == null || args[1] == null) {
            throw new RuntimeException("Paths not introduced");
        }
    }
}
