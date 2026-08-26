package QuadraticEquation.typesOfEquation.parametr;

public class ComplexParameter implements QuadraticParameter<ComplexParameter> {
    private double real;
    private double imaginary;

    public ComplexParameter(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public ComplexParameter mult(ComplexParameter a) {
        double newReal = real * a.real - imaginary * a.imaginary;
        double newImaginary = real * a.imaginary + imaginary * a.real;

        return new ComplexParameter(newReal, newImaginary);
    }

    @Override
    public ComplexParameter mult(int a) {
        return new ComplexParameter(
                real * a,
                imaginary * a
        );
    }

    @Override
    public ComplexParameter sub(ComplexParameter a) {
        return new ComplexParameter(
                real - a.real,
                imaginary - a.imaginary
        );
    }

    @Override
    public ComplexParameter sum(ComplexParameter a) {
        return new ComplexParameter(
                real + a.real,
                imaginary + a.imaginary
        );
    }

    @Override
    public ComplexParameter sqrt() {
        double modulus = Math.sqrt(real * real + imaginary * imaginary);

        double newReal = Math.sqrt((modulus + real) / 2);
        double newImaginary = Math.sqrt((modulus - real) / 2);

        if (imaginary < 0) {
            newImaginary = -newImaginary;
        }

        return new ComplexParameter(newReal, newImaginary);
    }

    @Override
    public ComplexParameter div(ComplexParameter a) {
        double denominator =
                a.real * a.real + a.imaginary * a.imaginary;

        double newReal =
                (real * a.real + imaginary * a.imaginary) / denominator;

        double newImaginary =
                (imaginary * a.real - real * a.imaginary) / denominator;

        return new ComplexParameter(newReal, newImaginary);
    }

    @Override
    public ComplexParameter negate() {
        return new ComplexParameter(
                -real,
                -imaginary
        );
    }

    @Override
    public boolean isZero() {
        return real == 0 && imaginary == 0;
    }

    @Override
    public double getValue() {
        return real;
    }

    @Override
    public String toString() {
        if (real == 0 && imaginary == 0) {
            return "0";
        }

        if (real == 0) {
            return imaginary + "i";
        }

        if (imaginary == 0) {
            return String.valueOf(real);
        }

        if (imaginary > 0) {
            return real + " + " + imaginary + "i";
        }

        return real + " - " + Math.abs(imaginary) + "i";
    }
}
