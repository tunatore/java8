package java8.samples.concurrency;

import java8.samples.stream.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CallableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        List<Person> personList = Arrays.asList(
                new Person(1, "tuna", 10),
                new Person(2, "tuna2", 10),
                new Person(3, "tuna3", 20),
                new Person(4, "tuna4", 30),
                new Person(5, "tuna5", 30));

        // Callable can return a generic value
        Callable<List<Person>> personSorterTask = () -> {
            //TimeUnit.SECONDS.sleep(1);
            return personList.stream().sorted(Comparator.comparingInt(Person::getDepartmentId))
                        .collect(Collectors.toList());
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<List<Person>> callableOutputOfPersonSorter = executorService.submit(personSorterTask);

//        System.out.println("isDone: " + callableOutputOfPersonSorter.isDone());
//        while(!callableOutputOfPersonSorter.isDone()) {
//            System.out.println("waiting...");
//        }
        System.out.println("isDone: " + callableOutputOfPersonSorter.isDone());

        //Future.get blocks
        List<Person> personListResult = callableOutputOfPersonSorter.get(10, TimeUnit.SECONDS);
        System.out.println("get: " + personListResult);
        System.out.println("isDone: " + callableOutputOfPersonSorter.isDone());

        executorService.shutdown();
    }
}
