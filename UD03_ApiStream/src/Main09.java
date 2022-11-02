import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main09 {
	private static BookRepository bookRepository;
	private static List<Book> bookList;

	public static void main(String[] args) {

		bookRepository = new BookRepository();
		bookList = new ArrayList<Book>();
		bookList.addAll(bookRepository.getBooks());
		//

		List<Book> books = bookList.stream()
				.sorted((book1, book2) -> book1.getAuthor().compareToIgnoreCase(book2.getAuthor()))
				.peek(System.out::println)
				.collect(Collectors.toList());
		
		System.out.println(books.get(0).getAuthor().contains("Alberto"));// true
		System.out.println(books.get(1).getAuthor().contains("Belén"));// true
		System.out.println(books.get(2).getAuthor().contains("Luis"));// true

	}

}
