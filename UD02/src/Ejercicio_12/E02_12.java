package Ejercicio_12;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Realiza una clase UD2_12 con un método principal que reciba dos argumentos, un
directorio y una extensión de fichero, e indique los datos (nombre, tamaño y fecha de creación)
de los ficheros del directorio que tienen esa extensión. Pista: Interfaz FilenameFilter. Deberá
comprobarse al principio del código que el directorio enviado como primer argumento existe,
en caso contrario se indicará y finalizará su ejecución.
 */
public class E02_12 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			System.out.println("No se ha recibido ningun argumento");
			System.exit(0);
		} else {
			File directorio = new File(args[0]);
			// Creo una lista filtrandola por el valor de args[1]
			File[] lista = directorio.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File file, String name) {
					// TODO Auto-generated method stub
					if (name.endsWith(args[1])) {
						return true;
					}
					return false;
				}

			});

			for (File fichero : lista) {

				System.out.println("Nombre:\t" + fichero.getName());
				System.out.println("Tamaño:\t" + fichero.length() + " bytes");

				// Para sacar fecha de creacion del archivo
				BasicFileAttributes attrs = null;
				try {
					attrs = Files.readAttributes(fichero.toPath(), BasicFileAttributes.class);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileTime time = attrs.creationTime();
				//Recibo un timestamp que formateo para sacarlo como fecha y hora
				String pattern = "dd-MM-yyyy HH:mm:ss";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String formatted = simpleDateFormat.format(new Date(time.toMillis()));

				System.out.println("Creado:\t" + formatted + "\n");
			}
		}
	}
}
