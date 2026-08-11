package QuadraticEquation;

public class Parsing {
    static int fromStringToInt(String str) {
        if (str == null || str.isEmpty()) return 0;
        str = str.trim();
        boolean isNegative = str.startsWith("-");
        String cleaned = str.replaceAll("[^0-9]", "");
        if (cleaned.isEmpty()) return 0;
        int number = Integer.parseInt(cleaned);
        return isNegative ? -number : number;
    }
}
