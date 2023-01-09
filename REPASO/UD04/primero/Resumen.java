package primero;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Resumen {
	SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
	Session session;
	Transaction tx;

	// Abrir sesion
	session=sesion.openSession();

////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Buscar socio por ID pasandole un socio
	public int nuevo(Socio socio) {
		// Devuelve un objeto con LOAD -> da ERROR si no lo encuentra
		Socio s = (Socio) session.load(Socio.class, (int) socio.getSocioId());
		// Devuelve un objeto con GET -> devuelve NULL si no lo encuentra
		Socio s = (Socio) session.get(Socio.class, (int) socio.getSocioId());
	}
	
	//Buscamos un jugador pasandole un codigo
	String hql ="from Jugadores as j where j.codigo= :cod"; 
	Jugadores jug = (Jugadores) session.createQuery(hql).setInteger("cod", codigo).uniqueResult();
	
/////////////////////////////////////////////////////////////////////////////////////////////////////

	// Devuelve  lista de socios por localidad pasandole una localidad
	public List<Socio> consulta(String localidad) {
		try {
			Query q;
			if (localidad.isEmpty())
				//Haciendo una consulta 
				q = session.createQuery("from Socio");
				//Llamando a un procedimiento pasandole una localidad vacia
				q = session.createSQLQuery("CALL buscaSocios(:loc)").addEntity(Socio.class).setParameter("loc", "");
			else
				//Haciendo una consulta pasandole una localidad
				q = session.createQuery("from Socio where localidad= :loc").setString("loc",localidad);
				//Llamando a un procedimiento pasandole una localidad
				q = session.createSQLQuery("CALL buscaSocios(:loc)").addEntity(Socio.class).setParameter("loc",
						localidad);
			return q.list();

		} catch (Exception e) {
			return limpia();
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//OPCION 1
	// Devuelve una lista de Equipos
	ArrayList<Equipos>lista= (ArrayList<Equipos>) session.createQuery("FROM Equipos").list();
	System.out.println("Numero de equipos: "+lista.size()+"\n========================================");
	// Recorre los equipos
	for(Equipos e:lista) {
		System.out.println(e.getNombre());
		@SuppressWarnings("unchecked")
		//Crea una lista de array de objetos donde ponemos los resultados de la consulta hql pasando por parametro el nombre del equipo
		ArrayList<Object[]> jugadores=(ArrayList<Object[]>) session.createQuery("SELECT j.codigo, j.nombre, round(avg(e.puntosPorPartido)) "
				+ "FROM Jugadores as j, Estadisticas as e  "
				+ "WHERE e.jugadores.codigo=j.codigo and j.equipos.nombre= :nom group by j.nombre").setString("nom",e.getNombre()).list();
		//Recorremos la lista y sacamos la informacion para imprimirla
		for(Object[] o:jugadores) {
			System.out.println(o[0]+", "+o[1]+", "+o[2]);
		}
		System.out.println("========================================");
	}
//OPCION 2	
	// Devuelve una lista de Equipos
	ArrayList<Equipos> lista = (ArrayList<Equipos>) session.createQuery("FROM Equipos")
			.list();System.out.println("Numero de equipos: "+lista.size());
	// Recorre los equipos
	for(Equipos e:lista){
		System.out.println("=====================================\n" + e.getNombre());
		// Recorre el set de jugadores que hay en equipos
		for (Object o : e.getJugadoreses()) {
			// Carga un jugador de la lista
			Jugadores j = (Jugadores) o;
			// consulta que devuelve la media de puntos del jugador que le pasamos el codigo
			// por parametro
			Double mediaPuntos = (Double) session.createQuery(
					"SELECT round(avg(e.puntosPorPartido),2) FROM Estadisticas as e WHERE e.jugadores.codigo=:cod")
					.setInteger("cod", j.getCodigo()).uniqueResult();
			System.out.println(j.getCodigo() + ", " + j.getNombre() + ", " + mediaPuntos);
		}
	}
//OPCION 3	
	// Devuelve una lista de Equipos
	List<Equipos> lista = session.createQuery("FROM Equipos").list();
	System.out.println("Número de equipos: " + lista.size());
	System.out.println("=============================");
	// Recorre los equipos
	for (Equipos eq : lista) {
		System.out.println("Equipo: " + eq.getNombre());
		//Recorre el set de jugadores que hay en equipos
		for(Object o:eq.getJugadoreses()) {
			String s="";
			Jugadores j=(Jugadores)o;
			s=j.getCodigo()+", "+j.getNombre();				
			double pts=0;
			int cont=0;
			//Recorre el set de estadisticas que hay en jugadores
			for(Object ob:j.getEstadisticases()) {
				//Crea el objeto Estadisticas
				Estadisticas es=(Estadisticas)ob;
				pts+=es.getPuntosPorPartido();
				cont++;
			}
			double mediaD=pts/cont;
			String media;
			if(mediaD==0)media="0";
			
			else if(mediaD>0) {
			DecimalFormat df = new DecimalFormat("#.00");
			media=df.format(pts/cont);}
			else media="Sin registros";
			s+=", "+media;
			System.out.println(s);
			
		}System.out.println("============================");
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// CREATE
	public int nuevo(Empleados empleado) {
		try {
			tx = session.beginTransaction();// INICIO TRANSACCION
			session.save(empleado);// GUARDADO
			tx.commit();// COMMIT
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return 0;
		}
		
	}

	// UPDATE
	public int actualizar(Empleados empleado) {
		try {
			tx = session.beginTransaction();// INICIO TRANSACCION
			session.update(empleado);// ACUALIZACION
			tx.commit();// COMMIT
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return 0;
		}

	}
	
	//SAVE OR UPDATE
	public int actualizar(Empleados empleado) {
		try {
			tx = session.beginTransaction();// INICIO TRANSACCION
			session.saveOrUpdate(empleado);// ACUALIZACION
			tx.commit();// COMMIT
			return 1;
		} catch (Exception e) {
			tx.rolback();
			return 0;
		}

	}

	// DELETE
	public int borrar(Empleados empleado) {
		try {
			tx = session.beginTransaction();// INICIO TRANSACCION
			session.delete(empleado);// BORRADO
			tx.commit();// COMMIT
			return 1;
		} catch (Exception e) {
			tx.rollback();
			System.err.println("No se realizo ningún cambio");
			return 0;
		}
	}

	// Cerrar sesion
	session.close();
}
