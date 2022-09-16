package Ejercicios;

import java.io.File;

/*Realiza una clase UD2_3 que complete la clase EjemploClaseFile02 de los materiales
borrando el directorio y el fichero creados en ella (primero borra el fichero y después el
directorio pues no se permite borrar directorios no vacíos).
 */
public class E02_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean resultado;
		File fichero= new File ("c:\\DAM2\\Alberto.txt");
		resultado=fichero.delete();
		if (resultado)
			System.out.println("Archivo borrado");
		else
			System.out.println("No se puede borrar el archivo");
			System.exit(-1);//Terminamos
		
		File directorio= new File("c:\\DAM2");
		resultado=directorio.delete();
		if (resultado)
			System.out.println("Directorio borrado");
		else {
			System.out.println("No se puede borrar el directorio");
			
			
		}
	
			
			
			
			
	
		
	}

}
