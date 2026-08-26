package Belgee;

import java.util.LinkedList;
import java.util.Queue;

public class Warehouse implements WarehouseBelgee.Warehouse {
    private final int capacity;
    private final Queue<Car> store = new LinkedList<>();

    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void put(Car car) {
        if (store.size() >= capacity) {
            throw new RuntimeException("Warehouse is full, wait...");
        }
        store.add(car);
        System.out.println("Warehouse add car..");
    }

    @Override
    public Car take() {
        if (store.isEmpty() ) {
            throw new RuntimeException("Warehouse is empty, wait, please...");
        }
        Car car = store.poll();
        System.out.println("Auto is taken from warehouse");
        return car;
    }

    @Override
    public int getStockCount() {
        return store.size();
    }
    public int getCapacity(){
        return capacity;
    }
}
