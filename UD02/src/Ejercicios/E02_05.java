package Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Realiza una clase UD2_5 que sea capaz de ordenar alfabéticamente las líneas contenidas
en un fichero de texto (puedes crearlo con el bloc de notas). El nombre del fichero que contiene
las líneas se debe pasar como argumento. El nombre del fichero resultado ya ordenado debe ser
el mismo que el original añadiéndole la coletilla _sort al nombre. Incluye también tratamiento
de excepciones.
 */
public class E02_05 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new FileReader("Ficheros\\"+args[0]+".txt"));
		String linea;
		ArrayList<String>lista=new ArrayList<String>();
		while((linea=br.readLine())!=null) {
			lista.add(linea);
		}br.close();
		Collections.sort(lista);
				
		BufferedWriter bw= new BufferedWriter(new FileWriter("Ficheros\\"+args[0]+"_sort.txt"));
		for (String string : lista) {
			bw.write(string);
			bw.newLine();
		}bw.close();
	}

}
