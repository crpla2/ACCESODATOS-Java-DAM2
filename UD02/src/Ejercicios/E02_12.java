package Ejercicios;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/*Realiza una clase UD2_12 con un método principal que reciba dos argumentos, un
directorio y una extensión de fichero, e indique los datos (nombre, tamaño y fecha de creación)
de los ficheros del directorio que tienen esa extensión. Pista: Interfaz FilenameFilter. Deberá
comprobarse al principio del código que el directorio enviado como primer argumento existe,
en caso contrario se indicará y finalizará su ejecución.
 */
public class E02_12 {
		public static void main(String[] args)  {
			// TODO Auto-generated method stub
			if(args.length==0) {
				System.out.println("No se ha recibido ningun argumento");
				System.exit(0);
			}
			else {
				FilenameFilter fil = new FilenameFilter() {
					
					@Override
					public boolean accept(File dir, String name) {
						// TODO Auto-generated method stub
						return false;
					}
				} ;
				File f=new File(args[0]);
				if(f.exists()){
					File[] archivos=f.listFiles(fil);	
				
					
				}
				else {
					System.out.println("El archivo no existe");
					System.exit(-1);
				}
			}
				
	}

}
