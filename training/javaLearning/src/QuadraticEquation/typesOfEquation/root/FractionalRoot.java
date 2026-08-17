package QuadraticEquation.typesOfEquation.root;

import QuadraticEquation.typesOfEquation.parametr.FractionalParameter;

public class FractionalRoot extends Root<FractionalParameter>{
    protected FractionalRoot(FractionalParameter value) {
        super(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
