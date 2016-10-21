package java8.samples.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream2 {
	
	
	
	public static void main(String[] args) {
		
		//Stream 2
		
		System.out.println("Find first isPresent");
		Arrays.asList("1","2","3", "tuna", "tore").stream()
				.findFirst()
				.map(element -> "First record is " + element)
				.ifPresent(System.out::print);
		
		System.out.println("Sum Stream");
		int sum = Arrays.asList("1","2","3", "4", "5").stream()
			.mapToInt(Integer::parseInt).sum();
		System.out.println("sum: " + sum);
		
		System.out.println("Sum Stream with filter");
		int sumFilter = Arrays.asList("10","20","30", "40", "50").stream()
				.mapToInt(Integer::parseInt)
					.filter(element -> element > 20).sum();
			System.out.println("sum: " + sumFilter);
		
		System.out.println("Int Stream with filter");
		IntStream.range(1, 10).filter(x -> x%2 == 0)
				.forEach(System.out::println);
		
		System.out.println("Finding max with ifPresent");	
		Stream.of("1","2","3","4", "5").mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

		
		//Order of execution		
		Stream.of(1,2,3,4,5).
				map(
					element -> { 
						System.out.println("Map Element: " + element); 
						return element;})
				.filter(
					element -> {
						System.out.println("Filter Element: " + element);
						return true;
					}
				).forEach(
					element -> {
						System.out.println("For each Element: " + element);
					}
				);
		}

}
