package java8.samples.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfaceSamples {
    public static void main(String[] args) {
        //Consumer takes an argument and returns nothing - void
        Consumer<Integer> consumerFunction = (Integer i) -> System.out.print("i: " + i + "->");
        functionalMethodConsumer(Arrays.asList(1, 2, 3, 4, 5, 100), consumerFunction);
        System.out.println();
        functionalMethodConsumer(Arrays.asList(1, 2, 3, 4, 5, 100), (Integer i) -> System.out.print("i: " + i + "->"));

        Predicate<Integer> greaterThan10 = (Integer i) -> i > 10;
        Predicate<Integer> lessThan250 = (Integer i) -> i < 250;
        System.out.println();
        functionalMethodPredicate(Arrays.asList(1, 2, 3, 4, 5, 100, 200, 250, 300, 400, 500, 600),
                greaterThan10.and(lessThan250));

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 100, 200, 250, 300, 400, 500, 600);
        List<Integer> collectList = integerList.stream()
                .filter(greaterThan10.and(lessThan250))
                .collect(Collectors.toList());
        System.out.println("\ncollectList: " + collectList);
    }
    private static void functionalMethodConsumer(List<Integer> integerList, Consumer<Integer> consumerFunction) {
        for(int i : integerList) {
            consumerFunction.accept(i);
        }
    }
    private static void functionalMethodPredicate(List<Integer> integerList, Predicate<Integer> predicateFunction) {
        for(int i : integerList) {
            if (predicateFunction.test(i)) {
                System.out.print(i + "->");
            }
        }
    }
}
