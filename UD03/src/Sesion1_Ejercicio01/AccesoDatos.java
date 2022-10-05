package Sesion1_Ejercicio01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class AccesoDatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "baloncesto";
	private static String hostname = "localhost";
	private static String port = "3309";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database+ "?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "root";

	// NUNCA CONECTARSE CON USUARIO ROOT!!!!!!!!!!!!!!!!!!!
	// SOLO PARA PRUEBAS!!!!!!!

	private Connection conecta;
		
	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}
	
	public List<Socio> listasocios() throws SQLException{
		List<Socio>lista=new ArrayList<>();
		String consulta="SELECT * FROM socio";
		PreparedStatement ps=conecta.prepareStatement(consulta);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			lista.add(new Socio(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getString(5)));
		}
		return lista;
	}
	
	public boolean exportarjSON(List lista,String ruta) {
		FileWriter fw;
		try {
			fw = new FileWriter(new File(ruta));
			new Gson().toJson(lista,fw);
			fw.close();
			return true;
		} catch (IOException e) {
			return false;
		} catch (JsonIOException e) {
			return false;
		}
		
		
		
	}

	public void desconectar() throws SQLException {
		if (conecta != null) {
			conecta.close();
		}
	}

}

