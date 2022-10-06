package Ejercicio01_07;

import java.io.File;

/*
 * Realiza una clase UD2_2 cuyo método principal reciba como argumento una cadena con
la trayectoria de un directorio o fichero e indique si existe realmente o no dicho directorio o
fichero. Si el método principal no recibe ningún argumento se indicará por pantalla y finalizará
su ejecución.
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		if(args.length==0) {
			System.err.println("Noo se ha recibido ningún argumento!!!");
			System.exit(-1);
		}
		File f= new File(args[0]);
		if (f.exists())
			System.out.println("Existe un archivo o dierctorio en la trayectoria recibida");
		else System.err.println("No hay nada en la ruta indicada");

	}

}
