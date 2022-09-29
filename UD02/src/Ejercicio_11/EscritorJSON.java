package Ejercicio_11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import Ejercicio_10.Pelicula;
/*
 * Crea un paquete de nombre UD2_11 e incluye en él todas las clases necesarias para
crear en disco un fichero JSON con la información que aparece en el ejercicio anterior. Incluye
también las dos clases que recorren el documento JSON creado que se han explicado en los
materiales.
 */
public class EscritorJSON {

	public static void main(String[] args) {
	List<Pelicula>lista= new ArrayList<>();
		
		Pelicula p1=new Pelicula();
			p1.setId(1);
			p1.setTitulo("El señor de los anillos: La comunidad del anillo");
			p1.setAnyo(2001);
			p1.setDescripcion("Ambientada en la Tierra Media, cuenta la historia del Señor Oscuro Sauron, que está buscando el Anillo Único, el cual ha acabado en poder del hobbit Frodo Bolsón (Elijah Wood). El destino de la Tierra Media está en juego mientras Frodo y ocho compañeros que forman la Compañía del Anillo comienzan un largo y peligroso viaje hacia el Monte del Destino en la tierra de Mordor, que es el único lugar en el que el anillo puede ser destruido.");
		Pelicula p2=new Pelicula();
			p2.setId(2);
			p2.setTitulo("El señor de los anillos: Las dos torres");
			p2.setAnyo(2002);
			p2.setDescripcion("La trama de la película comienza tras la disolución de la Compañía del Anillo. Boromir ha muerto a manos del jefe de los uruk-hai, Lurtz, en un intento de salvar a los hobbits Meriadoc Brandigamo y Peregrin Tuk, que acaban siendo capturados. Frodo Bolsón y Sam Gamyi parten solos hacia Mordor para destruir el Anillo Único en el Monte del Destino, mientras que Aragorn, Gimli y Legolas persiguen a los uruks con el fin de liberar a sus amigos capturados.");
		Pelicula p3=new Pelicula();
			p3.setId(3);
			p3.setTitulo("El señor de los anillos: El retorno del Rey");
			p3.setAnyo(2003);
			p3.setDescripcion("Trata sobre la última parte del viaje que emprendieron los nueve compañeros (de los cuales quedan solamente ocho) para salvar a la Tierra Media de la oscuridad impuesta por Sauron. En esta parte se decide el destino de todos los habitantes de estas tierras.");
		
		lista.add(p1);lista.add(p2);lista.add(p3);
		
		try {
			FileWriter fw = new FileWriter(new File("Ficheros/pelis.json"));
			new Gson().toJson(lista,fw);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
