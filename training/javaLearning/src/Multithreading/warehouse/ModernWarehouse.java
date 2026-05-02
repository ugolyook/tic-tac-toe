package Multithreading.warehouse;

import Multithreading.domain.Auto;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ModernWarehouse implements Warehouse {
    private final BlockingQueue<Auto> stock;
    private final int capacity;

    public ModernWarehouse(int capacity) {
        this.stock = new ArrayBlockingQueue<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public void put(Auto auto) throws InterruptedException {
        stock.put(auto);
        System.out.printf("Warehouse + %s. Warehouse: %d/%d%n", auto, stock.size(), capacity);
    }

    @Override
    public Auto take() throws InterruptedException {
        Auto auto = stock.take();
        System.out.printf("Warehouse + %s. Warehouse: %d/%d%n", auto, stock.size(), capacity);
        return auto;
    }

    @Override
    public int getStockCount() {
        return stock.size();
    }
}
