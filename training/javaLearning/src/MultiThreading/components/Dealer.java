package MultiThreading.components;

import MultiThreading.domain.Auto;
import MultiThreading.warehouse.Warehouse;

public class Dealer implements Runnable {
    private final Warehouse warehouse;
    private final int purchaseDelay;
    private final String name;
    private volatile boolean running = true;

    public Dealer(Warehouse warehouse, int purchaseDelay, String name) {
        this.warehouse = warehouse;
        this.purchaseDelay = purchaseDelay;
        this.name = name;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        int purchasedCount = 0;
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Auto auto = new Auto(name);

                Thread.sleep(purchaseDelay);
                purchasedCount++;
                System.out.printf("[%s] buy %s. Total purchased: %d%n", name, auto, purchasedCount);

            } catch (InterruptedException e) {
                System.out.println(name + " interrupted. Purchased: " + purchasedCount);
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println(name + " stop working. Purchased: " + purchasedCount);
    }
}
