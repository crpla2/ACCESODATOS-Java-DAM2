import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main12 {
	private static BookRepository bookRepository;
	private static List<Book> bookList;

	public static void main(String[] args) {

		bookRepository = new BookRepository();
		bookList = new ArrayList<Book>();
		bookList.addAll(bookRepository.getBooks());
		//

		bookList.add(new Book(bookList.get(0).getTitle(), "", 0d));
		List<String> distinctTitles = bookList.stream()
				.map(book -> book.getTitle())
				.distinct()
				.peek(System.out::println)
				.collect(Collectors.toList());
		
		System.out.println(distinctTitles.size()== 3); //true

	}

}
