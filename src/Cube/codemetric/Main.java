package Cube.codemetric;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.sumus.dwh.datastore.DataStore;
import org.sumus.dwh.datastore.DataStoreException;

public class Main {
    
    public static void main(String[] args) throws DataStoreException, FileNotFoundException, IOException {
        String arguments[] = {"src", "dataStore"};
        init(arguments);
    }

    private static void init(String[] args) throws FileNotFoundException, DataStoreException, IOException {
        createFolders();
        checkArgs(args);
        dataStoreDelete();
        createParser(args);
    }
    
    private static DataStore createDataStore(File folder) {
        DataStoreFactory factory = new DataStoreFactory(folder);
        DataStore dataStore = factory.createDataStore();
        return dataStore;
    }

    private static void checkArgs(String[] args) {
        checkIsNotNull(args);
        checkSourceExists(new File(args[0]));
        checkTargetNotExists(new File(args[1]));
    }

    private static void checkSourceExists(File sourceDirectory) {
        if (!sourceDirectory.exists()) {
            throw new RuntimeException("Source path does not exist");
        }
    }

    private static void checkTargetNotExists(File targetDirectory) {
        if (!targetDirectory.exists()) {
            throw new RuntimeException("Target path does not exist");
        }
    }

    private static void checkIsNotNull(String[] args) {
        if (args[0] == null || args[1] == null) {
            throw new RuntimeException("Paths not introduced");
        }
    }
    
    private static void dataStoreDelete() {
        deleteWithChildren("dataStore/CodeMetrics");
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
    
    private static void createFolders() {
        File folder = new File("dataStore/CodeMetrics");
        if(!folder.exists()){
            folder.mkdirs();
        } 
    }
    
    private static void createParser(String[] args) throws IOException, DataStoreException {
        DataStore dataStore = createDataStore(new File(args[1]));
        Parser parser = new Parser(dataStore);
        parser.execute(new File(args[0]));
        dataStore.save();
    }
}
