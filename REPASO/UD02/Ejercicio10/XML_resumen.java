package Ejercicio10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XML_resumen {

	public static void main(String[] args) {
		XStream xs= new XStream();
		xs.alias("Peliculas", List.class);
		xs.alias("Pelicula", Pelicula.class);
		List<Pelicula> lista;
		try {
			lista = (List<Pelicula>) xs.fromXML(new FileInputStream("Ficheros/peliculas.xml"));
			lista.forEach(System.out::println);
			
			XStream xs2=new XStream( new DomDriver("UTF-8"));
			xs2.alias("PeliculasX", List.class);
			xs2.alias("PeliculaX", Pelicula.class);
			xs2.toXML(lista,new FileOutputStream("Ficheros/peliculasX.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
