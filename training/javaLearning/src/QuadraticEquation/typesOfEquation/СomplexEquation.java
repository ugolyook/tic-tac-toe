package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.ComplexParameter;
import QuadraticEquation.typesOfEquation.root.ComplexRoot;
import QuadraticEquation.typesOfEquation.root.Root;

public class СomplexEquation extends BaseQuadraticEquation<ComplexParameter> {
    public СomplexEquation(ComplexParameter a, ComplexParameter b, ComplexParameter c) {
        super(a, b, c);
    }

    @Override
    protected Root<ComplexParameter> createRealRoot(ComplexParameter value) {
        return new ComplexRoot<>(value, new ComplexParameter(0, 0));
    }

    @Override
    protected Root<ComplexParameter> createComplexRoot(ComplexParameter realPart, ComplexParameter imaginaryPart) {
        return new ComplexRoot<>(realPart,imaginaryPart);
    }

    @Override
    public Coordinate<ComplexParameter> findExtremum() {
        throw new UnsupportedOperationException(
                "Extremum cannot be found for a complex equation"
        );
    }

    @Override
    public Interval findMinMaxInterval() {
        throw new UnsupportedOperationException(
                "Intervals of increase and decrease cannot be found for a complex equation"
        );
    }

    @Override
    public String toString() {
        return String.format("%sx^2 + %sx + %s = 0", a, b, c);
    }
}
