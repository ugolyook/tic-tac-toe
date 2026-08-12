package QuadraticEquation.typesOfEquation.parametr;

public interface QuadraticParameter<T extends QuadraticParameter<?>> {

    T mult(T a);

    T mult(int a);

    T sub(T a);

    T sum(T a);
}

