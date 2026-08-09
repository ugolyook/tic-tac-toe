package QuadraticEquation;

import java.util.ArrayList;

public class ComplexNumbersEquation implements QuadraticEquationBuilder {
    private final int a;
    private final int b;
    private final int c;
    int extremumPoint;

    public ComplexNumbersEquation(String a, String b, String c) {
        this.a = fromStringToInt(a);
        this.b = fromStringToInt(b);
        this.c = fromStringToInt(c);
    }

    private static int fromStringToInt(String str) {
        if (str == null || str.isEmpty()) return 0;
        str = str.trim();
        boolean isNegative = str.startsWith("-");
        String cleaned = str.replaceAll("[^0-9]", "");
        if (cleaned.isEmpty()) return 0;
        int number = Integer.parseInt(cleaned);
        return isNegative ? -number : number;
    }

    public int findDiscriminant() {
        return b * b - 4 * a * c;
    }

    public ArrayList<String> FindRoot() {
        if (a == 0) {
            throw new IllegalArgumentException("Error, a equals 0!!! It's not quadratic equation..");
        }

        int discriminant = findDiscriminant();
        ArrayList<String> roots = new ArrayList<>();
        if (discriminant < 0) {
            double realPart = -b / (2.0 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2.0 * a);

            if (realPart == 0) {
                roots.add(imaginaryPart + "i");
                roots.add("-" + imaginaryPart + "i");
            } else if (imaginaryPart > 0) {
                roots.add(realPart + " + " + imaginaryPart + "i");
                roots.add(realPart + " - " + imaginaryPart + "i");
            } else {
                roots.add(realPart + " + " + Math.abs(imaginaryPart) + "i");
                roots.add(realPart + " - " + Math.abs(imaginaryPart) + "i");
            }
        }
        return roots;
    }

    public StringBuilder findMinMaxInterval() {
        StringBuilder builder = new StringBuilder();
        if (a > 0) {
            builder.append("Interval of decrease: from negative infinity to the ")
                    .append(extremumPoint).append("\nInterval of increase: from the ")
                    .append(extremumPoint).append(" to positive infinity");
        } else {
            builder.append("Interval of increase: from negative infinity to the ")
                    .append(extremumPoint).append("\nInterval of decrease: from the ")
                    .append(extremumPoint).append(" to positive infinity");
        }
        return builder;
    }
}
