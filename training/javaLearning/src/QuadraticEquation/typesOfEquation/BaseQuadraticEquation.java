package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.QuadraticParameter;
import QuadraticEquation.typesOfEquation.parametr.RealParameter;
import QuadraticEquation.typesOfEquation.root.ComplexRoot;
import QuadraticEquation.typesOfEquation.root.RealRoot;
import QuadraticEquation.typesOfEquation.root.Root;

import java.util.ArrayList;

public abstract class BaseQuadraticEquation<T extends QuadraticParameter<T>> {
    protected T a;
    protected T b;
    protected T c;

    public BaseQuadraticEquation(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a.isZero()) {
            throw new IllegalArgumentException("Error, a equals 0!!! It's not quadratic equation.");
        }
    }

    public T findDiscriminant() {
        T squB = b.mult(b);
        T squAC = a.mult(c);
        T squ4AC = squAC.mult(4);
        return squB.sub(squ4AC);
    }

    public ArrayList<Root<T>> findRoot() {
        T discrim = findDiscriminant();

        ArrayList<Root<T>> roots = new ArrayList<>();
        if (discrim.getValue() > 0) {
            T sqrtDiscr = discrim.sqrt();

            T denominator = a.mult(2);
            T firstRoot = b.negate().sum(sqrtDiscr).div(denominator);
            T secondRoot = b.negate().sub(sqrtDiscr).div(denominator);

            roots.add(createRealRoot(firstRoot));
            roots.add(createRealRoot(secondRoot));
        } else if (discrim.getValue() == 0) {
            T denominator = a.mult(2);
            T root = b.negate().div(denominator);

            roots.add(createRealRoot(root));
        } else if (discrim.getValue() < 0) {
            T sqrtDiscr = discrim.negate().sqrt();
            T denominator = a.mult(2);

            T realPart = b.negate().div(denominator);
            T imaginaryPart = sqrtDiscr.div(denominator);

            roots.add(createComplexRoot(realPart, imaginaryPart));
            roots.add(createComplexRoot(realPart, imaginaryPart.negate()));
        }
        return roots;
    }

    public Coordinate<T> findExtremum() {
        T denominator = a.mult(2);

        T x = b.negate().div(denominator);

        T xSquared = x.mult(x);

        T axSquared = a.mult(xSquared);

        T bx = b.mult(x);

        T y = axSquared.sum(bx).sum(c);

        return new Coordinate(x, y);
    }

    public Interval findMinMaxInterval() {
        T extremumPoint =
                b.negate().div(a.mult(2));

        if (a.getValue() > 0) {

            return new Interval(
                    "Interval of decrease: (-∞; " + extremumPoint + ")",
                    "Interval of increase: (" + extremumPoint + "; +∞)"
            );

        } else {

            return new Interval(
                    "Interval of increase: (-∞; " + extremumPoint + ")",
                    "Interval of decrease: (" + extremumPoint + "; +∞)"
            );
        }
    }

    protected abstract Root<T> createRealRoot(T value);

    protected abstract Root<T> createComplexRoot(T realPart, T imaginaryPart);
}

