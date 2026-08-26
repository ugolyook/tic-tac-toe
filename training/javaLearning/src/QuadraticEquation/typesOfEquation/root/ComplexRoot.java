package QuadraticEquation.typesOfEquation.root;

public class ComplexRoot<T> extends Root<T>{
    private final T realPart;
    private final T imaginaryPart;

    public ComplexRoot(T realPart, T imaginaryPart) {
        super(realPart);
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }
}
