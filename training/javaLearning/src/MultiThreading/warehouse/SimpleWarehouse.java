package MultiThreading.warehouse;

import MultiThreading.domain.Auto;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleWarehouse implements Warehouse {
    private final Queue<Auto> stock = new LinkedList<>();
    private final int capacity;

    public SimpleWarehouse(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public synchronized void put(Auto auto) throws InterruptedException {
        while (stock.size() >= capacity) {
            System.out.println("Warehouse is full " + Thread.currentThread().getName() + "waiting...");
            wait();
        }

        stock.offer(auto);
        System.out.printf("Warehouse + %s. Warehouse: %d/%d%n", auto, stock.size(), capacity);
        notifyAll();
    }

    @Override
    public synchronized Auto take() throws InterruptedException {
        while (stock.isEmpty()) {
            System.out.println("Warehouse is empty" + Thread.currentThread().getName() + "is waiting...");
            wait();
        }

        Auto auto = stock.poll();
        System.out.printf("Warehouse - %s. Warehouse: %d/%d%n", auto, stock.size(), capacity);
        notifyAll();
        return auto;
    }

    @Override
    public int getStockCount() {
        return stock.size();
    }
}
