package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.FractionalParameter;
import QuadraticEquation.typesOfEquation.root.ComplexRoot;
import QuadraticEquation.typesOfEquation.root.FractionalRoot;
import QuadraticEquation.typesOfEquation.root.Root;

public class FractionalEquation extends BaseQuadraticEquation<FractionalParameter> {
    public FractionalEquation(FractionalParameter a, FractionalParameter b, FractionalParameter c) {
        super(a, b, c);
    }

    @Override
    protected Root<FractionalParameter> createRealRoot(FractionalParameter value) {
        return new FractionalRoot(value);
    }

    @Override
    protected Root<FractionalParameter> createComplexRoot(
            FractionalParameter realPart,
            FractionalParameter imaginaryPart) {

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
