package examen;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainProductosCategoria {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AccesoBdatos abd=new AccesoBdatos();
		abd.conectar();
		int categoria =7;
		System.out.println("Todos los productos de la categoria: "+categoria);
		ArrayList<Producto> lista = abd.productosCategoria(categoria);
		for (Producto p : lista)
			System.out.println(p);
		System.out.println("Fin listado");
		abd.desconectar();
	}
}

