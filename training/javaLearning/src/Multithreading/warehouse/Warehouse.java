package Multithreading.warehouse;

import Multithreading.domain.Auto;

public interface Warehouse {
    void put(Auto auto) throws InterruptedException;

    Auto take() throws InterruptedException;

    int getStockCount();
}
