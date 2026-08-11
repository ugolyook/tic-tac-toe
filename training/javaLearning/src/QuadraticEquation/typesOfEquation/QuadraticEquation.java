package QuadraticEquation.typesOfEquation;

import QuadraticEquation.parameter.RealParameter;

public class QuadraticEquation extends BaseQuadraticEquation {
    public QuadraticEquation(RealParameter a, RealParameter b, RealParameter c) {
        super(a, b, c);
    }


    @Override
    public String toString() {
        return String.format("%sx^2 + %sx + %s = 0", a, b, c);
    }
}
