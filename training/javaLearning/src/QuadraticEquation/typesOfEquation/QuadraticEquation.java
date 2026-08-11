package QuadraticEquation.typesOfEquation;

import QuadraticEquation.BaseQuadraticEquation;

public class QuadraticEquation extends BaseQuadraticEquation<Double> {
    private final String a;
    private final String b;
    private final String c;

    public QuadraticEquation(String a, String b, String c) {
        super(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    protected Double convertToType(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%sx^2 + %sx + %s = 0", a, b, c);
    }
}
