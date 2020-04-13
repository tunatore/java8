package java8.samples.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamCustomSorted {

	public static void main(String[] args) {

		//Single sorter
		Comparator<Person> comparatorPerson = (p1, p2) -> Integer.compare(
	            p1.getDepartmentId(), p2.getDepartmentId());
		
		Stream.of(new Person(1,"tuna",10),new Person(2,"tuna2",10),new Person(2,"tuna3",20),
				new Person(3,"tuna4",30),new Person(4,"tuna5",30))
			.sorted(comparatorPerson)
				.forEach(person -> {					
					System.out.println("department: " + person.getDepartmentId());	
					System.out.println("person: " + person.getName());
				});		
						
		//Multiple sorting
		System.out.println("\nMultiple comparator sorting");
		Comparator<Person> comparatorPersonId = (p1, p2) -> Integer.compare(
	            p1.getId(), p2.getId());

		Stream.of(new Person(1,"tuna",10),new Person(2,"tuna2",10),new Person(3,"tuna3",20),
				new Person(4,"tuna4",30),new Person(5,"tuna5",30),new Person(6,"tuna6",10))
			.sorted(comparatorPerson.thenComparing(comparatorPersonId))
				.forEach(person -> {					
					System.out.println("department: " + person.getDepartmentId() 
							+ " person id: " + person.getId() + " person name: " + person.getName());	
				});
	}
}
