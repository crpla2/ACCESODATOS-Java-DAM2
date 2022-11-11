package primero;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccesoBd {
	SessionFactory sesion=SessionFactoryUtil.getSessionFactory();;
	Session session;
	Transaction tx;
	
	public void conectar() throws SQLException, ClassNotFoundException {
		 session=sesion.openSession();
	}

	public void desconectar() throws SQLException {
		session.close();
	}

	public List<Socio> consulta(String localidad) {
			
		Query q;
		if (localidad.isEmpty())
			q= session.createQuery("from Socio");
		else
			q= session.createQuery("from Socio where localidad= :loc").setString("loc", localidad);
		return q.list();
	}
	
	public List<Socio> limpia(){
		List<Socio>lista= new ArrayList();
		lista.add(new Socio(0, " ",0,0," "));
		return lista;
	}
	
	public int nuevo(Socio socio) {
		
		Query q=session.createQuery("select max(socioId) from Socio");
		int id=(int) q.uniqueResult();
		tx= session.beginTransaction();
		socio.setSocioId(id+1);
		session.save(socio);
		tx.commit();
		
		return 1;
	}

	public int actualizar(Socio socio) {
		Socio s= new Socio();
		s=(Socio)session.load(getClass(), socio.getSocioId());
		s.setEdad(socio.getSocioId());
		s.setNombre(socio.getNombre());
		s.setEstatura(socio.getEstatura());
		s.setEdad(socio.getEdad());
		s.setLocalidad(socio.getLocalidad());
		session.update(s);
		tx.commit();
			return 1;
	}
/*
	public int borrar(Socio socio) {
		try {
			String sql = "delete from socio where socioID=?";
			PreparedStatement borra = conecta.prepareStatement(sql);
			borra.setInt(1, socio.getSocioId());
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
*/
}