package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.RealParameter;
import QuadraticEquation.typesOfEquation.root.ComplexRoot;
import QuadraticEquation.typesOfEquation.root.RealRoot;
import QuadraticEquation.typesOfEquation.root.Root;

public class QuadraticEquation extends BaseQuadraticEquation<RealParameter> {
    public QuadraticEquation(RealParameter a, RealParameter b, RealParameter c) {
        super(a, b, c);
    }

    @Override
    protected Root<RealParameter> createRealRoot(RealParameter value) {
        return new RealRoot(value);
    }

    @Override
    protected Root<RealParameter> createComplexRoot(
            RealParameter realPart,
            RealParameter imaginaryPart) {

        return new ComplexRoot<>(
                realPart,
                imaginaryPart
        );
    }

    @Override
    public String toString() {
        return String.format("%sx^2 + %sx + %s = 0", a, b, c);
    }
}
