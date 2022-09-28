package Ejercicio_01_09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.StringTokenizer;

public class E02_09 {
	/*
	 * RandomAccessFile. Realiza una clase UD2_9 que pida al usuario el
	 * identificador del profesor y lo borre del fichero ProfesFPSierraGuara.dat.
	 * Borrar un dato simplemente consiste en poner su campo id dentro del fichero a
	 * 0 para indicar que ese registro no existe y su posición está libre. Se deberá
	 * controlar que: 
	 * - El identificador del profesor esté dentro de los límites del fichero. 
	 * - El identificador del profesor debe existir. Si ha sido borrado previamente se advertirá de la situación. 
	 * - Antes de finalizar el código visualizar de manera secuencial todos los registros del fichero para comprobar la operación. 
	 * ===================================* 
	 *                Id (entero – 4bytes)* 
	 *   Nombre (20 caracteres – 40 bytes)* 
	 *    Departamento 1 (entero– 4 bytes)*
	 *         Antigüedad (real – 8 bytes)* 
	 * ===================================* 
	 *                      Total(56bytes)*
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		RandomAccessFile file;
		File f = new File("Ficheros/ProfesFPSierraGuara.dat");
		String Profe, respuesta,siOno;
		char profes[] = new char[20];// Array para guardar el nombre del profesor
		int id, posicion, departamento;
		double antiguedad;

		System.out.println("Introduzca el id del profesor:");

		try {
			file = new RandomAccessFile(f, "rw");
			id = s.nextInt();
			posicion = (id - 1) * 56;// formula para calcular la posición
			if ((posicion > file.length() - 56) || (id < 1)) {
				// calculo la posición del último registro si "pos" es superior estoy fuera
				System.out.println("No existe un profesor con ese ID\t");
			} else {
				file.seek(posicion);
				if (file.readInt() == 0) {// leo el ID (avanza una posicion) si es igual a cero no exite o se ha borrado
					System.out.println("El profesor con ese ID no existe o ya ha sido borrado\n");
				} else {
					file.seek(posicion + 4);// me posiciono destras del id
					for (int i = 0; i < profes.length; i++)
						profes[i] = file.readChar(); // recojo los 20 caracteresdelnombre en un array }
					Profe = new String(profes);// los paso a un String para imprimirlos
					Profe = Profe.trim();// Elimino los espacios al final
					System.out.println("Está seguro que desea borrar a \"" + Profe + "\"? (s/n)");
					respuesta = s.next();
					while (!respuesta.equalsIgnoreCase("n") && !respuesta.equalsIgnoreCase("s")) {
						System.err.println("Solo se admite s(si) o n(no) como respuesta");
						respuesta = s.next();
					}
					if (respuesta.equalsIgnoreCase("s")) {
///////////////////////////BORRADO DE UN REGISTRO PONER ID=0///////////////////////////////////////////////						
						file.seek(file.getFilePointer() - 44);// retrocedo posiciones para situarme en el ID
						file.writeInt(0); // borro el ID
///////////////////////////////////////////////////////////////////////////////////////////////////////////						
					} else {
						System.out.print("FIN");
						System.exit(-1);
					}
				}
			}
			System.out.println("¿desea ver el listado? (s/n)");
			siOno = s.next();
			while (!siOno.equalsIgnoreCase("n") && !siOno.equalsIgnoreCase("s")) {
				System.err.println("Solo se admite s(si) o n(no) como respuesta");
				siOno = s.next();
			}
			if (siOno.equalsIgnoreCase("s")) {
///////////////RECORRER EL ARCHIVO ENTERO E IMPRIMIR LOS DATOS///////////////////////////////////////////////			
				Profe = "";
				file.seek(0);// me coloco al pricipio del todo
				System.out.println("ID\tNombre\t\tDeparatmento\tAntiguedad");
				for (int j = 0; j < file.length() / 56; j++) {//(file.length()/56) para calcular el numero total de registros
					id = file.readInt();
					for (int i = 0; i < profes.length; i++) {// recojo los 20 caracteres en un array
						Profe += file.readChar();//Meto los char en el string Profe
					}
					departamento = file.readInt();
					antiguedad = file.readDouble();
					System.out.println(id + "   " + Profe + "\t" + departamento + "\t" + antiguedad);
					Profe = "";//Dejo Profe vacio para el siguiente registro
				}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////				
			} else
				System.out.print("FIN");
				System.exit(-1);

			file.close();
			s.close();
		} catch (FileNotFoundException e) {
			System.err.println("no se encuentra el archivo");
		} catch (IOException e) {
			System.err.println("ERROR IOException");
		}

	}
}
