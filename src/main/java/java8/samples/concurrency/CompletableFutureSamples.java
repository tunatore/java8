package java8.samples.concurrency;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureSamples {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //No need to define ExecutorService; Completable future internally uses ForkJoinPool
        //to call tasks
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(
                () -> "completableFuture1 returned"
        );
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(
                () -> "completableFuture2 returned"
        );
        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "completableFuture3 returned";
                }
        );

        //combine completable futures
        List<String> combinedResults = Stream.of(completableFuture1, completableFuture2, completableFuture3)
                .map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println(completableFuture1.isDone());
        System.out.println(completableFuture2.isDone());
        System.out.println(completableFuture3.isDone());

        for (String result: combinedResults) {
            System.out.println("result: " + result);
        }

        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(() -> "Hello")
                        .thenApplyAsync(result -> result + " World!");
        System.out.println("result: " + completableFuture.get());

        //Handling exception
        CompletableFuture.supplyAsync(() -> "completable async exception")
                .thenApplyAsync(result -> result + "1")
                .thenApplyAsync(result -> result + "2")
                .thenApplyAsync(result -> result + "6")
                .thenApplyAsync(result -> {
                    throw new RuntimeException("RuntimeException in Completable Future");
                }).exceptionally(throwable -> {
                    System.out.println("Exception in completable future!");
                    //throwable.printStackTrace();
                    return "exception";
        }).thenAccept(result -> System.out.println("completable async has completed result: " + result));

        CompletableFuture completableFutureException = CompletableFuture.supplyAsync(() -> 100 / 0)
                .exceptionally(result -> 0);
        System.out.println(completableFutureException.get());
    }
}
