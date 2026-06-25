package Belgee;

public interface WarehouseBelgee {
    public interface Warehouse {
        void put(Car car) throws InterruptedException;

        Car take() throws InterruptedException;

        int getStockCount();
    }
}
