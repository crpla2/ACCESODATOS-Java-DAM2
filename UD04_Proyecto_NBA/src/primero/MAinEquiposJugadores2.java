package primero;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MAinEquiposJugadores2 {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session;
		session = sesion.openSession();

		@SuppressWarnings("unchecked")
		ArrayList<Equipos> lista = (ArrayList<Equipos>) session.createQuery("FROM Equipos").list();
		System.out.println("Numero de equipos: " + lista.size());
		for (Equipos e : lista) {
			System.out.println("=====================================\n" + e.getNombre());
			for (Object o : e.getJugadoreses()) {
				Jugadores j = (Jugadores) o;
				Double mediaPuntos = (Double) session.createQuery(
						"SELECT round(avg(e.puntosPorPartido),2) FROM Estadisticas as e WHERE e.jugadores.codigo=:cod")
						.setInteger("cod", j.getCodigo()).uniqueResult();
				System.out.println(j.getCodigo() + ", " + j.getNombre() + ", " + mediaPuntos);
			}

		}

	}

}
