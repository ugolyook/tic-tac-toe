package Multithreading.warehouse;

import Multithreading.domain.Auto;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class SemaphoreWarehouse implements Warehouse {
    private final ConcurrentLinkedQueue<Auto> stock = new ConcurrentLinkedQueue<>();
    private final Semaphore emptySlots;
    private final Semaphore filledSlots;
    private final int capacity;

    public SemaphoreWarehouse(int capacity) {
        this.emptySlots = new Semaphore(capacity);
        this.filledSlots = new Semaphore(0);
        this.capacity = capacity;
    }

    @Override
    public void put(Auto auto) throws InterruptedException {
        emptySlots.acquire();

        stock.offer(auto);
        System.out.printf("Warehouse + %s. Warehouse: %d/%d%n", auto, stock.size(), capacity);

        filledSlots.release();
    }

    @Override
    public Auto take() throws InterruptedException {
        filledSlots.acquire();

        Auto auto = stock.poll();
        System.out.printf("Warehouse + %s. Warehouse: %d/%d%n", auto, stock.size(), capacity);

        emptySlots.release();
        return auto;
    }

    @Override
    public int getStockCount() {
        return stock.size();
    }
}
