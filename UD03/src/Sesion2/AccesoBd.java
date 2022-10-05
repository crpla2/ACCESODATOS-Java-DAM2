package Sesion2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBd {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "baloncesto";
	private static String hostname = "localhost";
	private static String port = "3306";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
			+ "?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "root";
	static ResultSet reg;
	private Connection conecta;
	
	

	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}

	public void desconectar() throws SQLException {
		if (conecta != null) {
			conecta.close();
		}
	}
	
	public ResultSet consulta(String localidad) throws SQLException {
		PreparedStatement consulta;
		String cadenaSQL = "SELECT * FROM socio ";
		if (localidad.isEmpty()) {
			consulta = conecta.prepareStatement(cadenaSQL);
		} else {
			cadenaSQL = "SELECT * FROM socio  where localidad = ?";
			consulta = conecta.prepareStatement(cadenaSQL);
			consulta.setString(1, localidad);
		}

		ResultSet reg = consulta.executeQuery();
		return reg;
	}

	
	public int nuevo(Socio socio) {
		try {
			String sql="insert into socio values (?,?,?,?)";
			PreparedStatement inserta =conecta.prepareStatement(sql);
			inserta.setInt(1,socio.getId());
			inserta.setString(2,socio.getNombre());
			inserta.setInt(3,socio.getEstatura());
			inserta.setInt(4,socio.getEdad());
			inserta.setString(5, socio.getLocalidad());
			inserta.executeUpdate();
			return 1;
		} catch(SQLException e){
			return e.getErrorCode();
		}
	}
	
	public int actualizar(Socio socio) {
		try {
			String sql="update socio set nombre=?, estatura=?, edad=?, localidad=? where socioID=?";
			PreparedStatement actualiza = conecta.prepareStatement(sql);
			actualiza.setString(1,socio.getNombre());
			actualiza.setInt(2,socio.getEstatura());
			actualiza.setInt(3,socio.getEdad());
			actualiza.setString(4, socio.getLocalidad());
			actualiza.setInt(5,socio.getId());
			return actualiza.executeUpdate();
			
		} catch(SQLException e){
		return 0;
		}

	}
	


}
