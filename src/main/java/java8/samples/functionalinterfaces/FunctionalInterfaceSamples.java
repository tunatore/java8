package java8.samples.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaceSamples {
    public static void main(String[] args) {
        //Consumer takes an argument and returns nothing - void
        Consumer<Integer> consumerFunction = (Integer i) -> System.out.print("i: " + i + "->");
        functionalMethodConsumer(Arrays.asList(1, 2, 3, 4, 5, 100), consumerFunction);
        System.out.println();
        functionalMethodConsumer(Arrays.asList(1, 2, 3, 4, 5, 100), (Integer i) -> System.out.print("i: " + i + "->"));
        System.out.println();
        functionalMethodConsumer(Arrays.asList(1, 2, 3, 4, 5, 100), System.out::print);

        //Predicate takes an argument and validates it based on the condition
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

        //Function takes one argument and returns one argument
        Function<Integer,Integer> function = (Integer i) -> i * 2;
        Function<Integer,Integer> function2 = (Integer i) -> i * 10;
        functionalMethod(Arrays.asList(1, 2, 3, 4, 5), function);
        System.out.println();
        functionalMethod(Arrays.asList(1, 2, 3, 4, 5), function.andThen(function2));

        //Supplier
        Supplier<String> supplier = () -> "123456";
        System.out.println("\n" + supplier.get());
    }
    private static void functionalMethod(List<Integer> integerList, Function<Integer, Integer> function) {
        for(int i : integerList) {
            System.out.print(function.apply(i) + "->");
        }
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
