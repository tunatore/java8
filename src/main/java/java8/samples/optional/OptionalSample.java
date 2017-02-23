package java8.samples.optional;

import java.util.Optional;

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

        //isPresent
        System.out.println("integerOptional1 isPresent: " + integerOptional1.isPresent());
        System.out.println("integerOptional2 isPresent: " + integerOptional2.isPresent());

        //Defaults
        System.out.println(integerOptional1.orElse(Integer.MIN_VALUE));
        System.out.println(integerOptional2.orElse(Integer.MIN_VALUE));

        Optional nullable = Optional.ofNullable(null);

        System.out.println(nullable);
    }

}
