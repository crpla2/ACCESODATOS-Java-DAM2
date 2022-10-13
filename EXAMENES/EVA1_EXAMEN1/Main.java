
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Main {

	public static void main(String[] args)  {
		List<Libro> lista = new ArrayList<>();
		File entrada = new File("Ficheros/libros.dat");
		File salida=new File("Ficheros/libros.xml");
		Libro l;
		System.out.println("Leyendo...");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(entrada));
			try {
				
				while (true) {
					l = (Libro) ois.readObject();
					lista.add(l);

				}
			} catch (EOFException eo) {} 
			ois.close();
			System.out.println("Final de lectura");
		}catch (ClassNotFoundException e) {
			System.err.println("Error, no se encuentra la clase");
		} catch (IOException e) {
			System.err.println("Error de lectura del archivo de datos");
		}
		
		System.out.println("Escribiendo...");
		XStream xs= new XStream(new DomDriver("UTF-8"));
		xs.alias("ListaLibros", List.class);
		xs.alias("Libro",Libro.class);
		try {
			
			xs.toXML(lista, new FileOutputStream(salida));
			System.out.println("Fin escritura");
		} catch (FileNotFoundException e) {
			System.err.println("Error de transformación a XML");
		}
		
	}

}
