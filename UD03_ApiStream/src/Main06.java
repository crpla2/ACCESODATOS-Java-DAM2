import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main06 {
	private static BookRepository bookRepository;
	private static List<Book> bookList;

	public static void main(String[] args) {

		bookRepository = new BookRepository();
		bookList = new ArrayList<Book>();
		bookList.addAll(bookRepository.getBooks());
		//
		List<Book> books = bookList.stream()
				.filter(book -> book.getPrice() >= 15)
				.peek(book -> System.out.println(book))
				.collect(Collectors.toList());
		
		System.out.println(books.size() == 2);// true
	}

}
