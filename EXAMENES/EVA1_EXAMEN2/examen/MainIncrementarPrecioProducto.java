package examen;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainIncrementarPrecioProducto {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AccesoBdatos abd=new AccesoBdatos();
		abd.conectar();
		//long idProducto =3; // Sirope de regaliz - 10� el precio por unidad
		//System.out.println(abd.incrementarPrecioProducto(idProducto, 0.05));
		// Imprime 1 y ha incrementado el Sirope de 10� a 10,5�  (un 5%)
		/**********************************************************************************/
		//long idProducto = 77; // Salsa verde - 13� el precio por unidad
		//System.out.println(abd.incrementarPrecioProducto(idProducto, 0.25));
		// Imprime 1 y ha incrementado la Salsa verde de 13� a 16,25� (un 25%)
		/***********************************************************************************/
		long idProducto = 80;
		System.out.println(abd.incrementarPrecioProducto(idProducto, 0.1));	
		//Devuelve 0 pues no puedo incrementar un 10% a un producto que no existe
		abd.desconectar();
	}
}
