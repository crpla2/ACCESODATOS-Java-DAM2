package Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Realiza una clase UD2_6 que indique cuántas veces aparece una palabra dentro de un
fichero de texto (puedes crearlo con el bloc de notas). Tanto el nombre del fichero como la
palabra se deben pasar como argumentos. No distinguir mayúsculas/minúsculas. Incluye
también tratamiento de excepciones.
 */
public class E02_06 {

	public static void main(String[] args) {
		String cadena = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("Ficheros\\" + args[0]));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				cadena += linea.toLowerCase();
			}
			br.close();

		} catch (IOException eo) {
			System.err.println("Se ha producido un error de lectura");
		}

		int cont = 0;
		while (cadena.indexOf(args[1].toLowerCase()) != -1) {
			cadena = cadena.substring(cadena.indexOf(args[1]) + (args[1].length()));
			cont++;
			System.out.println(cadena);
		}

		System.out.println("La palabra \""+args[1]+"\" se repite " + cont + " veces");
	}

}
