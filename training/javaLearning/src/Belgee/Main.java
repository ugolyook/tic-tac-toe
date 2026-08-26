package Belgee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() throws InterruptedException {
        FactoryConveyor factory1 = new FactoryConveyor(500, "Belgee");
        FactoryConveyor factory2 = new FactoryConveyor(250, "BMW");

        Scanner scanner = new Scanner(System.in);

        Warehouse warehouse = new Warehouse(5);
        Dealer dealer = new Dealer();

        List<Thread> threads = new ArrayList<>();
        Main main = new Main();

        Thread producer1Thread = main.getProducerThread(warehouse, factory1);
        Thread producer2Thread = main.getProducerThread(warehouse, factory2);

        Thread consumerThread = getConsumerThread(warehouse, dealer);

        threads.add(producer1Thread);
        threads.add(producer2Thread);
        threads.add(consumerThread);

        producer1Thread.start();
        producer2Thread.start();
        consumerThread.start();

        for (var thread : threads) {
            thread.join();
        }

        System.out.println(warehouse.getStockCount());
        scanner.close();
    }

    private static Thread getConsumerThread(Warehouse warehouse, Dealer dealer) {
        return new Thread(() -> {
            while (true) {
                if (warehouse.getStockCount() > 0) {
                    try {
                        dealer.boughtCar(warehouse);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Dealer is sleeping..");
                }
            }
        });
    }

    private Thread getProducerThread(Warehouse warehouse, FactoryConveyor factory) {
        return new Thread(() -> {
            System.out.println("New thread was started!");
            do {
                synchronized (this) {
                    if (warehouse.getStockCount() < warehouse.getCapacity()) {
                        Car car;
                        try {
                            car = factory.buildOneCar();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        warehouse.put(car);
                    }
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("Factory is sleeping..");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (true);
        });
    }
}
