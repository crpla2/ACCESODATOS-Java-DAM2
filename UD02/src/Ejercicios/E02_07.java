package Ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Realiza una clase UD2_7 que guarde 20 números enteros aleatorios comprendidos entre
1 y 5 en el fichero puntuación.dat. Completa el código abriendo el fichero para visualizarlos
todos por la consola indicando al final cuántas veces se repiten cada uno de ellos. Incluye
también tratamiento de excepciones.
 */
public class E02_07 {

	public static void main(String[] args) {
		File f = new File("Ficheros/puntuacion.dat");
		int num;
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
			for (int i = 0; i < 20; i++) {
				num=(int)(Math.round(Math.random() * 4) + 1);
				dos.writeInt(num);
				
//				System.out.println(num);
			}dos.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error de escritura");
		} catch (IOException e) {
			System.err.println("Error de escritura");
		}

		DataInputStream dos;
		try {
			dos = new DataInputStream(new FileInputStream(f));

			try {
				while (true) {
					System.out.println(dos.readInt());
					if(dos.readInt()==1);
					if(dos.readInt()==2);
					if(dos.readInt()==3);
					if(dos.readInt()==4);
					if(dos.readInt()==5);
				}
			} catch (EOFException e) {
			}

		} catch (FileNotFoundException e) {
			System.err.println("Error de lectura");
		} catch (IOException e) {
			System.err.println("Error de lectura");
		}

	}
}
