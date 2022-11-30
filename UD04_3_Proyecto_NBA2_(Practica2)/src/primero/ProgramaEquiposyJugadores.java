package primero;

import java.text.DecimalFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProgramaEquiposyJugadores {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session;
		session = sesion.openSession();
		List<Equipos> lista = session.createQuery("FROM Equipos").list();
		
		System.out.println("Número de equipos: " + lista.size());
		System.out.println("=============================");
		for (Equipos eq : lista) {
			System.out.println("Equipo: " + eq.getNombre());
			for(Object o:eq.getJugadoreses()) {
				String s="";
				Jugadores j=(Jugadores)o;
				s=j.getCodigo()+", "+j.getNombre();				
				double pts=0;
				int cont=0;
				for(Object ob:j.getEstadisticases()) {
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
	}

	
}
