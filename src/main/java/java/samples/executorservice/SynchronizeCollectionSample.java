package java.samples.executorservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizeCollectionSample {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(list);
        for (int i = 0; i < 100000; i++) {
            synchronizedList.add("a" + i);
        }

        System.out.println("synchronizedList size: " + synchronizedList.size());
        ExecutorService executorService = Executors.newFixedThreadPool(6);

        int size = synchronizedList.size();
        for (int i = 0; i < size; i++) {
            //Executes the given command at some time in the future. The command may execute in a new thread,
            // in a pooled thread, or in the calling thread, at the discretion of the Executor implementation.
            executorService.execute(() -> synchronizedList.remove(0));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("synchronizedList size: " + synchronizedList.size());
    }
}
