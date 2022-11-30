package primero;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainEquiposJugadores {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session;
		session = sesion.openSession();
		
		
		
		ArrayList<Equipos>lista= (ArrayList<Equipos>) session.createQuery("FROM Equipos").list();
		System.out.println("Numero de equipos: "+lista.size()+"\n========================================");
		for(Equipos e:lista) {
			System.out.println(e.getNombre());
			@SuppressWarnings("unchecked")
			ArrayList<Object[]> jugadores=(ArrayList<Object[]>) session.createQuery("SELECT j.codigo, j.nombre, round(avg(e.puntosPorPartido)) "
					+ "FROM Jugadores as j, Estadisticas as e  WHERE e.jugadores.codigo=j.codigo and j.equipos.nombre= :nom group by j.nombre").setString("nom",e.getNombre()).list();
			for(Object[] o:jugadores) {
				System.out.println(o[0]+", "+o[1]+", "+o[2]);
			}
			System.out.println("========================================");
		}
	}

}
