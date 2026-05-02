package Multithreading.components;

import Multithreading.domain.Auto;
import Multithreading.warehouse.Warehouse;

public class FactoryConveyor implements Runnable {
    private final Warehouse warehouse;
    private final int productionDelay;
    private final String name;
    private volatile boolean running = true;

    public FactoryConveyor(Warehouse warehouse, int productionDelay, String name) {
        this.warehouse = warehouse;
        this.productionDelay = productionDelay;
        this.name = name;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        int producedCount = 0;
        while(running && !Thread.currentThread().isInterrupted()){
            try{
                Thread.sleep(productionDelay);

                Auto auto = new Auto(name);
            } catch (InterruptedException e){
                System.out.println(name + " interrupted. Machines produced: " + producedCount);
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println(name + " stop working. Produced: " + producedCount);
    }
}
