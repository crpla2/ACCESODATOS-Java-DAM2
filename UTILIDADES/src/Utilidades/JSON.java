package Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class JSON {//acordarse de llevar la librería GSON para que funcione
	public static boolean exportarjSON(List lista,String ruta) {
		FileWriter fw;
		try {
			fw = new FileWriter(new File(ruta));
			new Gson().toJson(lista,fw);
			fw.close();
			return true;
		} catch (IOException e) {
			return false;
		} catch (JsonIOException e) {
			return false;
		}
}
}