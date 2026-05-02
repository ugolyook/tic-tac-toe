package Multithreading.domain;

public class Auto {
    private static int counter = 0;
    private final int id;
    private final String lineName;

    public Auto(String lineName) {
        this.id = ++counter;
        this.lineName = lineName;
    }

    public int getId() {
        return id;
    }

    public String getLineName() {
        return lineName;
    }

    @Override
    public String toString() {
        return "Auto #" + id + " (от " + lineName + ")";
    }
}
