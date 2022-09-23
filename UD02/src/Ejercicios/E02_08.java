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
	public static class Profesor implements Serializable {
		private String nombre;
		private double antiguedad;

		public Profesor(String nombre, double antiguedad) {
			super();
			this.nombre = nombre;
			this.antiguedad = antiguedad;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getAntiguedad() {
			return antiguedad;
		}

		public void setAntiguedad(double antiguedad) {
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

	public static void main(String[] args) throws InterruptedException {
		Scanner s = new Scanner(System.in);

		System.out.println("¿Cuantos usuarios desea introducir?");
		String nume=s.next();
		while(!esEntero.esNumeroEntero(nume)){
			System.err.println("Debe de introducir un número entero:");
		nume=s.next();
		}
		
		int usu =Integer.parseInt(nume);
		String[] nombres = new String[usu];
		double[] antiguedad = new double[usu];

		for (int i = 0; i < usu; i++) {
			System.out.println("Nombre:");
			nombres[i] = s.next();
			
			System.out.println("Antiguedad:");
			String num=s.next();
			while(!esReal.esNumeroReal(num)){
				System.err.println("Debe de introducir un número:");
			num=s.next();
			}
			antiguedad[i] = Double.parseDouble(num);}

		File f = new File("Ficheros/antiguedad.dat_obj.dat");
		try {

			if (f.exists()) {
				miObjectOutputStream moos = new miObjectOutputStream(new FileOutputStream(f, true));
				for (int i = 0; i < usu; i++) {
					moos.writeObject(new Profesor(nombres[i], antiguedad[i]));
				}moos.close();
			} else {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				for (int i = 0; i < usu; i++) {
					oos.writeObject(new Profesor(nombres[i], antiguedad[i]));
				}oos.close();
			}
		} catch (IOException e) {
			System.err.println("Error de escritura");
		}
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(f));
			try {
				while(true) {
					System.out.println(ois.readObject());
				}
			}catch(EOFException e){} 
			}catch (ClassNotFoundException e) {
				System.err.println("Error de lectura");
			}
			
		 catch (IOException e) {
			 System.err.println("Error de lectura");
		} 
	}

}
