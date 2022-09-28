package Ejercicio_01_09;

import java.io.File;

/*Realiza una clase UD2_1 que muestre nombre, longitud, si se puede leer, si se puede
escribir de todos los archivos ocultos de la carpeta Windows de tu disco; sólo de los que se
encuentran en la carpeta principal de Windows, no en sus subcarpetas.
 */
public class E02_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f= new File("c:\\windows");
		File[] ocultos=f.listFiles();
			for(File oculto:ocultos) {
				if(oculto.isHidden()) {				
				System.out.println("Nombre: "+ oculto.getName());
				System.out.println("Longitud: "+ oculto.length());
				System.out.println("Se puede leer: "+ oculto.canRead());
				System.out.println("Se puede escribir: "+ oculto.canWrite());
				System.out.println();
			}
		}
	}

}
