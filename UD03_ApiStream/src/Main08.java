import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main08 {
	private static BookRepository bookRepository;
	private static List<Book> bookList;

	public static void main(String[] args) {

		bookRepository = new BookRepository();
		bookList = new ArrayList<Book>();
		bookList.addAll(bookRepository.getBooks());
		//

		Book[] booksArray = bookList.toArray(new Book[bookList.size()]);

		booksArray = bookList.stream().toArray(Book[]::new);

		// Convertimos el array en un stream para visualizar su contenido más fácilmente
		// sin tener que utilizar el 'for(Book book: booksArray)' de toda la vida:
		Stream.of(booksArray)
		.peek(System.out::println)
		.collect(Collectors.toList());

	}

}
