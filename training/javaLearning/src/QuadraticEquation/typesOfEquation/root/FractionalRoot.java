package QuadraticEquation.typesOfEquation.root;

import QuadraticEquation.typesOfEquation.parametr.FractionalParameter;

public class FractionalRoot extends Root<FractionalParameter> {
    public FractionalRoot(FractionalParameter value) {
        super(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
