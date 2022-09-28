package Ejercicio_01_09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Realiza una clase UD2_4 que guarde en un fichero con nombre pares.txt los números
pares que hay entre 0 y 500, un número en cada línea del fichero. Seguidamente lee el fichero y
muéstralo por la consola. Incluye también tratamiento de excepciones.
 */
public class E02_04 {

	public static void main(String[] args) {
		// ESCRIBIENDO
		File f =new File("Ficheros\\pares.txt");
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(f));
			String num;
			for (int i = 0; i <=500; i++) {
				if (i%2==0) {
					num= Integer.toString(i);
					bw.write(num);
					bw.newLine();
				}
			
			}
			bw.close();
		} catch (IOException e) {
			System.err.println("Se ha producido un error de lectura");
		} 
		// LEYENDO
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String linea;
			while((linea= br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Se ha producido un error de escritura");
		}
	}
}
