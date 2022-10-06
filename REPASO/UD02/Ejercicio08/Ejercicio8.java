package Ejercicio08;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*
 *  * UD2.8 Adaptación de los ejemplos vistos en los materiales con las clases ObjectInputStream y
ObjectOuputStream. Realiza una clase UD2_8 que pida al usuario datos de varios profesores
(nombre y la antigüedad) y los inserte en el fichero antiguedad.dat_obj.dat. Si el fichero no
existe se creará con los nuevos datos introducidos, en caso contrario se añadirán por el final.
Antes de finalizar el código se recorrerá el fichero para visualizar su contenido. Prueba varias
veces la ejecución de la clase.
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		File file = new File("Ficheros/antiguedad.dat");
		Scanner s = new Scanner(System.in);
		ObjectOutputStream oos;
		ObjectInputStream ois;
		MiObjectOutputStream mosos;

		try {

			System.out.println("Desea introducir algun profesor?(S/N)");
			String respuesta = s.next();
			while (respuesta.equalsIgnoreCase("S")) {
				Profesores profe = new Profesores();
				System.out.println("Introduzca el nombre:");
				profe.setNombre(s.next());
				System.out.println("Introduzca la antiguedad:");
				profe.setAntiguedad(s.nextInt());
				if (file.exists()) {
					mosos = new MiObjectOutputStream(new FileOutputStream(file, true));
					mosos.writeObject(profe);
					mosos.close();
				} else {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(profe);
					oos.close();
				}

				System.out.println("Desea introducir algun profesor?(S/N)");
				respuesta = s.next();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			try {
				while (true) {
					System.out.println(ois.readObject().toString());
				}
			} catch (EOFException e) {
			}
			ois.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
