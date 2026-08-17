package QuadraticEquation.typesOfEquation;

public class Interval {
    private final String first;
    private final String second;

    public Interval(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}
