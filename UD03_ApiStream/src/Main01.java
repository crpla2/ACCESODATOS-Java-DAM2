import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main01 {
	private static BookRepository bookRepository;
	private static List<Book> bookList;

	public static void main(String[] args) {

		bookRepository = new BookRepository();
		bookList = new ArrayList<Book>();
		bookList.addAll(bookRepository.getBooks());
		//
		List<Integer> listCollected = Stream.of(0, 1, 2, 3, 4, 5)
				.collect(Collectors.toList());
		System.out.println(listCollected.size());// 6

		Set<String> setCollected = Stream.of("0", "0", "1", "1", "2", "2", "3", "3", "4", "4", "5", "5")
				.collect(Collectors.toSet());
		System.out.println(setCollected.size());// 6

	}

}
