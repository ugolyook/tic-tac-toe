package MultiThreading.core;

import MultiThreading.components.Dealer;
import MultiThreading.components.FactoryConveyor;
import MultiThreading.warehouse.ModernWarehouse;
import MultiThreading.warehouse.SemaphoreWarehouse;
import MultiThreading.warehouse.SimpleWarehouse;
import MultiThreading.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private Warehouse warehouse;
    private List<FactoryConveyor> factories;
    private List<Dealer> dealers;
    private ExecutorService executorService;

    public Main(Warehouse warehouse) {
        this.warehouse = warehouse;
        this.factories = new ArrayList<>();
        this.dealers = new ArrayList<>();
        this.executorService = Executors.newFixedThreadPool(10);
    }

    private void setupSimulation(int factoryCount, int dealerCount, int factoryDelay, int dealerDelay) {
        for (int i = 1; i <= factoryCount; i++) {
            factories.add(new FactoryConveyor(warehouse, factoryDelay, "line:" + i));
        }

        String[] dealerNames = {"A", "B", "C", "D", "F"};
        for (int i = 0; i <= dealerCount; i++) {
            String name = i <= dealerNames.length ? dealerNames[i] : String.valueOf(i);
            dealers.add(new Dealer(warehouse, dealerDelay, "diller:" + name));
        }
    }

    private void startSimulation(int durationSeconds) {
        System.out.println("Start...");
        factories.forEach(executorService::submit);
        dealers.forEach(executorService::submit);

        Thread statsThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(3000);
                    System.out.println("Cars in the warehouse: " + warehouse.getStockCount());
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        statsThread.start();

        try {
            Thread.sleep(durationSeconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        stopSimulation();

        statsThread.interrupt();
        try {
            statsThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stopSimulation() {
        System.out.println("\nStop simulation....");

        factories.forEach(FactoryConveyor::stop);
        dealers.forEach(Dealer::stop);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("\n Simulation has finished!");
    }

    public static void main(String[] args) {
        System.out.println("\nSimple Warehouse: ");
        Main sim1 = new Main(new SimpleWarehouse(10));
        sim1.setupSimulation(3, 2, 2000, 3000);
        sim1.startSimulation(20);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nSemaphore warehouse: ");
        Main sim2 = new Main(new SemaphoreWarehouse(10));
        sim2.setupSimulation(3, 2, 2000, 3000);
        sim2.startSimulation(20);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nModern warehouse: ");
        Main sim3 = new Main(new ModernWarehouse(10));
        sim3.setupSimulation(3, 2, 2000, 3000);
        sim3.startSimulation(20);

        System.out.println("\nFinish!!!");
    }
}

