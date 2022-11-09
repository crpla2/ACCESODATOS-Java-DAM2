package examen;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AccesoBdatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "pedidos4nov22";
    private static String hostname = "localhost";
    private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database +
									"?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "root";
   private static Connection conecta;
	
	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
		
	}
	
	public void desconectar() throws SQLException, ClassNotFoundException {
	//	conecta.setAutoCommit(false);
		conecta = null; // = conecta.close();
	}
	
	public ArrayList<Producto> productosCategoria(int categoria){
		ArrayList<Producto>lista= new ArrayList<Producto>();
		String SQL="SELECT * FROM productos WHERE IdCategoria=?";
		try {
			PreparedStatement ps= conecta.prepareStatement(SQL);
			ps.setInt(1, categoria);
			ResultSet rs= ps.executeQuery();	
			while(rs.next()) {
				Producto p =new Producto(rs.getLong("IdProducto"),rs.getString("NombreProducto"),rs.getLong("IdProveedor"),
						rs.getLong("IdCategoria"),rs.getString("CantidadPorUnidad"),rs.getDouble("PrecioUnidad"),
						rs.getInt("UnidadesEnExistencia"));
				lista.add(p);
			}
			conecta.close();
			return lista;
		} catch (SQLException e) {
			return null;
		}
		
	}
	public int incrementarPrecioProducto (long idProducto, double porcentaje) {
		String SQL="UPDATE productos SET PrecioUnidad=PrecioUnidad+(PrecioUnidad*?) WHERE IdProducto=?";
		PreparedStatement ps;
		
		try {
			conecta.setAutoCommit(false);
			ps = conecta.prepareStatement(SQL);
			ps.setDouble(1, porcentaje);
			ps.setLong(2, idProducto);
		//	conecta.commit();
		//	conecta.setAutoCommit(true);
		//	return ps.executeUpdate();
			int filas=ps.executeUpdate();
			conecta.commit();
			conecta.setAutoCommit(true);
			return filas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conecta.rollback();
				conecta.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 0;
		}
	}

public static Connection getConecta() {
		return conecta;
	}
	
	// COMPLETAR
}