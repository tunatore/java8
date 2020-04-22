package java8.samples.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamGroupBy {
    public static void main(String[] args) {
        
        List<Person> personList =
        Stream.of(new Person(1,"tuna",10, "USA"),
                new Person(2,"tuna2",10, "USA"),
                new Person(3,"tuna3",20, "UK"),
                new Person(4,"tuna4",30, "UK"),
                new Person(5,"tuna5",30, "USA"))
                .filter(person -> person.id != 1)
                .collect(Collectors.toList());

        System.out.println(personList);

        // group by department
        Map<Integer, List<Person>> personGroupByDepartmentId = personList
                .stream()
                .sorted(Comparator.comparing(Person::getDepartmentId))
                .collect(Collectors.groupingBy(person -> person.departmentId, LinkedHashMap::new, Collectors.toList()));

        personGroupByDepartmentId.forEach((departmentId, person) -> System.out.format("Department %s %s\n", departmentId, person));

        // partition by
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> partitionMap = integerList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Even partition list: " + partitionMap.get(true));
        System.out.println("Odd partition list: " + partitionMap.get(false));

        // group by department and display country
        Map<Integer, String> personGroupByDepartmentIdAndCountryMap = personList
                .stream()
                .collect(groupingBy(Person::getDepartmentId, mapping(Person::getCountry, joining("-"))));

        System.out.println(personGroupByDepartmentIdAndCountryMap);
    }
}
