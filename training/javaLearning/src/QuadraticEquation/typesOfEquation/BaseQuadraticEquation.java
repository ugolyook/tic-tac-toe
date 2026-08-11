package QuadraticEquation.typesOfEquation;

import QuadraticEquation.parameter.QuadraticParameter;
import QuadraticEquation.root.Root;

import java.util.ArrayList;

import static QuadraticEquation.Parsing.fromStringToInt;

public abstract class BaseQuadraticEquation {
    protected QuadraticParameter a;
    protected QuadraticParameter b;
    protected QuadraticParameter c;
    protected QuadraticParameter extremumPoint;

    protected BaseQuadraticEquation(QuadraticParameter a, QuadraticParameter b, QuadraticParameter c) {
        this.a = fromStringToInt(a);
        this.b = fromStringToInt(b);
        this.c = fromStringToInt(c);
        if (this.a == 0) {
            throw new IllegalArgumentException("Error, a equals 0!!! It's not quadratic equation.");
        }
        this.extremumPoint = -this.b / (2.0 * this.a);
    }

    public abstract void findDiscriminant();

    protected abstract T convertToType(double value);

    public ArrayList<Root> findRoot() {

        double discriminant = b * b - 4 * a * c;
        ArrayList<T> roots = new ArrayList<>();

        if (discriminant > 0) {
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            roots.add(convertToType(firstRoot));
            roots.add(RealRoot());
        } else if (Math.abs(discriminant) == 0) {
            double root = -b / (2.0 * a);
            roots.add(convertToType(root));
        } else if (discriminant < 0) {
            double realPart = -super.b / (2.0 * super.a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2.0 * super.a);
            new ComplexRoot(realPart, imaginaryPart)
        }
        return roots;
    }

    public Coordinate findExtremum() {
        double extremumY = a * (extremumPoint * extremumPoint) + (b * extremumPoint) + c;
        return convertToType(extremumY);
    }

    public Interval findMinMaxInterval() {
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
