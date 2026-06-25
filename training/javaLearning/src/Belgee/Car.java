package Belgee;

public class Car {
    private final int id;
    private final String lineName;

    public Car(String lineName,int id) {
        this.id = id;
        this.lineName = lineName;
    }

    public int getId() {
        return id;
    }

    public String getLineName() {
        return lineName;
    }
}
