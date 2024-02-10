package StreamAPIS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMethods {
	public static void main(String[] args) {
		/*Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
		st3.limit(10).forEach(v -> System.out.print(v + ", "));
		System.out.print(Arrays.toString(st3.limit(10).toArray()));*/

		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
		/*list.stream().map(x -> x * 10).forEach(System.out::println);
		System.out.println(Arrays.toString(list.toArray()));*/

		/*Stream<Long> st4 = Stream.iterate(new Long[] { 0L, 1L }, p -> new Long[] { p[1], p[0] + p[1] }).map(p -> p[0]);
		System.out.println(Arrays.toString(st4.limit(10).toArray()));*/

		
		Integer sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Sum: " + sum);
		
		
		List<Integer> newList = list.stream()
		.filter(x -> x % 2 ==0).map(x -> x * 10)
		.collect(Collectors.toList());
		
		System.out.println(Arrays.toString(newList.toArray()));
		
	}

}
