package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main01 {

	public static void main(String[] args) {
		// A la antigua usanza:
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		for(Integer n: list) {
		    System.out.println(n);
		}

		// Una nueva forma:
		list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.forEach(n -> System.out.println(n));

	}

}
