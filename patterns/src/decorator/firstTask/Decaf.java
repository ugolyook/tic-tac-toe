package decorator.firstTask;

public class Decaf extends Beverage {
    public Decaf() {
        description = "Coffee without coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
