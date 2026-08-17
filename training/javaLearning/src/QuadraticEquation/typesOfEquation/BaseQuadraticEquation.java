package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.QuadraticParameter;
import QuadraticEquation.typesOfEquation.root.ComplexRoot;
import QuadraticEquation.typesOfEquation.root.Root;

import java.util.ArrayList;

public abstract class BaseQuadraticEquation<T extends QuadraticParameter> {
    protected T a;
    protected T b;
    protected T c;

    public BaseQuadraticEquation(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a==0) {
            throw new IllegalArgumentException("Error, a equals 0!!! It's not quadratic equation.");
        }
    }

    public abstract T findDiscriminant();

    public abstract ArrayList<Root> findRoot();

    public abstract Coordinate findExtremum();

    public abstract Interval findMinMaxInterval();
}
