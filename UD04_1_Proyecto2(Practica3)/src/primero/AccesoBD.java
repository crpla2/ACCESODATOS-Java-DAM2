package primero;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccesoBD {
	SessionFactory sesion = SessionFactoryUtil.getSessionFactory();;
	Session session;
	Transaction tx;

	public void conectar() throws SQLException, ClassNotFoundException {
		session = sesion.openSession();
	}

	public void desconectar() throws SQLException {
		session.close();
	}

	public Empleados consulta(short numero) {
		
		try {
			Empleados e= (Empleados) session.get(Empleados.class, (short)numero);
			return e;
		} catch (Exception e) {
		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<Departamentos> listaDep(){
		Query q = session.createQuery("from Departamentos");
		List <Departamentos> lista = q.list();
		return (ArrayList<Departamentos>) lista;
	}
	
	public ArrayList<Empleados> listaDire(){
		Query q = session.createQuery("from Empleados");
				List <Empleados> lista = q.list();
		return (ArrayList<Empleados>) lista;
	}

	public int nuevo(Empleados empleado) {
		try {
		tx = session.beginTransaction();
		session.save(empleado);
		tx.commit();
		return 1;}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
//
//	public int actualizar(Socio socio) {
//		try {
//			Socio s = new Socio();
//			s = (Socio) session.load(Socio.class, (int) socio.getSocioId());
//			s.setEdad(socio.getSocioId());
//			s.setNombre(socio.getNombre());
//			s.setEstatura(socio.getEstatura());
//			s.setEdad(socio.getEdad());
//			s.setLocalidad(socio.getLocalidad());
//			tx = session.beginTransaction();
//			session.update(s);
//			tx.commit();
//			return 1;
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return -1;
//		}
//
//	}
//
//	public int borrar(Socio socio) {
//		try {
//			Socio s = (Socio) session.load(Socio.class, (int) socio.getSocioId());
//			tx = session.beginTransaction();
//			session.delete(s);
//			tx.commit();
//			return 1;
//		} catch (Exception e) {
//			tx.rollback();
//			System.err.println("No se realizo ningún cambio");
//			return 0;
//		}
//	}

}
