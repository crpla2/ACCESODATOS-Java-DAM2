package Ejercicio01_07;

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
 * 
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		File file=new File("Ficheros/pares.txt");
		BufferedWriter bw;
		BufferedReader br;
		try {
		bw= new BufferedWriter(new FileWriter(file));
			
			for (int i = 0; i <=250; i++) {
				bw.write(Integer.toString(i*2));
				bw.newLine();
			}bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br= new BufferedReader(new FileReader(file));
			String s;
			while((s=br.readLine())!=null) {
				System.out.println(s);
				
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
