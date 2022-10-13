package pregunta3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
	static Scanner s = new Scanner(System.in);
	static List<Empleado> lista;
	static Empleado[] e;

	public static void main(String[] args) throws IOException {

		lista = new ArrayList<>();
		Gson gson = new Gson();
		String sFichero = new String(Files.readAllBytes(Paths.get("Ficheros/empleados.json")));
		e = gson.fromJson(sFichero, Empleado[].class);
		lista = Arrays.asList(e);

		empleadosOficio();
		
	}
	;
	private static void empleadosOficio() {
		System.out.println("Introduzca el oficio: ");
		String oficio = s.next();
		String respuesta = "";
		int contador = 0;
		List<Empleado> PorOficio=new ArrayList<>();
		for (Empleado e : lista) {
			if (e.getOficio().equalsIgnoreCase(oficio)) {
				contador++;
			    PorOficio.add(e);
			   }
		}
		
		double min =PorOficio.get(0).getSalario();
		System.out.println(min);
		for (int i = 0; i < e.length; i++) {

			if (e[i].getSalario() < min && e[i].getOficio().equalsIgnoreCase(oficio))
				min = e[i].getSalario();
		}

		if (contador == 0)
			respuesta = "No existen empleados de oficio " + oficio.toUpperCase();
		else
			respuesta = contador + " empleados de oficio: " + oficio.toUpperCase() + "\nEl salario mínimo del "
					+ oficio.toUpperCase() + " es " + min;
		System.out.println(respuesta);

	}

}
