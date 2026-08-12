package QuadraticEquation;

import QuadraticEquation.typesOfEquation.ComplexEquation;
import QuadraticEquation.typesOfEquation.FractionalEquation;
import QuadraticEquation.typesOfEquation.QuadraticEquation;

public class Main {
    static void main(String[] args) {
        QuadraticEquation quadraticEquation = new QuadraticEquation("-2", "8", "-3");
        System.out.println(quadraticEquation);
        System.out.println(quadraticEquation.findRoot());
        System.out.println(quadraticEquation.findExtremum());
        System.out.println(quadraticEquation.findMinMaxInterval());
        System.out.println(quadraticEquation.findDiscriminant());

        ComplexEquation complex = new ComplexEquation("1", "0", "1");
        System.out.println(complex);
        System.out.println(complex.findRoot());

        QuadraticEquation quadraticEquation2 = new QuadraticEquation("1", "0", "1");
        System.out.println(quadraticEquation2);
        System.out.println(quadraticEquation2.findRoot());

        FractionalEquation fractional = new FractionalEquation("0.5F","-0.75F","0.25F");
        System.out.println(fractional);
        System.out.println(fractional.findRoot());
    }
}
