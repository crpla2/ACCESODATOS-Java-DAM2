package Ejercicio_01_09;

import java.io.File;
import java.util.Scanner;

/*Realiza una clase UD2_2 cuyo método principal reciba como argumento una cadena con
la trayectoria de un directorio o fichero e indique si existe realmente o no dicho directorio o
fichero. Si el método principal no recibe ningún argumento se indicará por pantalla y finalizará
su ejecución.
 */
public class E02_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==0) {
			System.err.println("No se ha recibido ningun argumento");
			System.exit(0);
		}
		else {
			File f=new File(args[0]);
			if(f.exists()) {
				if(f.isFile())
					System.out.println("El fichero existe");
				if(f.isDirectory())
					System.out.println("El directorio existe");
			}
			else
				System.out.println("No existe el archivo o directorio");
		}
		
	}
	
}
