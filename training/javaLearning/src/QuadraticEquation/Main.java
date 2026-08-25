package QuadraticEquation;

import QuadraticEquation.typesOfEquation.FractionalEquation;
import QuadraticEquation.typesOfEquation.RealEquation;
import QuadraticEquation.typesOfEquation.parametr.ComplexParameter;
import QuadraticEquation.typesOfEquation.parametr.FractionalParameter;
import QuadraticEquation.typesOfEquation.parametr.RealParameter;
import QuadraticEquation.typesOfEquation.СomplexEquation;

public class Main {
    static void main(String[] args) {
        RealEquation quadraticEquation =
                new RealEquation(
                        new RealParameter(-2),
                        new RealParameter(8),
                        new RealParameter(-3)
                );

        System.out.println(quadraticEquation);
        System.out.println(quadraticEquation.findRoot());
        System.out.println(quadraticEquation.findExtremum());
        System.out.println(quadraticEquation.findMinMaxInterval());
        System.out.println(quadraticEquation.findDiscriminant());

        RealEquation quadraticEquation2 =
                new RealEquation(
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

        СomplexEquation equation1 = new СomplexEquation(
                new ComplexParameter(1, 1),
                new ComplexParameter(2, -1),
                new ComplexParameter(1, 2)
        );

        System.out.println("Equation 1:");
        System.out.println(equation1);
        System.out.println("Discriminant: " + equation1.findDiscriminant());
        System.out.println("Roots: " + equation1.findRoot());

        // 2. Уравнение x² + 1 = 0
        // Корни: i и -i
        СomplexEquation equation2 = new СomplexEquation(
                new ComplexParameter(1, 0),
                new ComplexParameter(0, 0),
                new ComplexParameter(1, 0)
        );

        System.out.println("\nEquation 2:");
        System.out.println(equation2);
        System.out.println("Discriminant: " + equation2.findDiscriminant());
        System.out.println("Roots: " + equation2.findRoot());

        // 3. Уравнение x² - 4x + 3 = 0
        // Корни: 1 и 3
        СomplexEquation equation3 = new СomplexEquation(
                new ComplexParameter(1, 0),
                new ComplexParameter(-4, 0),
                new ComplexParameter(3, 0)
        );

        System.out.println("\nEquation 3:");
        System.out.println(equation3);
        System.out.println("Discriminant: " + equation3.findDiscriminant());
        System.out.println("Roots: " + equation3.findRoot());

        // 4. Проверка ошибки экстремума
        try {
            System.out.println("\nTrying to find extremum:");
            System.out.println(equation2.findExtremum());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 5. Проверка ошибки интервалов
        try {
            System.out.println("\nTrying to find intervals:");
            System.out.println(equation2.findMinMaxInterval());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
