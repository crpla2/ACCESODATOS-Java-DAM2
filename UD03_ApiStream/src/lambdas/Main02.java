package lambdas;

import java.util.stream.Stream;

public class Main02 {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("c", "f", "a", "g", "b");
		//
		Stream<String> myNewStream = stream
				.map(s -> s.toUpperCase());
		myNewStream.forEach(s->System.out.println(s));
		// También valdría myNewStream.forEach((System.out::println));
		//
		Stream<String> stream2 = Stream.of("c", "f", "a", "g", "b");
		stream2
				.filter(s->!s.equals("a"))
				.sorted()
				.forEach(System.out::println);

	}

}
