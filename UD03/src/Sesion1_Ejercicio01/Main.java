package Sesion1_Ejercicio01;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		AccesoDatos ac= new AccesoDatos();
		try {
			ac.conectar();
			System.out.println(ac.exportarjSON(ac.listasocios(),"Ficheros/socios.json"));
			ac.desconectar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
