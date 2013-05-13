package Methods.Methods;

public class MethodsFeatury {

    private String[] patterns = {"for", "while", "switch", "if", "catch", "try"};

    public MethodsFeatury() {
    }

    public boolean isConditionType(String line) {
        return (isPatternCondition(line)) ? true : false;
    }

    public boolean isFunction(String line) {
        return (!isConditionType(line) && line.contains("{") && line.contains("(") && !line.contains("return")) ? true : false;
    }

    public boolean isPatternCondition(String line) {
        for (String pattern : patterns) {
            if (line.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    public String reverseString(String name) {
        StringBuilder names = new StringBuilder(name);
        return names.reverse().toString();
    }

    public int countLines(String line, int num) {
        if (isFunction(line)) {
            num++;
        }
        return num;
    }

    public int getBracesLines(String line, int braces) {
        if (isConditionType(line) && line.contains("{")) {
            braces++;
        }
        return braces;
    }
}
