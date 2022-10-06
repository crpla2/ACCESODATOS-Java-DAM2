package Ejercicio09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio09_2 {

	public static void main(String[] args) {
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
		File file= new File("Ficheros/ProfesFPSierraGuara (1).dat");
		int id = 2;
		try {
			RandomAccessFile raf= new RandomAccessFile(file, "rw");
			int posicion= (id-1)*56;
			if (posicion<0 || posicion>file.length()) {
				System.out.println("no hay nada que borrar");
			System.exit(-1);}
			else {
			raf.seek(posicion);
			raf.writeInt(0);
			}
			raf.seek(0);
	//while(raf.getFilePointer()!=raf.length()) {
		for (int i = 0; i < raf.length()/56; i++) {
			System.out.print(raf.readInt()+"  ");
			String nombre="";
			for (int j = 0; j < 20; j++) {
				nombre+=raf.readChar();
			}
			System.out.print(nombre+"  ");
			System.out.print(raf.readInt()+"  ");
			System.out.print(raf.readDouble()+"  \n");
			
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
