package Belgee;

public class Dealer {
    public void boughtCar(Warehouse warehouse) throws InterruptedException {
        Car car = warehouse.take();
        System.out.println("Car was taken:" + car);
    }
}

