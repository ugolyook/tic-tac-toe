package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.RealParameter;

public class QuadraticEquation extends BaseQuadraticEquation<RealParameter> {
    private RealParameter a;
    private RealParameter b;
    private RealParameter c;

    public QuadraticEquation(RealParameter a, RealParameter b, RealParameter c) {
        super(a, b, c);
    }

    @Override
    public RealParameter findDiscriminant() {
       RealParameter squB = b.multiplication(b);
       RealParameter squAC = a.multiplication(a,c);
       RealParameter squ4AC = a.multiplication(squAC,4);
        return a.subtraction(squB,squ4AC);
    }
}
