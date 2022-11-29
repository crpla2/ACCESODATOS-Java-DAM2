package primero;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProgramaEstadisticas {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session;
		session = sesion.openSession();
		int codigo;
		Scanner s = new Scanner(System.in);

		System.out.println("Introduzca un código de jugador:");
		codigo= s.nextInt();
		String hql ="from Jugadores as j where j.codigo= :cod"; 
		Jugadores jug = (Jugadores) session.createQuery(hql).setInteger("cod", codigo).uniqueResult();
		
		System.out.println("DATOS DEL JUGADOR: "+jug.getCodigo());
		System.out.println("Nombre: "+jug.getNombre());
		System.out.println("Equipo: "+jug.getEquipos().getNombre());
		System.out.println("\nTemporada\tPtos\tAsis\tTap\tReb");
		System.out.println("=============================================");
	
		for(Object e: jug.getEstadisticases()) {
			Estadisticas es=(Estadisticas)e;
			System.out.println(es.getId().getTemporada()+"\t\t"+es.getPuntosPorPartido()+"\t"+es.getAsistenciasPorPartido()+"\t"+es.getTaponesPorPartido()+"\t"+es.getRebotesPorPartido());
			
		}
		System.out.println("\n=============================================");
		System.out.println("Número de registros: "+jug.getEstadisticases().size());
		System.out.println("=============================================");
		
		
		
		
		
		
		
		
		session.close();

	}

}
