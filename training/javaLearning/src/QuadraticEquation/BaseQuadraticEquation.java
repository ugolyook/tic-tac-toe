package QuadraticEquation;

import java.util.ArrayList;

import static QuadraticEquation.Parsing.fromStringToInt;

public abstract class BaseQuadraticEquation<T> {
    protected double a;
    protected double b;
    protected double c;
    protected double extremumPoint;

    public BaseQuadraticEquation(String a, String b, String c) {
        this.a = fromStringToInt(a);
        this.b = fromStringToInt(b);
        this.c = fromStringToInt(c);
        if (this.a == 0) {
            throw new IllegalArgumentException("Error, a equals 0!!! It's not quadratic equation.");
        }
        this.extremumPoint = -this.b / (2.0 * this.a);
    }

    public T findDiscriminant() {
        double discriminant = b * b - 4 * a * c;
        return convertToType(discriminant);
    }

    protected abstract T convertToType(double value);

    public ArrayList<T> FindRoot() {
        double discriminant = b * b - 4 * a * c;
        ArrayList<T> roots = new ArrayList<>();

        if (discriminant > 0) {
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            roots.add(convertToType(firstRoot));
            roots.add(convertToType(secondRoot));
        } else if (Math.abs(discriminant) == 0) {
            double root = -b / (2.0 * a);
            roots.add(convertToType(root));
        }
        return roots;
    }

    public T findExtremum() {
        double extremumY = a * (extremumPoint * extremumPoint) + (b * extremumPoint) + c;
        return convertToType(extremumY);
    }

    public StringBuilder findMinMaxInterval() {
        StringBuilder builder = new StringBuilder();
        if (a > 0) {
            builder.append("Interval of decrease: from negative infinity to the ")
                    .append(extremumPoint)
                    .append("\nInterval of increase: from the ")
                    .append(extremumPoint)
                    .append(" to positive infinity");
        } else {
            builder.append("Interval of increase: from negative infinity to the ")
                    .append(extremumPoint)
                    .append("\nInterval of decrease: from the ")
                    .append(extremumPoint)
                    .append(" to positive infinity");
        }
        return builder;
    }
}
