package QuadraticEquation.typesOfEquation;

import QuadraticEquation.BaseQuadraticEquation;

import java.util.ArrayList;

public class ComplexNumbersEquation extends BaseQuadraticEquation<String> {
    private final String a;
    private final String b;
    private final String c;


    public ComplexNumbersEquation(String a, String b, String c) {
        super(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    protected String convertToType(double value) {
        return String.valueOf(value);
    }

    public ArrayList<String> FindRoot() {
        double discriminant = super.b * super.b - 4 * super.a * super.c;

        ArrayList<String> roots = new ArrayList<>();
        if (discriminant < 0) {
            double realPart = -super.b / (2.0 * super.a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2.0 * super.a);

            if (realPart == 0) {
                roots.add(imaginaryPart + "i");
                roots.add("-" + imaginaryPart + "i");
            } else if (imaginaryPart > 0) {
                roots.add(realPart + " + " + imaginaryPart + "i");
                roots.add(realPart + " - " + imaginaryPart + "i");
            } else {
                roots.add(realPart + " + " + Math.abs(imaginaryPart) + "i");
                roots.add(realPart + " - " + Math.abs(imaginaryPart) + "i");
            }
        } else {
            return super.FindRoot();
        }

        return roots;
    }

    @Override
    public String toString() {
        return String.format("%sx^2 + %sx + %s = 0", a, b, c);
    }
}
