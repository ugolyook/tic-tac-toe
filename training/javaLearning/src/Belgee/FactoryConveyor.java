package Belgee;

import java.util.concurrent.atomic.AtomicInteger;

public class FactoryConveyor {
    private final int productionDelay;
    private final String name;
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    public FactoryConveyor(int productionDelay, String name) {
        this.productionDelay = productionDelay;
        this.name = name;
    }

    private Car buildCar() {
        return new Car(name, idGenerator.incrementAndGet());
    }

    public Car buildOneCar() throws InterruptedException {
        Thread.sleep(productionDelay);
        return buildCar();
    }

}
