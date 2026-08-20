package QuadraticEquation;

import QuadraticEquation.typesOfEquation.FractionalEquation;
import QuadraticEquation.typesOfEquation.QuadraticEquation;
import QuadraticEquation.typesOfEquation.parametr.FractionalParameter;
import QuadraticEquation.typesOfEquation.parametr.RealParameter;

public class Main {
    static void main(String[] args) {
        QuadraticEquation quadraticEquation =
                new QuadraticEquation(
                        new RealParameter(-2),
                        new RealParameter(8),
                        new RealParameter(-3)
                );

        System.out.println(quadraticEquation);
        System.out.println(quadraticEquation.findRoot());
        System.out.println(quadraticEquation.findExtremum());
        System.out.println(quadraticEquation.findMinMaxInterval());
        System.out.println(quadraticEquation.findDiscriminant());

        QuadraticEquation quadraticEquation2 =
                new QuadraticEquation(
                        new RealParameter(1),
                        new RealParameter(0),
                        new RealParameter(1)
                );

        System.out.println(quadraticEquation2);
        System.out.println(quadraticEquation2.findRoot());

        FractionalEquation fractional =
                new FractionalEquation(
                        new FractionalParameter(1, 2),
                        new FractionalParameter(-3, 4),
                        new FractionalParameter(1, 4)
                );
        
        System.out.println(fractional);
        System.out.println(fractional.findRoot());
    }
}
