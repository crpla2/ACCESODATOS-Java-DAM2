package Ejercicios;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

/*
 * UD2.8 Adaptación de los ejemplos vistos en los materiales con las clases ObjectInputStream y
ObjectOuputStream. Realiza una clase UD2_8 que pida al usuario datos de varios profesores
(nombre y la antigüedad) y los inserte en el fichero antiguedad.dat_obj.dat. Si el fichero no
existe se creará con los nuevos datos introducidos, en caso contrario se añadirán por el final.
Antes de finalizar el código se recorrerá el fichero para visualizar su contenido. Prueba varias
veces la ejecución de la clase.
 */
public class E02_08 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException {
		File f = new File("Ficheros/antiguedad.dat_obj.dat");
		int usuarios = usuarios();
		String[] nombres = new String[usuarios];
		double[] antiguedad = new double[usuarios];

		for (int i = 0; i < usuarios; i++) {
			nombres[i] = nombre();
			antiguedad[i] = antiguedad();
		}
		escritura(f, usuarios, nombres, antiguedad);
		lectura(f, usuarios, nombres, antiguedad);
		s.close();	
	}
	//clases////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("serial")
	public static class Profesor implements Serializable {
		private String nombre;
		private double antiguedad;

		public Profesor(String nombre, double antiguedad) {
			super();
			this.nombre = nombre;
			this.antiguedad = antiguedad;
		}

		@Override
		public String toString() {
			return "Profesor [nombre=" + nombre + ", antiguedad=" + antiguedad + "]";
		}

	}
	public static class miObjectOutputStream extends ObjectOutputStream {

		public miObjectOutputStream(OutputStream arg0) throws IOException {
			super(arg0);
			// TODO Auto-generated constructor stub
		}

		protected void writeStreamHeader() throws IOException {

		}

	}
	//metodos de insercion de datos/////////////////////////////////////////////////////////
	public static int usuarios() {
		System.out.println("¿Cuantos usuarios desea introducir?");
		String nume = s.next();
		while (!esEntero.esNumeroEntero(nume) || !(Integer.parseInt(nume) >= 0)) {
			System.err.println("Debe de introducir un número entero positivo:");
			nume = s.next();
		}
		int usu = Integer.parseInt(nume);
		return usu;
	}
	public static String nombre() {
		System.out.println("Nombre:");
		String nombre = s.next();
		while (!nombre.matches("[a-zA-Z.Ññ]+")) {
			System.err.println("Debe de introducir un nombre válido:");
			nombre = s.next();
		}
		return nombre;
	}
	public static double antiguedad() {
		System.out.println("Antiguedad:");
		String numS = s.next();
		while (!esReal.esNumeroReal(numS) || !(Double.parseDouble(numS) > 0)) {
			System.err.println("Debe de introducir un número real positivo:");
			numS = s.next();
		}
		double num = Double.parseDouble(numS);
		return num;
	}
	//metodos de escritura/lectura del archivo/////////////////////////////////////////////
	public static void escritura(File f,int usuarios,String[]nombres,double[]antiguedad) {
		miObjectOutputStream moos;ObjectOutputStream oos;
		try {
			if (f.exists()) {
				moos = new miObjectOutputStream(new FileOutputStream(f, true));
				for (int i = 0; i < usuarios; i++) {
					moos.writeObject(new Profesor(nombres[i], antiguedad[i]));
				}
				moos.close();
			} else {
				oos= new ObjectOutputStream(new FileOutputStream(f));
				for (int i = 0; i < usuarios; i++) {
					oos.writeObject(new Profesor(nombres[i], antiguedad[i]));
				}
				oos.close();
			}
		} catch (IOException e) {
			System.err.println("Error de escritura");
		}
	}
	public static void lectura(File f,int usuarios,String[]nombres,double[]antiguedad) {
		ObjectInputStream ois;
		try {
			ois= new ObjectInputStream(new FileInputStream(f));
			try {	
				while (true) {	
					System.out.println(ois.readObject());
				}
			} catch (EOFException e) {}
			ois.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Error de lectura" + e.getException());
		} catch (IOException e) {
			System.err.println("Error de lectura IOException");
		}
	}
	
}
