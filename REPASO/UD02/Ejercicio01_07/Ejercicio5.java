package Ejercicio01_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;

/*
 * Realiza una clase UD2_5 que sea capaz de ordenar alfabéticamente las líneas contenidas
en un fichero de texto (puedes crearlo con el bloc de notas). El nombre del fichero que contiene
las líneas se debe pasar como argumento. El nombre del fichero resultado ya ordenado debe ser
el mismo que el original añadiéndole la coletilla _sort al nombre. Incluye también tratamiento
de excepciones.
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		TreeSet<String> lista = new TreeSet<String>();
		File file = new File(args[0]+".txt");
		BufferedReader br;
		BufferedWriter pw;
		try {
			br = new BufferedReader(new FileReader(file));
			String s;
			while ((s = br.readLine()) != null)
				lista.add(s);
			pw = new BufferedWriter(new FileWriter(args[0] + "_sort.txt"));
			lista.forEach(p -> {
				try {
					pw.write(p);
					pw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
