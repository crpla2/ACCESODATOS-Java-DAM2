package Ejercicio13;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/*
 * Realiza una clase UD2_13 que almacene como objetos en un fichero ventas.dat los datos
básicos de los clientes como son el nombre completo (String), teléfono (String), dirección,
(String), nif (String) y moroso (String SI/NO). Deberá codificarse para ellos 2 métodos:
- Introducir en el fichero anterior los datos de los clientes que se pedirán por teclado y
se irán añadiendo al fichero. El atributo moroso no se incluirá en el fichero (aun así debe
pedirse por teclado).
- Visualizar los datos del fichero.
Pista: Modificador transient a la hora de declarar el atributo moroso de la clase anterior.
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		File file = new File("Ficheros/repaso.dat");
		introDatos(file);
		leeDatos(file);
	}

	private static void leeDatos(File f) {
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			try {
				while(true) {
				System.out.println(ois.readUTF());
//				Cliente c= (Cliente) (ois.readObject());
//				System.out.println(c);
				}
				
			}catch(EOFException a){}
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void introDatos(File f) {
		try {
			ObjectOutputStream oos = null;
			MiObjectOS mioos = null;
			Scanner s = new Scanner(System.in);
			System.out.println("Introduzca los datos ");
			Cliente c = new Cliente(s.next(), s.next(), s.next(),s.next());
			if (f.exists()) {
				mioos = new MiObjectOS(new FileOutputStream(f, true));
				mioos.writeObject(c);mioos.close();
			} else {
				oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(c);oos.close();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
