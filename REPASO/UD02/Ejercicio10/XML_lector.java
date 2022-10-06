package Ejercicio10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class XML_lector {
public static void main(String[] args) {
	List<Pelicula>lista= new ArrayList<Pelicula>();
	
	XStream xs= new XStream();
	xs.alias("Peliculas", List.class);
	xs.alias("Pelicula",Pelicula.class);
	try {
		lista=(List<Pelicula>) xs.fromXML(new FileInputStream("Ficheros/peliculas.xml"));
	lista.forEach(System.out::println);} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
}
