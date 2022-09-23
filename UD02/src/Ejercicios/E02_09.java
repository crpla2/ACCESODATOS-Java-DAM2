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
	 * 
	 * Id (entero – 4 bytes) Nombre (20 caracteres – 40 bytes) Departamento (entero
	 * – 4 bytes) Antigüedad (real – 8bytes)
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		File f = new File("Ficheros/ProfesFPSierraGuara.dat");
		System.out.println("Introduzca el id del profesor:");

		try {
			RandomAccessFile file = new RandomAccessFile(f, "rw");
			int id = s.nextInt();
			int pos = (id - 1) * 56;
			if (pos > f.length() - 56) {
				System.err.println("No existe un profesor con ese ID");
				System.exit(-1);
			}
			file.seek(pos);
			if (file.readInt() == 0) {
				System.err.println("El profesor ya ha sido borrado");
				System.exit(-1);
			}
			file.writeInt(0);
			
			int dept;
			double anti;
			char profes[]=new char[20];
			System.out.println("ID\tNombre\t\tDeparatmento\tAntiguedad");
			file.seek(0);
			id=file.readInt();
			for (int i = 0; i <profes.length ; i++) {
				profes[i]=file.readChar();
			}
			String Profe=new String(profes);
			dept=file.readInt();
			anti=file.readDouble();
			
			System.out.println(id+"\t"+Profe+"\t\t"+dept+"\t"+anti);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
