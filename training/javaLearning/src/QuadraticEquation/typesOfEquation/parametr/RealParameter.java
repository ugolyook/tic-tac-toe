package QuadraticEquation.typesOfEquation.parametr;

public class RealParameter implements QuadraticParameter<RealParameter> {
    int value;

    public RealParameter(int value) {
        this.value = value;
    }

    @Override
    public RealParameter mult(RealParameter a) {
        return new RealParameter(value * a.value);
    }

    @Override
    public RealParameter mult(int a) {
        return null;
    }

    @Override
    public RealParameter sub(RealParameter a) {
        return null;
    }

    @Override
    public RealParameter sum(RealParameter a) {
        return null;
    }
}
