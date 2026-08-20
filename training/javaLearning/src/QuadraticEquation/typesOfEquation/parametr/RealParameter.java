package QuadraticEquation.typesOfEquation.parametr;

public class RealParameter implements QuadraticParameter<RealParameter> {
    double value;

    public RealParameter(double value) {
        this.value = value;
    }

    public double getValue() {
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

    @Override
    public boolean isZero() {
        return value == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
