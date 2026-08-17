package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.FractionalParameter;
import QuadraticEquation.typesOfEquation.root.ComplexRoot;
import QuadraticEquation.typesOfEquation.root.FractionalRoot;
import QuadraticEquation.typesOfEquation.root.RealRoot;
import QuadraticEquation.typesOfEquation.root.Root;

import java.util.ArrayList;

public class FractionalEquation extends BaseQuadraticEquation<FractionalParameter> {
    public FractionalEquation(FractionalParameter a, FractionalParameter b, FractionalParameter c) {
        super(a, b, c);
    }

    @Override
    public String toString() {
        return String.format("%sx^2 + %sx + %s = 0", a, b, c);
    }

    @Override
    public FractionalParameter findDiscriminant() {
        FractionalParameter squB = b.mult(b);
        FractionalParameter squAC = a.mult(c);
        FractionalParameter squ4AC = squAC.mult(4);
        return squB.sub(squ4AC);
    }

    @Override
    public ArrayList<Root> findRoot() {

        FractionalParameter discrim = findDiscriminant();

        ArrayList<Root> roots = new ArrayList<>();

        if (discrim.getValue() > 0) {

            FractionalParameter sqrtDiscr = discrim.sqrt();

            FractionalParameter denominator = a.mult(2);

            FractionalParameter firstRoot =
                    b.negate()
                            .sum(sqrtDiscr)
                            .div(denominator);

            FractionalParameter secondRoot =
                    b.negate()
                            .sub(sqrtDiscr)
                            .div(denominator);

            roots.add(new FractionalRoot(firstRoot));
            roots.add(new RealRoot(secondRoot));

        } else if (discrim.getValue() == 0) {

            FractionalParameter denominator = a.mult(2);

            FractionalParameter root =
                    b.negate()
                            .div(denominator);

            roots.add(new RealRoot(root));

        } else {
            FractionalParameter sqrtDiscr =
                    discrim.negate().sqrt();

            FractionalParameter denominator =
                    a.mult(2);

            FractionalParameter realPart =
                    b.negate().div(denominator);

            FractionalParameter imaginaryPart =
                    sqrtDiscr.div(denominator);

            roots.add(new ComplexRoot(realPart, imaginaryPart));
            roots.add(new ComplexRoot(realPart, imaginaryPart.negate()));
        }

        return roots;
    }

    @Override
    public Coordinate findExtremum() {
        FractionalParameter denominator = a.mult(2);

        FractionalParameter x = b.negate().div(denominator);

        FractionalParameter xSquared = x.mult(x);

        FractionalParameter axSquared = a.mult(xSquared);

        FractionalParameter bx = b.mult(x);

        FractionalParameter y = axSquared.sum(bx).sum(c);

        return new Coordinate(x, y);
    }

    @Override
    public Interval findMinMaxInterval() {
        FractionalParameter extremumPoint =
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
}
