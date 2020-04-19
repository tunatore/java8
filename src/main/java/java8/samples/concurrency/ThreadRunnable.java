package java8.samples.concurrency;

public class ThreadRunnable {
    public static void main(String[] args) {

        // Thread
        int number = 0;
        Thread thread = new Thread(() -> {
            System.out.println(number + 1);
        });
        thread.start();

        // Runnable - functional interface and doesn't return anything
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };
        //runnable.run();

        Thread threadRunnable = new Thread(runnable);
        threadRunnable.start();
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
