package QuadraticEquation.typesOfEquation;

import java.util.ArrayList;

public class ComplexNumbersEquation extends BaseQuadraticEquation<String> {

    public ComplexNumbersEquation(String a, String b, String c) {
        super(a, b, c);
    }

    @Override
    protected String convertToType(double value) {
        return String.valueOf(value);
    }
}
