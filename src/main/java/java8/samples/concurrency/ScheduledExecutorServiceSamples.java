package java8.samples.concurrency;

import java.util.concurrent.*;

public class ScheduledExecutorServiceSamples {
    private static int count = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        Runnable task1 = () -> System.out.println("runnable task1");

        //scheduled
        System.out.println("scheduling future");
        scheduledExecutorService.schedule(task1, 1, TimeUnit.SECONDS);

        int  i = 1;
        Callable<Integer> callableTask = () -> i * 2;

        ScheduledFuture<Integer> scheduledFuture = scheduledExecutorService.schedule(callableTask, 2, TimeUnit.SECONDS);
        System.out.println("scheduledFuture: " + scheduledFuture.get());

        Runnable task2 = () -> {
            count++;
            System.out.println("task2: " + count);
        };

        // fixed rate scheduling
        ScheduledFuture<?> scheduledFutureRunnable = scheduledExecutorService.scheduleAtFixedRate(task2, 0, 1, TimeUnit.SECONDS);
        System.out.println("scheduledFutureRunnable isDone: " + scheduledFutureRunnable.isDone());
        while (count < 6 && !scheduledFuture.isCancelled()) {
            //System.out.println("Tasks running");
        }
        System.out.println("scheduledFutureRunnable isDone: " + scheduledFutureRunnable.isDone());
        TimeUnit.SECONDS.sleep(5);
        scheduledFutureRunnable.cancel(true);
        System.out.println("scheduledFutureRunnable isDone: " + scheduledFutureRunnable.isDone());
        scheduledExecutorService.shutdown();
    }
}
