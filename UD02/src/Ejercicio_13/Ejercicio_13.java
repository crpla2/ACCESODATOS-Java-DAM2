package Ejercicio_13;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
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
class ObjectOutputStreamMio extends ObjectOutputStream {

	protected ObjectOutputStreamMio(OutputStream os) throws IOException, SecurityException {
		super(os);
		// TODO Auto-generated constructor stub
	}

	protected void writeStreamHeader() {
	}

}

public class Ejercicio_13 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File f = new File("Ficheros/ventas.dat");
		introducirDatos(f);
		leerDatos(f);
	}

	static void introducirDatos(File f) throws FileNotFoundException, IOException {
		Scanner s = new Scanner(System.in);
		List<Cliente> lista = new ArrayList<>();
		String respuesta = "S";
		System.out.println("Introduzca los datos del cliente:");
		while (respuesta.equalsIgnoreCase("S")) {
			Cliente cliente = new Cliente();
			System.out.print("Nombre completo =>");
			cliente.setNombreCompleto(s.nextLine());
			System.out.print("Número de teléfono =>");
			cliente.setTelefono(s.nextLine());
			System.out.print("Dirección =>");
			cliente.setDireccion(s.nextLine());
			System.out.print("NIF =>");
			cliente.setNif(s.nextLine());
			System.out.print("¿Es moroso?(S/N) =>");
			respuesta = s.nextLine();
			while (!respuesta.equals("S") && !respuesta.equals("N")) {
				System.out.println("Teclee \"S\" si es moroso o \"N\" si no.");
				respuesta = s.nextLine();
			}
			cliente.setMoroso(respuesta);
			lista.add(cliente);
			System.out.println("¿Desea introducir un nuevo cliente?(S/N)");
			respuesta = s.nextLine();
			while (!respuesta.equals("S") && !respuesta.equalsIgnoreCase("N"))
				System.out.println("Teclee \"S\" en caso afirmativo o \"N\" para terminar.");
			try {
				if (!f.exists()) {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
					for (Cliente cli : lista)
						oos.writeObject(cli);

				} else {
					ObjectOutputStreamMio oosM = new ObjectOutputStreamMio(new FileOutputStream(f, true));
					for (Cliente cli : lista)
						oosM.writeObject(cli);
				}

			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

		}
	}

	private static void leerDatos(File f) {
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(f));
			try {
				while(true) {
					System.out.println(ois.readObject());
			} catch{EOFException o}
			  catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}}
	}
}
