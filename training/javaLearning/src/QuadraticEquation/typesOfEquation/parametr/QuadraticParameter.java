package QuadraticEquation.typesOfEquation.parametr;

public abstract class QuadraticParameter {
    protected double value;

    public QuadraticParameter(double value) {
        this.value = value;
    }

    public QuadraticParameter() {
        this.value = 0;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

