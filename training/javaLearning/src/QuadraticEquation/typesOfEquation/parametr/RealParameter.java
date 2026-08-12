package QuadraticEquation.typesOfEquation.parametr;

public class RealParameter extends QuadraticParameter {
    public RealParameter(double value) {
        super(value);
    }

    public RealParameter multiplication(RealParameter a, RealParameter b) {
        return new RealParameter(a.getValue() * b.getValue());
    }

    public RealParameter multiplication(RealParameter a, int b) {
        return new RealParameter(a.getValue() * b);
    }

    public RealParameter subtraction(RealParameter a, RealParameter b) {
        return new RealParameter(a.getValue() - b.getValue());
    }
}
