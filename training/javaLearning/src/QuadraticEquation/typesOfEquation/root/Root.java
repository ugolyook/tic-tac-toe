package QuadraticEquation.typesOfEquation.root;

public abstract class Root<T> {

    protected final T value;

    protected Root(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
