package prueba;

import primero.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//

public class AccesoBdatos {
	private SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
	private Session session = sesion.openSession();

	public void conectar() {
		sesion = SessionFactoryUtil.getSessionFactory();
		session = sesion.openSession();
	}

	public void desconectar() {
		session.close();
		sesion.close();
		System.exit(0);
	}

	public boolean pregunta1(String nombre, String telefono) {
		Tienda tienda = new Tienda(nombre);
		tienda.setTlf(telefono);
		Transaction tx = null;
		if (nombre == null || nombre.equals("")) {
			return false;
		} else {
			try {
				tx = session.beginTransaction();
				session.save(tienda);
				tx.commit();
				return true;
			} catch (Exception e) {
				tx.rollback();
				return false;
			}
		}

	}

	public boolean pregunta2(int codigo, String telefono) {
		Tienda tienda = (Tienda) session.get(Tienda.class, (Integer) codigo);
		
		Transaction tx = null;
		try {
			tienda.setTlf(telefono);
			
			tx = session.beginTransaction();
			session.update(tienda);
			tx.commit();
			return true;
		} catch (Exception e) {
			if(tx!=null)
			tx.rollback();
			return false;
		}
	}

	public long pregunta3() {
		long totalFamilias = (long) session.createQuery("SELECT count(*) FROM Familia").uniqueResult();
		return totalFamilias;

	}

	public void pregunta4(String codigoP, int codigoT) {
		Integer totalStock = (Integer) session
				.createQuery("SELECT unidades FROM Stock WHERE tienda=:T and producto.cod=:P ").setInteger("T", codigoT)
				.setString("P", codigoP).uniqueResult();
		if (totalStock == null)
			totalStock = 0;
		System.out.println(
				"Total de unidades del producto " + codigoP + " en la tienda " + codigoT + " --> " + totalStock);

	}

	public void pregunta5() {
		@SuppressWarnings("unchecked")
		List<String> productosID = session.createSQLQuery(
				"SELECT distinct producto FROM stock" )
				.list();
		System.out.println("Productos distintos: "+productosID.size());
		System.out.println();
		for (String o : productosID) {
				Producto p= (Producto)session.get(Producto.class, (String)o);
				Object[] res=(Object[]) session.createQuery(
						"SELECT count(tienda),sum(unidades) FROM Stock WHERE producto.cod=:cod")
						.setString("cod",o ).uniqueResult();
		System.out.println("\tProducto: "+p.getNombreCorto()+", disponible en "+res[0]+" tiendas, total Unidades "+res[1]);
		}
	}

	public void pregunta6() {
		@SuppressWarnings("unchecked")
		List<Object[]> productosSinStock = session.createSQLQuery(
				"SELECT nombre_corto, PVP,familia FROM producto where cod not in (select producto from stock)")
				.list();
		System.out.println("Producto (nombre corto) - \tPrecio -\tFamilia\n=======================================================");
		for(Object[]o:productosSinStock) {
			Familia f=(Familia)session.get(Familia.class, (Serializable) o[2]);
			System.out.println(o[0]+" - "+o[1]+" - "+f.getNombre());
		}
		
	} 
}// de la clase AccesoBdatos
