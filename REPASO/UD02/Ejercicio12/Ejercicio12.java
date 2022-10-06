package Ejercicio12;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
 * Realiza una clase UD2_12 con un método principal que reciba dos argumentos, un
directorio y una extensión de fichero, e indique los datos (nombre, tamaño y fecha de creación)
de los ficheros del directorio que tienen esa extensión. Pista: Interfaz FilenameFilter. Deberá
comprobarse al principio del código que el directorio enviado como primer argumento existe,
en caso contrario se indicará y finalizará su ejecución.
 */
public class Ejercicio12 {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("No se ha pasado ningún argumento");
			System.exit(-1);
		}
		File file = new File(args[0]);
		if (!file.exists()) {
			System.err.println("No se encuentra el directorio");
			System.exit(-1);
		}
		List<File> lista = Arrays.asList(file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.endsWith(args[1]))
					return true;
				return false;
			}
		}));

		lista.forEach(f -> {
			System.out.println("Nombre: " + f.getName() + "\tTamaño:" + f.length() + "\tCreación: "
					+ new Date(f.lastModified()));
		});

	}

}
