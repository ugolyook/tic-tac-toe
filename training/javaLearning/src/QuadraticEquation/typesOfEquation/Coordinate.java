package QuadraticEquation.typesOfEquation;

import QuadraticEquation.typesOfEquation.parametr.RealParameter;

public class Coordinate {
    private final RealParameter x;
    private final RealParameter y;

    public Coordinate(RealParameter x, RealParameter y) {
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
