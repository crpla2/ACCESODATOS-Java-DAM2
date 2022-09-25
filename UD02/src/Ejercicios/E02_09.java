package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class E02_09 {
	/*
	 * Adaptación de los ejemplos vistos en los materiales con la clase
	 * RandomAccessFile. Realiza una clase UD2_9 que pida al usuario el
	 * identificador del profesor y lo borre del fichero ProfesFPSierraGuara.dat.
	 * Borrar un dato simplemente consiste en poner su campo id dentro del fichero a
	 * 0 para indicar que ese registro no existe y su posición está libre. Se deberá
	 * controlar que: - El identificador del profesor esté dentro de los límites del
	 * fichero. - El identificador del profesor debe existir. Si ha sido borrado
	 * previamente se advertirá de la situación. - Antes de finalizar el código
	 * visualizar de manera secuencial todos los registros del fichero para
	 * comprobar la operación.
	 *  ==================================*
	 *               Id (entero – 4 bytes)* 
	 *   Nombre (20 caracteres – 40 bytes)* 
	 *    Departamento 1 (entero– 4 bytes)*
	 *         Antigüedad (real – 8 bytes)* 
	 * ===================================*
	 *                     Total(56 bytes)*
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		RandomAccessFile file;
		File f = new File("Ficheros/ProfesFPSierraGuara.dat");
		String Profe,respuesta;
		char profes[] = new char[20];// Array para guardar el nombre del profesor
		int id,posicion,departamento;
		double antiguedad;
		
		System.out.println("Introduzca el id del profesor:");

		try {
			file = new RandomAccessFile(f, "rw");
			id = s.nextInt();
			posicion = (id - 1) * 56;// formula para calcular la posición
			if ((posicion > f.length() - 56) || (id < 1)) {// calculo la posición del último registro si "pos" es superior
														// estoy fuera
				System.err.println("No existe un profesor con ese ID");
				System.exit(-1);
			}
			file.seek(posicion);
			if (file.readInt() == 0) {// leo el ID (avanza una posicion)
				System.err.println("El profesor con ese ID ya ha sido borrado\n");
			}
//"[C@14991ad
// [C@14991ad
			else {
				file.seek(posicion+4);
				for (int i = 0; i < profes.length; i++) {// recojo los 20 caracteresdelnombre en un array
					profes[i] = file.readChar();
				}
				Profe = new String(profes);
				
				System.out.println("Esta  seguro que desea borrar a \"" + Profe + "\"? y/n");
				respuesta = s.next();
				if(respuesta.equalsIgnoreCase("y")) {
				file.seek(file.getFilePointer() - 44);// retrocedo una posicion para situarme en el ID de nuevo
				file.writeInt(0); // borro el ID
				}else System.exit(-1);
			}
			file.seek(0);// me coloco al pricipio del todo
			System.out.println("ID\tNombre\t\tDeparatmento\tAntiguedad");
			for (int j = 0; j < file.length() / 56; j++) {
				id = file.readInt();
				for (int i = 0; i < profes.length; i++) {// recojo los 20 caracteres en un array
					profes[i] = file.readChar();
				}
				departamento = file.readInt();
				antiguedad = file.readDouble();
				Profe = new String(profes);// paso el array a String para imprimirlo
				System.out.println(id + "   " + Profe + "\t" + departamento + "\t" + antiguedad);
			}
			file.close();
			s.close();
		} catch (FileNotFoundException e) {
			System.err.println("no se encuentra el archivo");
		} catch (IOException e) {
			System.err.println("ERROR IOException");
		}
	}

}
