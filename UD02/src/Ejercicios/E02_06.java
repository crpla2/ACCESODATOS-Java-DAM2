package Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Realiza una clase UD2_6 que indique cuántas veces aparece una palabra dentro de un
fichero de texto (puedes crearlo con el bloc de notas). Tanto el nombre del fichero como la
palabra se deben pasar como argumentos. No distinguir mayúsculas/minúsculas. Incluye
también tratamiento de excepciones.
 */
public class E02_06 {

	public static void main(String[] args) {
		String cadena = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("Ficheros\\" + args[0]));
			String linea = "";
			while ((linea = br.readLine()) != null) {
				cadena += linea.toLowerCase();
			}
			br.close();

		} catch (IOException eo) {
			System.err.println("Se ha producido un error de lectura");
		}

		int cont = 0;
		while (cadena.indexOf(args[1].toLowerCase()) != -1) {
			cadena = cadena.substring(cadena.indexOf(args[1]) + (args[1].length()));
			cont++;
		}

		System.out.println("La palabra \""+args[1]+"\" se repite " + cont + " veces");
	}

}
//Palabras Frecuencia
//===================
//voluptatem	4
//quia			4
//qui			4
//sed			3
//sit			3
//eum			2
//aut			2
//voluptas		2
//enim			2
//dolorem		2
//velit			2
//quis			2
//consequatur	2
//vel			2

//Texto:
//=====	
//"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa 
//quae ab illo inventore veritatis et quasi architecto beatae vitaedicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit 
// aspernatur aut odit aut fugit, sed quia consequuntur magni dolores  eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, 
// qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore 
// magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut 
// aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit  qui in ea voluptate velit esse quam nihil molestiae consequatur,
// vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"