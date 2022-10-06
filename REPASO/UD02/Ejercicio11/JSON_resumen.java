package Ejercicio11;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.thoughtworks.xstream.XStream;

public class JSON_resumen {

	public static void main(String[] args) {
		XStream xs= new XStream();
		xs.alias("PeliculasX", List.class);
		xs.alias("PeliculaX", Pelicula.class);
		try {
			List<Pelicula>lista=(List<Pelicula>) xs.fromXML(new FileInputStream("Ficheros/peliculasX.xml"));
			
			FileWriter file=new FileWriter("Ficheros/PeliculasX.json");
			new Gson().toJson(lista,file);
			file.close();
			
//			Gson gson= new Gson();
//			String fichero= new String(Files.readAllBytes(Paths.get("Ficheros/PeliculasX.json")));
//			Pelicula[]array=gson.fromJson(fichero, Pelicula[].class);
//			for(Pelicula p:array) {
//				System.out.println(p);
//			}
			List<Pelicula>lista2=new ArrayList<>();
			Gson gson2= new Gson();
			String fichero2=new String(Files.readAllBytes(Paths.get("Ficheros/PeliculasX.json")));
			JsonArray jArray=JsonParser.parseString(fichero2).getAsJsonArray();
			jArray.forEach(element->{JsonObject jo=element.getAsJsonObject();
			System.out.println(jo.get("titulo").getAsString());
//									lista2.add(new Pelicula(
//											jo.get("id").getAsInt(),jo.get("titulo").getAsString(),
//											jo.get("año").getAsInt(),jo.get("descripcion").getAsString()));
			});
//		for(Pelicula p:lista2){
//				System.out.println(p);}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
