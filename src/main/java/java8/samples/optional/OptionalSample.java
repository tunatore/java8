package java8.samples.optional;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by Tuna.Tore on 22-10-2016.
 * This is new information in this file.
 */
public class OptionalSample {

    public static void main(String[] args) {

        Integer integer1 = 100;
        Integer integer2 = null;

        Optional<Integer> integerOptional1 = Optional.ofNullable(integer1);
        Optional<Integer> integerOptional2 = Optional.ofNullable(integer2);

        //nullable does not throw exception if the element is null
        System.out.println(Optional.ofNullable(integer1));
        System.out.println(Optional.ofNullable(integer2));

        System.out.println(Optional.of(integer1));
        // throw exception System.out.println(Optional.of(integer2));

        //isPresent
        System.out.println("integerOptional1 isPresent: " + integerOptional1.isPresent());
        System.out.println("integerOptional2 isPresent: " + integerOptional2.isPresent());

        Consumer<Integer> integerConsumer = x -> System.out.println("integer present: " + x);
        integerOptional1.ifPresent(integerConsumer);
        integerOptional2.ifPresent(integerConsumer);

        //Defaults
        System.out.println("value or default: " + integerOptional1.orElse(Integer.MIN_VALUE));
        System.out.println("value or default: " + integerOptional2.orElse(Integer.MIN_VALUE));

        Optional nullable = Optional.ofNullable(null);

        System.out.println(nullable);
        System.out.println(nullable == Optional.empty());
    }
}
