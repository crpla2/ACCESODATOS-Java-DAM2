package primero;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccesoBd {
	SessionFactory sesion = SessionFactoryUtil.getSessionFactory();;
	Session session;
	Transaction tx;

	public void conectar() throws SQLException, ClassNotFoundException {
		session = sesion.openSession();
	}

	public void desconectar() throws SQLException {
		session.close();
	}

	public List<Socio> consulta(String localidad) {
		try {
			Query q;
			if (localidad.isEmpty())
				//q = session.createQuery("from Socio");
				q = session.createSQLQuery("CALL buscaSocios(:loc)").addEntity(Socio.class).setParameter("loc","");
			else
				// q = session.createQuery("from Socio where localidad= :loc").setString("loc",localidad);
				q = session.createSQLQuery("CALL buscaSocios(:loc)").addEntity(Socio.class).setParameter("loc",
						localidad);
			return q.list();

		} catch (Exception e) {
			return limpia();
		}
	}

	public List<Socio> limpia() {
		List<Socio> lista = new ArrayList();
		return lista;
	}

	public int nuevo(Socio socio) {
		Query q = session.createQuery("select max(socioId) from Socio");
		int id = (int) q.uniqueResult();
		tx = session.beginTransaction();
		socio.setSocioId(id + 1);
		session.save(socio);
		tx.commit();
		return 1;
	}

	public int actualizar(Socio socio) {
		try {
			Socio s = new Socio();
			s = (Socio) session.load(Socio.class, (int) socio.getSocioId());
			s.setEdad(socio.getSocioId());
			s.setNombre(socio.getNombre());
			s.setEstatura(socio.getEstatura());
			s.setEdad(socio.getEdad());
			s.setLocalidad(socio.getLocalidad());
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}

	}

	public int borrar(Socio socio) {
		try {
			Socio s = (Socio) session.load(Socio.class, (int) socio.getSocioId());
			tx = session.beginTransaction();
			session.delete(s);
			tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			System.err.println("No se realizo ningún cambio");
			return 0;
		}
	}

}