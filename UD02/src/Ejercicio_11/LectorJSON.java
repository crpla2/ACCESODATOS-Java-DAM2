package Ejercicio_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class LectorJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson= new Gson();
		try {
			String fichero=new String(Files.readAllBytes(Paths.get("Ficheros/pelis.json")));
			List<Pelicula>lista=Arrays.asList(gson.fromJson(fichero,Pelicula[].class));
			//funcion lambda foreach
			lista.forEach(System.out::println); 	
			//foreach clasico
			//for(Pelicula p:lista) System.out.println(p);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
