package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.RealParameter;

public class Coordinate<T> {
    private T x;
    private T y;

    public Coordinate(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
