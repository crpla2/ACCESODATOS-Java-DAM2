

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRepository {

	private List<Book> books = new ArrayList<>();
	
	public BookRepository() {
		generateDefaultData();
	}
	
	private void generateDefaultData() {
		books = Arrays.asList(
				new Book("Libro 1", "Alberto Carrera", 10.0),
				new Book("Libro 2", "Luis Aldea", 15.0),
				new Book("Libro 3", "Belén Carrera", 50.99)
				);
	}
	
	public List<Book> getBooks(){
		return this.books;
	}
}
