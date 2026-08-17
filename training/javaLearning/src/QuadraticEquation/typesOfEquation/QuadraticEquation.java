package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.RealParameter;
import QuadraticEquation.typesOfEquation.root.ComplexRoot;
import QuadraticEquation.typesOfEquation.root.RealRoot;
import QuadraticEquation.typesOfEquation.root.Root;

import java.util.ArrayList;

public class QuadraticEquation extends BaseQuadraticEquation<RealParameter> {
    public QuadraticEquation(RealParameter a, RealParameter b, RealParameter c) {
        super(a, b, c);
    }

    @Override
    public RealParameter findDiscriminant() {
        RealParameter squB = b.mult(b);
        RealParameter squAC = a.mult(c);
        RealParameter squ4AC = squAC.mult(4);
        return squB.sub(squ4AC);
    }

    @Override
    public ArrayList<Root> findRoot() {
        RealParameter discrim = findDiscriminant();

        ArrayList<Root> roots = new ArrayList<>();
        if (discrim.getValue() > 0) {
            RealParameter sqrtDiscr = discrim.sqrt();

            RealParameter denominator = a.mult(2);
            RealParameter firstRoot = b.negate().sum(sqrtDiscr).div(denominator);
            RealParameter secondRoot = b.negate().sub(sqrtDiscr).div(denominator);

            roots.add(new RealRoot(firstRoot));
            roots.add(new RealRoot(secondRoot));
        } else if (discrim.getValue() == 0) {
            RealParameter denominator = a.mult(2);
            RealParameter root = b.negate().div(denominator);

            roots.add(new RealRoot(root));
        } else if (discrim.getValue() < 0) {
            RealParameter sqrtDiscr = discrim.negate().sqrt();
            RealParameter denominator = a.mult(2);

            RealParameter realPart = b.negate().div(denominator);
            RealParameter imaginaryPart = sqrtDiscr.div(denominator);

            roots.add(new ComplexRoot(realPart, imaginaryPart));
            roots.add(new ComplexRoot(realPart, imaginaryPart.negate()));
        }
        return roots;
    }

    @Override
    public Coordinate findExtremum() {
        RealParameter denominator = a.mult(2);

        RealParameter x = b.negate().div(denominator);

        RealParameter xSquared = x.mult(x);

        RealParameter axSquared = a.mult(xSquared);

        RealParameter bx = b.mult(x);

        RealParameter y = axSquared.sum(bx).sum(c);

        return new Coordinate(x, y);
    }

    @Override
    public Interval findMinMaxInterval() {
        RealParameter extremumPoint =
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
