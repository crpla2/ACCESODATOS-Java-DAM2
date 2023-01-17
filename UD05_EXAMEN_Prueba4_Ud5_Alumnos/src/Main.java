
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {

		AccesoBdatos abd = new AccesoBdatos();
		abd.conectar();
	//System.out.println(abd.pregunta1(3, "222222"));// true y la modifica
//	System.out.println(abd.pregunta1(44, "123456"));// false pues no existe la tienda 44
	System.out.println(abd.pregunta2());// 15
		// --------------------------------
		 abd.pregunta3("3DSNG", 1);
		// Total unidades del producto 3DSNG en la tienda 1 --> 2
		 abd.pregunta3("3DSNG", 3);
		// Total unidades del producto 3DSNG en la tienda 3 --> 0
		// ---------------------------------
		 abd.pregunta4();
		/*
		 * Productos distintos: 25
		 * 
		 * Producto: Archos Clipper MP3 2GB negro, disponible en 2 tienda(s), total Unidades 3 
		 * Producto: Asus EEEPC 1005PXD N455 1 250 BL, disponible en 2 tienda(s), total Unidades 3 
		 * ... 
		 * ... 
		 * Producto: Sony Bravia 32IN FULLHD KDL-32BX400, disponible en 1 tienda(s), total Unidades 1 
		 * Producto: Toshiba SD16GB Class10 Jewel Case, disponible en 1 tienda(s), total Unidades 2
		 */
		// -----------------------------------
		 abd.pregunta5();
		/*
		 * Producto (nombre corto) - Precio - Familia
		 * ================================================= Acer AX3950 I5-650 4GB 1TB
		 * W7HP - 410.00 - Ordenadores
		 */
		abd.desconectar();

	}

}
