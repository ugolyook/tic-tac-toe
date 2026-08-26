package MultiThreading.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Auto {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final int id;
    private final String lineName;

    public Auto(String lineName) {
        this.id = counter.incrementAndGet();
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
