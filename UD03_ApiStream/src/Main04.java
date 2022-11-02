import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main04 {
	private static BookRepository bookRepository;
	private static List<Book> bookList;

	public static void main(String[] args) {

		bookRepository = new BookRepository();
		bookList = new ArrayList<Book>();
		bookList.addAll(bookRepository.getBooks());
		//
		bookList.stream()
		.forEach(book -> {
			double newPrice = book.getPrice();
			newPrice *= 2;
			book.setPrice(newPrice);
			System.out.println(book);
		});
	}

}
