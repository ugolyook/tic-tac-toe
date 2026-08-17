package QuadraticEquation.typesOfEquation.parametr;

public class FractionalParameter implements QuadraticParameter<FractionalParameter> {
    int numerator;
    int denominator;

    public FractionalParameter(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), denominator);

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private int gcd(int numerator, int denominator) {
        while (denominator != 0) {
            int temp = denominator;
            denominator = numerator % denominator;
            numerator = temp;
        }
        return numerator;
    }

    public double getValue() {
        return (double) numerator / denominator;
    }

    @Override
    public FractionalParameter mult(FractionalParameter a) {
        return new FractionalParameter(
                numerator * a.numerator,
                denominator * a.denominator
        );
    }

    @Override
    public FractionalParameter mult(int a) {
        return new FractionalParameter(
                numerator * a,
                denominator
        );
    }

    @Override
    public FractionalParameter sub(FractionalParameter a) {
        return new FractionalParameter(
                numerator * a.denominator - a.numerator * denominator,
                denominator * a.denominator
        );
    }

    @Override
    public FractionalParameter sum(FractionalParameter a) {
        return new FractionalParameter(
                numerator * a.denominator + a.numerator * denominator,
                denominator * a.denominator
        );
    }

    @Override
    public FractionalParameter sqrt() {
        return new FractionalParameter(
                (int) Math.sqrt(numerator),
                (int) Math.sqrt(denominator)
        );
    }

    @Override
    public FractionalParameter div(FractionalParameter a) {
        return new FractionalParameter(
                numerator * a.denominator,
                denominator * a.numerator
        );
    }

    @Override
    public FractionalParameter negate() {
        return new FractionalParameter(-numerator, denominator);
    }

    @Override
    public String toString() {
        return "FractionalParameter{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
