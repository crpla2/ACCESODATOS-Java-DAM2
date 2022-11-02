import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main05 {
	private static BookRepository bookRepository;
	private static List<Book> bookList;

	public static void main(String[] args) {

		bookRepository = new BookRepository();
		bookList = new ArrayList<Book>();
		bookList.addAll(bookRepository.getBooks());
		//
		List<String> titles = bookList.stream()
				.map(book -> book.getTitle())
				.peek(title -> System.out.println(title))
				.collect(Collectors.toList());
		
		System.out.println(titles.size()==bookList.size()); //true
		bookList.forEach(
				(book) -> {
					System.out.println(titles.contains(book.getTitle()));// true
				});
	}

}
