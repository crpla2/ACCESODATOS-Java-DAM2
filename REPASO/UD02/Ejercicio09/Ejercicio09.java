package Ejercicio09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * Adaptación de los ejemplos vistos en los materiales con la clase RandomAccessFile.
Realiza una clase UD2_9 que pida al usuario el identificador del profesor y lo borre del fichero
ProfesFPSierraGuara.dat. Borrar un dato simplemente consiste en poner su campo id dentro del
fichero a 0 para indicar que ese registro no existe y su posición está libre. Se deberá controlar
que:
- El identificador del profesor esté dentro de los límites del fichero.
- El identificador del profesor debe existir. Si ha sido borrado previamente se advertirá de
la situación.
- Antes de finalizar el código visualizar de manera secuencial todos los registros del
fichero para comprobar la operación.
 * ===================================* 
	 *                Id (entero – 4bytes)* 
	 *   Nombre (20 caracteres – 40 bytes)* 
	 *    Departamento 1 (entero– 4 bytes)*
	 *         Antigüedad (real – 8 bytes)* 
	 * ===================================* 
	 *                      Total(56bytes)*
	 */

public class Ejercicio09 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		File file = new File("Ficheros/ProfesFPSierraGuara (1).dat");
		int num;
		int posicion;
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			System.out.println("introduzca ID de la persona que desea borrar");
			num = Integer.valueOf(s.next());
			posicion = (num - 1) * 56;

			if (posicion < 0 || posicion + 56 > raf.length()) {
				System.out.println("El profe no existe ");
			} else {
				raf.seek(posicion);
				if (raf.readInt() == 0) {
					System.out.println("El profe ya ha sido borrado ");
				} else {
					raf.seek(posicion);
					raf.writeInt(0);
				}
			}
			raf.seek(0);
			System.out.println();
			for (int i = 0; i < raf.length() / 56; i++) {
				System.out.print(raf.readInt() + "\t");
				String nombre = "";
				for (int j = 0; j < 20; j++) {
					nombre += raf.readChar();
				}
				System.out.print(nombre + "\t");
				System.out.print(raf.readInt() + "\t");
				System.out.println(raf.readDouble());

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
