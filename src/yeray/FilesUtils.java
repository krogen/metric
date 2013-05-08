package yeray;

import java.io.IOException;

public class FilesUtils {

    private int num = 0;

    public FilesUtils() {
    }

    public int getFilePattern(ReaderFile readerfile, String pattern) throws IOException {
        for (String line : readerfile.getArrayDataLines()) {
            if (line.contains(" " + pattern)) {
                num++;
            }
        }
        return num;
    }
}
