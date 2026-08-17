package QuadraticEquation.typesOfEquation.parametr;

public class RealParameter implements QuadraticParameter<RealParameter> {
    int value;

    public RealParameter(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public RealParameter mult(RealParameter a) {
        return new RealParameter(value * a.value);
    }

    @Override
    public RealParameter mult(int a) {
        return new RealParameter(value * a);
    }

    @Override
    public RealParameter sub(RealParameter a) {
        return new RealParameter(value - a.value);
    }

    @Override
    public RealParameter sum(RealParameter a) {
        return new RealParameter(value + a.value);
    }

    @Override
    public RealParameter sqrt() {
        return new RealParameter((int) Math.sqrt(value));
    }

    @Override
    public RealParameter div(RealParameter a) {
        return new RealParameter(value / a.value);
    }

    @Override
    public RealParameter negate() {
        return new RealParameter(-value);
    }

}
