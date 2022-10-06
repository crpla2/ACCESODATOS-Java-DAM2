package Ejercicio10;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XML_Repaso2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		List<Pelicula>lista=new ArrayList<>();
		XStream xs= new XStream();
		xs.alias("Peliculas", List.class);
		xs.alias("Pelicula",Pelicula.class);
		lista=(ArrayList<Pelicula>) xs.fromXML(new FileInputStream("Ficheros/peliculas.xml"));
		//lista.forEach(System.out::println);

		xs= new XStream(new DomDriver("UTF-8"));
		xs.alias("PELICULAS", List.class);
		xs.alias("PELI",Pelicula.class);
		xs.aliasField("ID", Pelicula.class, "id");
		xs.aliasField("TITULO", Pelicula.class, "titulo");
		xs.aliasField("AÑO", Pelicula.class, "anyo");
		xs.aliasField("DESCRIPCIÓN", Pelicula.class, "descripcion");
		xs.toXML(lista, new FileOutputStream("Ficheros/peliculasR2.xml"));
		
		
		FileWriter fichero;
		try {
			fichero = new FileWriter("Ficheros/peliculasR2.json");
			new Gson().toJson(lista, fichero);fichero.close();
			
		
		Gson gson=new Gson();
		String fichero1=new String(Files.readAllBytes(Paths.get("Ficheros/peliculasR2.json")));
//		JsonArray ja= JsonParser.parseString(fichero1).getAsJsonArray();
//		ja.forEach(j->{JsonObject jo= j.getAsJsonObject();
//		
//			Pelicula p=new Pelicula();			
//			p.setTitulo(jo.get("titulo").getAsString());
//			p.setId(jo.get("id").getAsInt());
//			p.setAnyo(jo.get("anyo").getAsInt());
//			p.setDescripcion(jo.get("descripcion").getAsString());
//			lista1.add(p);
//			
//		});lista1.forEach(System.out::println);
		
		Pelicula[]lista2=gson.fromJson(fichero1,Pelicula[].class);
		for(Pelicula p:lista2) {
			System.out.println(p);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
