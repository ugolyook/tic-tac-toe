package MultiThreading;

public class Demo implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello world!!");

        sleep(5000);

        System.out.println("first:" + Thread.currentThread().getName());
    }

    static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        Thread thread = new Thread(demo);
        thread.setDaemon(true);
        thread.start();

        sleep(1000);
        thread.join();

        System.out.println("second:" + thread.getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isDaemon());
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

