public class Checker {
    private static boolean checkForLength(String line, int length) {
        return line.length() >= length;
    }

    private static boolean checkForLowercase(String line) {
        return !line.equals(line.toUpperCase());
    }

    private static boolean checkForCapital(String line) {
        return !line.equals(line.toLowerCase());
    }

    private static boolean checkForLetter(String line) {
        return checkForLowercase(line) || checkForCapital(line);
    }

    private static boolean isDigit(char symbol) {
        return '0' <= symbol && symbol <= '9';
    }

    private static boolean isLetter(char symbol) {
        return ('a' <= symbol && symbol <= 'z') || ('A' <= symbol && symbol <= 'Z');
    }

    private static boolean checkForDigit(String line) {
        boolean anyDigit = false;
        for (int index = 0; index < line.length(); ++index) {
            if (isDigit(line.charAt(index))) {
                anyDigit = true;
                break;
            }
        }
        return anyDigit;
    }

    private static boolean checkForCorrectness(String line) {
        boolean otherSymbol = false;
        for (int index = 0; index < line.length(); ++index) {
            if (!isDigit(line.charAt(index)) && !isLetter(line.charAt(index))) {
                otherSymbol = true;
                break;
            }
        }
        return !otherSymbol;
    }

    public static boolean checkPassword(String password) {
        /*
        Criteria:
            1. Length of pass - more or equal than 8 characters
            2. Should contain at least 1 capital letter, 1 lowercase letter and 1 digit
            3. Only letter, digits and symbol "_"
         */
        boolean correctLength = checkForLength(password, 8);
        boolean anyLowercase = checkForLowercase(password);
        boolean anyCapital = checkForCapital(password);
        boolean anyDigit = checkForDigit(password);
        boolean correctSymbols = checkForCorrectness(password);
        return correctLength && anyLowercase && anyCapital && anyDigit && correctSymbols;
    }

    public static boolean checkLogin(String login) {
        /*
        Criteria:
            1. Length of pass - more or equal than 4 characters
            2. Should contain at least 1 letter
            3. Only letter, digits and symbol "_"
         */
        boolean correctLength = checkForLength(login, 4);
        boolean anyLetter = checkForLetter(login);
        boolean correctSymbols = checkForCorrectness(login);
        return correctLength && anyLetter && correctSymbols;
    }
}
