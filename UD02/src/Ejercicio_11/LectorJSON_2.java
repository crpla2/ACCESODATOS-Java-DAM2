package Ejercicio_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LectorJSON_2 {

	public static void main(String[] args) {
		
		try {
			String fichero=new String(Files.readAllBytes(Paths.get("Ficheros/pelis.json")));
			JsonArray jArray= JsonParser.parseString(fichero).getAsJsonArray();
			//Funcion Lambda foreach
			jArray.forEach(jse ->{ JsonObject jso=jse.getAsJsonObject();
				System.out.println(jso.get("titulo").getAsString()+" - "
								  +jso.get("anyo").getAsInt()+" - "
								  +jso.get("descripcion"));
			});
			//for each Clasico
//			for(JsonElement jse:jArray) {
//				JsonObject jso=jse.getAsJsonObject();
//				System.out.println(jso.get("titulo").getAsString()+" - "
//								  +jso.get("anyo").getAsInt()+" - "
//								  +jso.get("descripcion"));
//			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
