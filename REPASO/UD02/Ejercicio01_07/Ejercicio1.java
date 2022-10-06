package Ejercicio01_07;

import java.io.File;

/*
 * Realiza una clase UD2_1 que muestre nombre, longitud, si se puede leer, si se puede
escribir de todos los archivos ocultos de la carpeta Windows de tu disco; sólo de los que se
encuentran en la carpeta principal de Windows, no en sus subcarpetas.
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		if (args[0].length()==0) {
			System.err.println("No se ha recibido ningún argumento");
			System.exit(-1);
		}
		File f= new File(args[0]);
		if(!f.exists()||f.isFile()) {
			System.err.println("La ruta especificada no corresponde con ningún directorio");
			System.exit(-1);
		}
		File[]lista= new File[args.length];
		lista=f.listFiles();
		int ocultos=0;
		for(File file: lista) {
			if(!file.isHidden()||file.isDirectory());
			else {
				System.out.println(file.getName());
				System.out.println("\tLongitud => "+file.length());
				System.out.println("\tSe puede leer? => "+file.canRead());
				System.out.println("\tSe puede escribir? => "+file.canWrite()+"\n");
				ocultos++;
			}
		}System.out.println("Total de archivos "+lista.length+", ocultos: "+ocultos);
		}

}
