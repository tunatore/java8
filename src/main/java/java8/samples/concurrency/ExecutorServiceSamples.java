package java8.samples.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceSamples {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        int i = 1;
        List<Callable<Integer>> callableList = Arrays.asList(
                () -> i * 2,
                () -> i * 3,
                () -> i * 4,
                () -> i * 5,
                () -> i * 6
        );

        List<Future<Integer>> callableFutureList = executorService.invokeAll(callableList);
        callableFutureList.stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).forEach(result ->
                System.out.println("result: " + result)
        );

        Callable<String> callable1 = () -> {
            TimeUnit.SECONDS.sleep(10);
            return "callable1";
        };

        Callable<String> callable2 = () -> {
            TimeUnit.SECONDS.sleep(1);
            return "callable2";
        };

        List<Future<String>> futureList = executorService.invokeAll(Arrays.asList(callable1, callable2));
        for(Future<String> future : futureList) {
            System.out.println(future.get());
        }

//        String futureListInvokeAny = executorService.invokeAny(Arrays.asList(callable1, callable2));
//        System.out.println("invokeAny: " + futureListInvokeAny);

        executorService.shutdown();
    }
}
