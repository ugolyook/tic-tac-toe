package QuadraticEquation;

import java.util.ArrayList;

public class FractionalNumbersEquation implements QuadraticEquationBuilder{
    private final float a;
    private final float b;
    private final float c;
    float extremumPoint;

    public FractionalNumbersEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a == 0) {
            throw new IllegalArgumentException("Error, a equals 0!!! It's not quadratic equation..");
        }
    }

    public float findDiscriminant() {
        return b * b - 4 * a * c;
    }

    public ArrayList<Double> FindRoot() {
        float discriminant = findDiscriminant();
        ArrayList<Double> roots = new ArrayList<>();
        if (discriminant > 0) {
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            roots.add(firstRoot);
            roots.add(secondRoot);
        } else if (discriminant == 0) {
            double root = -b / (2.0 * a);
            roots.add(root);
        } else {
            System.out.println("There are no roots");
        }
        return roots;
    }

    public float findExtremum() {
        extremumPoint = -b / (2 * a);
        return a * (extremumPoint * extremumPoint) + (b * extremumPoint) + c;
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
