package Anexo_III_IV;

import java.sql.CallableStatement;
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
		conecta.setAutoCommit(false);;
	}

	public void desconectar() throws SQLException {
		if (conecta != null) {
			conecta.close();
			conecta.setAutoCommit(true);
		}
	}

	public ResultSet consulta(String localidad) throws SQLException {
		CallableStatement consulta = null;
		consulta=conecta.prepareCall("CALL buscaSocios(?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		consulta.setString(1,localidad);
		ResultSet reg = consulta.executeQuery();
		return reg;
	}

	public ResultSet limpia() throws SQLException {
		
		PreparedStatement consulta;
		String cadenaSQL = "select * from socio where socioID=0";
		consulta = conecta.prepareStatement(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet reg = consulta.executeQuery();
		return reg;
	}

	public int nuevo(Socio socio) {
		try {
			String sql = "insert into socio values (((select max(socioID)from socio s)+1),?,?,?,?)";
			PreparedStatement inserta = conecta.prepareStatement(sql);
			inserta.setString(1, socio.getNombre());
			inserta.setInt(2, socio.getEstatura());
			inserta.setInt(3, socio.getEdad());
			inserta.setString(4, socio.getLocalidad());
			inserta.executeUpdate();
			conecta.commit();
			return 1;
		} catch (SQLException e) {
			System.err.println("ERROR: Deshaciendo cambios");
			try {
				conecta.rollback();
				System.err.println("No se realizo ningún cambio");
			} catch (SQLException e1) {
				System.err.println("ERROR: No se pudieron deshacer los cambios");
			}
			return -1;
		}
	}

	public int actualizar(Socio socio) {
		try {
			String sql = "update socio set nombre=?, estatura=?, edad=?, localidad=? where socioID=?";
			PreparedStatement actualiza = conecta.prepareStatement(sql);
			actualiza.setString(1, socio.getNombre());
			actualiza.setInt(2, socio.getEstatura());
			actualiza.setInt(3, socio.getEdad());
			actualiza.setString(4, socio.getLocalidad());
			actualiza.setInt(5, socio.getId());
			int resultado=actualiza.executeUpdate();
			conecta.commit();
			return resultado;

		} catch (SQLException e) {
			System.err.println("ERROR: Deshaciendo cambios");
			try {
				conecta.rollback();
				System.err.println("No se realizo ningún cambio");
			} catch (SQLException e1) {
				System.err.println("ERROR: No se pudieron deshacer los cambios");
			}
			return 0;
		}

	}

	public int borrar(Socio socio) {
		try {
			String sql = "delete from socio where socioID=?";
			PreparedStatement borra = conecta.prepareStatement(sql);
			borra.setInt(1, socio.getId());
			int resultado= borra.executeUpdate();
			conecta.commit();
			return resultado;
		
		} catch (SQLException e) {
			System.err.println("ERROR: Deshaciendo cambios");
			try {
				conecta.rollback();
				System.err.println("No se realizo ningún cambio");
			} catch (SQLException e1) {
				System.err.println("ERROR: No se pudieron deshacer los cambios");
			}
			return 0;
		}
	}

}