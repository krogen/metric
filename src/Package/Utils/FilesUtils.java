package Package.Utils;

import Package.Files.ReaderFile;
import Package.Files.ReaderMethod;
import java.io.IOException;

public class FilesUtils {

    private int num = 0;

    public FilesUtils() {
    }

    public int getFilePattern(ReaderMethod reader, String pattern) throws IOException {
        boolean IsTheSymbol = false;
        for (String line : reader.getLinesOfMethod()) {
            IsTheSymbol = isInitialBlockComment(line, IsTheSymbol);
            sumarizePatterns(line, pattern, IsTheSymbol);
            isFinalBlockComment(line, IsTheSymbol);
        }
        return num;
    }

    public int getFilePattern(ReaderFile reader, String pattern) throws IOException {
        boolean IsTheSymbol = false;
        for (String line : reader.getArrayDataLines()) {
            IsTheSymbol = isInitialBlockComment(line, IsTheSymbol);
            sumarizePatterns(line, pattern, IsTheSymbol);
            isFinalBlockComment(line, IsTheSymbol);
        }
        return num;
    }

    private boolean isInitialBlockComment(String line, boolean IsTheSymbol) {
        if(line.contains("//") || line.contains("/*")) {
            IsTheSymbol = true;
        }
        return IsTheSymbol;
    }

    private void isFinalBlockComment(String line, boolean IsTheSymbol) {
        if(line.contains("//") || line.contains("*/") && IsTheSymbol == true) {
            IsTheSymbol = false;
        }
    }

    private void sumarizePatterns(String line, String pattern, boolean IsTheSymbol) {
        if (line.contains(pattern) && IsTheSymbol == false) {
            num++;
        }
    }
}
