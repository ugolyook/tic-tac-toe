package QuadraticEquation.typesOfEquation.root;

import QuadraticEquation.typesOfEquation.parametr.RealParameter;

public class RealRoot extends Root<RealParameter> {
    public RealRoot(RealParameter value) {
       super(value);
    }

    public RealParameter getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
