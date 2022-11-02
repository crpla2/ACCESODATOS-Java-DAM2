import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main07 {
	private static BookRepository bookRepository;
	private static List<Book> bookList;

	public static void main(String[] args) {

		bookRepository = new BookRepository();
		bookList = new ArrayList<Book>();
		bookList.addAll(bookRepository.getBooks());
		//
		Book bookFirst = bookList.stream()
				.filter(book -> book.getPrice() >= 15)
				.peek(System.out::println)
				.findFirst()
				.orElse(null);
	
	System.out.println(bookFirst.getPrice() >= 15);
	
	
	}

}
