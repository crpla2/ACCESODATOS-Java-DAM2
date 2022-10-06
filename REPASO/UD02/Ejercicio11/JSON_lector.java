package Ejercicio11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
public class JSON_lector {

	public static void main(String[] args) {
		
		Gson gson= new Gson();
		try {
			String string=new String(Files.readAllBytes(Paths.get("Ficheros/peliculas.json")));
			
			Pelicula[]pelis=gson.fromJson(string,Pelicula[].class);
			for (Pelicula pelicula : pelis) {
				System.out.println(pelicula);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}

}}
