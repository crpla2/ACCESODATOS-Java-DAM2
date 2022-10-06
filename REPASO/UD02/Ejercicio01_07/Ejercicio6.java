package Ejercicio01_07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * Realiza una clase UD2_6 que indique cuántas veces aparece una palabra dentro de un
fichero de texto (puedes crearlo con el bloc de notas). Tanto el nombre del fichero como la
palabra se deben pasar como argumentos. No distinguir mayúsculas/minúsculas. Incluye
también tratamiento de excepciones.
Pistas:
- Métodos para cadenas substring e indexOf.
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		File file= new File(args[0]);
		try {
			BufferedReader br= new BufferedReader(new FileReader(file));
			String s,frase = "";
			int cont=0;
			
			while ((s=br.readLine())!=null) {
				frase+=s;
			}
			
			StringTokenizer st= new StringTokenizer(frase);
			while(st.hasMoreTokens())
				if(st.nextToken().equalsIgnoreCase(args[1]))
					cont++;
			
			System.out.println(cont);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s;

	}

}
