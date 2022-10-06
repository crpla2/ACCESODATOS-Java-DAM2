package Ejercicio01_07;

import java.io.File;
import java.io.IOException;

/*
 * Realiza una clase UD2_3 que complete la clase EjemploClaseFile02 de los materiales
borrando el directorio y el fichero creados en ella (primero borra el fichero y después el
directorio pues no se permite borrar directorios no vacíos).
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		boolean resultado;
		File directorio = new File("C:/DAM2");
		resultado = directorio.mkdir();
		if (resultado)
			System.out.println("Directorio creado");
		else {
			System.out.println("No se pudo crear el directorio");
			System.exit(-1);
		}
		File fichero = new File("C:/DAM2/ALberto.txt");
		try {
			resultado = fichero.createNewFile();
			if (resultado)
				System.out.println("Fichero creado");
			else {
				System.out.println("No se pudo crear el archivo");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Se produjo el error: " + e.getMessage());
		}
		if (fichero.exists()) {
			resultado = fichero.delete();
			if (resultado) {
				System.out.println("Fichero borrado");
			}else {
				System.out.println("No se pudo borrar el fichero");
				System.exit(-1);
			}

		} else {
			System.out.println("El fichero no existe");
		}
		if (directorio.exists()) {
			resultado = directorio.delete();
			if (resultado) {
				System.out.println("Directorio borrado");
			} else {
				System.out.println("No se pudo borrar el directorio");
				System.exit(-1);
			}
		}

	}

}
