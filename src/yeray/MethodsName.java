package yeray;

public class MethodsName {

    public MethodsName() {
    }

    public String getNameMethodsLines(String line, boolean flag, String name) {
        String parameters = getParameters(line, flag, name);
        int i = line.length() - 1;
        while (i >= 0) {
            if (isParenthesis(line.charAt(i))) {
                flag = true;
                i--;
            }
            name = getNameMethods(flag, name, line.charAt(i));
            flag = getFlag(line.charAt(i), flag);
            i--;
        }
        return  parameters + name;
    }

    public String getParameters(String line, boolean flag, String name) {
        int i = line.length() - 1;
        while (i >= 0) {
            if (isParams(line.charAt(i))) {
                flag = true;
            }
            name = getNameMethods(flag, name, line.charAt(i));
            flag = isParam(line.charAt(i), flag);
            i--;
        }
        return name;
    }

    private String getNameMethods(boolean flag, String name, char character) {
        if (flag == true) {
            name = name.concat(Character.toString(character));
        }
        return name;
    }

    private boolean getFlag(char character, boolean flag) {
        if (character == ' ') {
            flag = false;
        }
        return flag;
    }

    private boolean isParenthesis(char character) {
        if (character == '(') {
            return true;
        }
        return false;
    }

    private boolean isParam(char character, boolean flag) {
        if (character == '(') {
            flag = false;
        }
        return flag;
    }

    private boolean isParams(char character) {
        if (character == ')') {
            return true;
        }
        return false;
    }
}
