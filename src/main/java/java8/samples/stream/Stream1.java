package java8.samples.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Stream1 {

	public static void main(String[] args) {
		
		//Simple stream
		
		List<String> list = Arrays.asList("tuna","tore","1","2", "3", "stream1", "abc");
		list.stream().forEach(System.out::println);
	
		System.out.println("Element length > 1");
		list.stream().filter(element -> element.length() > 1).forEach(System.out::println);

		System.out.println("Elements with map transformation");
		list.stream().map(element -> element + " edited").forEach(System.out::println);
		
		System.out.println("Elements sorted");
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("Elements processing method");
		Arrays.asList("a", "b", "c").forEach(
					element -> {
							System.out.println("Element: " + element);
							System.out.println("Element edited: " + element);
					}	
		);

		//stream statistics
		List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);
		IntSummaryStatistics statistics = integerList.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("max: " + statistics.getMax());
		System.out.println("min:" + statistics.getMin());
		System.out.println("average: " + statistics.getAverage());
		System.out.println("count: " + statistics.getCount());
		System.out.println("sum:" + statistics.getSum());
	}
}
