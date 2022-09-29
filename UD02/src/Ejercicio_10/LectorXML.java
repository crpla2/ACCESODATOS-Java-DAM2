package Ejercicio_10;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class LectorXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pelicula>lista= new ArrayList<Pelicula>();
		XStream xs= new XStream();
		xs.alias("Peliculas",List.class);
		xs.alias("Pelicula", Pelicula.class);
		
		try {
			lista=(List<Pelicula>)xs.fromXML(new FileInputStream("Ficheros/Pelis.xml"));
			//funcion lambda foreach
			lista.forEach(System.out::println);
			//foreach clasico
			//for(Pelicula p:lista)System.out.println(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
