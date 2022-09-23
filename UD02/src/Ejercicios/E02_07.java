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

		DataInputStream dis;
		try {
			dis = new DataInputStream(new FileInputStream(f));
			int uno = 0,two = 0,tres = 0,cuatro = 0,cinco = 0;
			System.out.println("NÚMEROS:\n=======");
			try {
				while (true) {
					num=dis.readInt();
					System.out.print(num+"-");
					if(num==1)uno++;
					if(num==2)two++;
					if(num==3)tres++;
					if(num==4)cuatro++;
					if(num==5)cinco++;
				}
			} catch (EOFException e) {}
			dis.close();
			System.out.println("\n\nNÚMERO DE REPETICIONES:\n======================");
			System.out.println("1: "+uno+" rep, 2: "+two+" rep, 3: "+tres+" rep, 4: "+cuatro+" rep, 5: "+cinco+" rep.");

		} catch (FileNotFoundException e) {
			System.err.println("Error de lectura");
		} catch (IOException e) {
			System.err.println("Error de lectura");
		}

	}
}
