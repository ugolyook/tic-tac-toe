package MultiThreading.warehouse;

import MultiThreading.domain.Auto;

public interface Warehouse {
    void put(Auto auto) throws InterruptedException;

    Auto take() throws InterruptedException;

    int getStockCount();
}
