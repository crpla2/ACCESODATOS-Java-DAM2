package Ejercicio11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSON_lector2 {

	public static void main(String[] args) {
		Gson gson=new Gson();
		try {
			String fichero=new String(Files.readAllBytes(Paths.get("Ficheros/peliculas.json")));
			JsonArray jsonarray=JsonParser.parseString(fichero).getAsJsonArray();
			jsonarray.forEach(j->{JsonObject jso=j.getAsJsonObject();
								System.out.println(jso);//.get("titulo").getAsString());
								});
} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
