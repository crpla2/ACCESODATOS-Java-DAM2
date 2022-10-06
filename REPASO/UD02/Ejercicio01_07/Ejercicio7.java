package Ejercicio01_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  Realiza una clase UD2_7 que guarde 20 números enteros aleatorios comprendidos entre
1 y 5 en el fichero puntuación.dat. Completa el código abriendo el fichero para visualizarlos
todos por la consola indicando al final cuántas veces se repiten cada uno de ellos. Incluye
también tratamiento de excepciones.
 */
public class Ejercicio7 {

	public static void main(String[] args) {
		DataOutputStream dos;
		DataInputStream dis;
		int numero;
		try {
			dos = new DataOutputStream(new FileOutputStream("Ficheros/puntuacion.dat"));
			for (int i = 0; i < 20; i++) {
				numero = (int) (Math.random() * 5 + 1);
				dos.writeInt(numero);
			}
			dos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Numeros: ");
		try {
			dis = new DataInputStream(new FileInputStream("Ficheros/puntuacion.dat"));
			int num, uno = 0, two = 0, tres = 0, cuatro = 0, cinco = 0;
			try {
				while (true) {
					num = dis.readInt();
					System.out.print(num + "-");
					switch (num) {
					case 1:
						uno++;
						break;
					case 2:
						two++;
						break;
					case 3:
						tres++;
						break;
					case 4:
						cuatro++;
						break;
					case 5:
						cinco++;
						break;
					default:
						break;
					}

				}

			} catch (EOFException e) {
			}
			System.out.println("\n1: " + uno + " veces," + " 2: " + two + " veces," + " 3: " + tres + " veces," + " 4: "
					+ cuatro + " veces," + " 5: " + cinco + " veces.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
