package ejemplo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//
// Alberto Carrera Mart�n - Abril 2020
//

public class AccesoBdatos {
	private EntityManagerFactory emf;
	private EntityManager em;

	public void conectar() {
		emf = Persistence.createEntityManagerFactory("db/empleados.odb");
		em = emf.createEntityManager();
	}

	public void desconectar() {
		em.close();
		emf.close();
	}

	public DepartamentoEntity buscarDepartamento(int numDepartamento) {
		return em.find(DepartamentoEntity.class, numDepartamento);
	}// de m�todo buscarDepartamento
		//

	@SuppressWarnings("deprecation")
	public void imprimirDepartamento(int numDepartamento) {
		DepartamentoEntity d = buscarDepartamento(numDepartamento);
		if (d == null)
			System.out.println("No existe el Departamento " + numDepartamento);
		else {
			Set<EmpleadoEntity> empleados = d.getEmpleados();
			String datos = "Datos del departamento " + numDepartamento + ": ";
			datos += "Nombre: " + d.getNombre() + " - Localidad: " + d.getLocalidad() + "\n";
			if (empleados.isEmpty())
				datos += "No tiene empleados en este momento";
			else {
				datos += "Lista de empleados" + "\n";
				datos += "*******************";
			}
			for (EmpleadoEntity empleado : empleados) {
				datos += "\nN�mero de empleado: " + empleado.getEmpnoId() + "\n";
				datos += "Nombre: " + empleado.getNombre() + "\n";
				datos += "Oficio: " + empleado.getOficio() + "\n";
				if (empleado.getDirId() == null)
					datos += "Jefe: No tiene" + "\n";
				else
					datos += "Jefe: " + empleado.getDirId().getNombre() + "\n";
				datos += "A�o de alta: " + (empleado.getAlta().getYear() + 1900) + "\n";
				datos += "Salario: " + empleado.getSalario() + "\n";
				if (empleado.getComision() == null)
					datos += "Comisi�n: No tiene" + "\n";
				else
					datos += "Comisi�n: " + empleado.getComision() + "\n";
			}

			System.out.println(datos);
		}
	} // de m�todo imprimirDepartamento

	public boolean insertarDepartamento(DepartamentoEntity d) {
		if (buscarDepartamento(d.getDptoId()) != null)
			return false;
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		return true;
	} // de insertarDepartamento

	public boolean modificarDepartamento(DepartamentoEntity d) {
		DepartamentoEntity departamentoBuscado = buscarDepartamento(d.getDptoId());
		if (departamentoBuscado == null)
			return false;
		em.getTransaction().begin();
		departamentoBuscado.setNombre(d.getNombre());
		departamentoBuscado.setLocalidad(d.getLocalidad());
		em.persist(departamentoBuscado);
		em.getTransaction().commit();
		return true;
	} // de modificarDepartamento

	// Si tiene empleados lo borrar�a igual, dejando en estos el n�mero de
	// Departamento
	// pero el resto de los atributos del departamento a null. Por eso no dejo
	// borrar

	public boolean borrarDepartamento(int numDepartamento) {
		DepartamentoEntity departamentoBuscado = buscarDepartamento(numDepartamento);
		if (departamentoBuscado == null || !departamentoBuscado.getEmpleados().isEmpty())
			return false;
		em.getTransaction().begin();
		em.remove(departamentoBuscado);
		em.getTransaction().commit();
		return true;
	} // de modificarDepartamento

	public void demoJPQL() {
		/*
		 * Query q1 = em.createQuery("SELECT COUNT(d) FROM DepartamentoEntity d");
		 * System.out.println("Total Departamentos: " + q1.getSingleResult()); //
		 * TypedQuery<Long> tq1 = em.createQuery(
		 * "SELECT COUNT(d) FROM DepartamentoEntity d", Long.class);
		 * System.out.println("Total Departamentos: " + tq1.getSingleResult()); //
		 * TypedQuery<DepartamentoEntity>tq2 =
		 * em.createQuery("SELECT d FROM DepartamentoEntity d",
		 * DepartamentoEntity.class); List<DepartamentoEntity> l2 = tq2.getResultList();
		 * for (DepartamentoEntity r2 : l2) { System.out.println("Nombre :  " +
		 * r2.getNombre()+ ", Localidad: "+ r2.getLocalidad()); } //
		 * TypedQuery<Object[]>tq3 =
		 * em.createQuery("SELECT d.nombre, d.localidad FROM DepartamentoEntity  d",
		 * Object[].class); List<Object[]> l3 = tq3.getResultList(); for (Object[] r3 :
		 * l3) { System.out.println( "Nombre :  " + r3[0] + ", Localidad: " + r3[1]); }
		 * // TypedQuery<Object[]>tq4 =
		 * em.createQuery("SELECT d.nombre, d.localidad FROM DepartamentoEntity d" +
		 * " WHERE d.dptoId != :n", Object[].class); tq4.setParameter("n", 10);
		 * List<Object[]> l4 = tq4.getResultList(); for (Object[] r4 : l4) {
		 * System.out.println( "Nombre :  " + r4[0] + ", Localidad: " + r4[1]); }
		 */
		/**** EJERCICIO 8: **********************************/

		TypedQuery<EmpleadoEntity> tQuery = em.createQuery("select e from EmpleadoEntity e order by e.nombre",
				EmpleadoEntity.class);
		List<EmpleadoEntity> listaEmpleados = tQuery.getResultList();
		
		TypedQuery<EmpleadoEntity> tQuery3 = em.createQuery("select e from EmpleadoEntity e order by e.departamento.getDptoId()",
				EmpleadoEntity.class);
		List<EmpleadoEntity> listaEmpleados2 = tQuery3.getResultList();

		TypedQuery<DepartamentoEntity> tQuery2 = em.createQuery("select e from DepartamentoEntity e order by nombre",
				DepartamentoEntity.class);
		List<DepartamentoEntity> listaDepartamentos = tQuery2.getResultList();
		
		TypedQuery<DepartamentoEntity> tQuery4 = em.createQuery("select e from DepartamentoEntity e",
				DepartamentoEntity.class);
		List<DepartamentoEntity> listaDepartamentos2 = tQuery4.getResultList();

		// 1//
		for (EmpleadoEntity e : listaEmpleados) {
			System.out.println(e.getNombre() + "-" + e.getAlta());
		}
		System.out.println("_______________________________________________________________");
		// 2//
		for (EmpleadoEntity e : listaEmpleados) {
			if (e.getNombre().toLowerCase().contains("carrera"))
				System.out.println(e.getNombre() + "-" + e.getAlta());
		}
		System.out.println("_______________________________________________________________");
		// 3//
		for (EmpleadoEntity e : listaEmpleados) {
			if (e.getDepartamento().getNombre().equalsIgnoreCase("i+d") && e.getOficio().equalsIgnoreCase("empleado"))
				System.out.println(e.getNombre() + "-" + e.getOficio() + "-" + e.getDepartamento().getNombre());
		}
		System.out.println("_______________________________________________________________");
		// 4//
		for (EmpleadoEntity e : listaEmpleados) {
			if ((e.getAlta().getYear() + 1900) >= 2003)
				System.out.println(e.getNombre() + "-" + e.getAlta());
		}
		System.out.println("_______________________________________________________________");
		// 5//
		TypedQuery<Object[]> tq5 = em.createQuery(
				"select e.departamento.getNombre(), e.nombre from EmpleadoEntity e order by e.departamento.getNombre()",
				Object[].class);
		List<Object[]> lista = tq5.getResultList();
		for (Object[] o : lista) {
			System.out.println(o[0] + "-" + o[1]);
		}
		System.out.println("_______________________________________________________________");
		// 6//

		for (DepartamentoEntity d : listaDepartamentos) {
			int salario = 0, salarioMax = 0;
			if (d.getEmpleados().size() > 0) {
				for (EmpleadoEntity e : d.getEmpleados()) {
					salario += e.getSalario();
					if (e.getSalario() > salarioMax)
						salarioMax = e.getSalario();
				}
				System.out.println(d.getNombre() + "-" + d.getEmpleados().size() + "-" + salario + "-" + salarioMax);
			}
		}
		System.out.println("_______________________________________________________________");
		// 7//
		for (DepartamentoEntity d : listaDepartamentos) {
			int salario = 0, salarioMax = 0;
			if (d.getEmpleados().size() >= 5) {
				for (EmpleadoEntity e : d.getEmpleados()) {
					salario += e.getSalario();
					if (e.getSalario() > salarioMax)
						salarioMax = e.getSalario();
				}
				System.out.println(d.getNombre() + "-" + d.getEmpleados().size() + "-" + salario + "-" + salarioMax);
			}
		}
		System.out.println("_______________________________________________________________");
		// 8//
		for (EmpleadoEntity e : listaEmpleados2) {
			if(e.getDirId()!=null)
			System.out.println(e.getNombre() + "- su jefe es -" +e.getDirId().getNombre() + "-" + e.getDepartamento().getNombre() + "-" + e.getDepartamento().getDptoId());
		}
		System.out.println("_______________________________________________________________");
		// 9//
		for (DepartamentoEntity e : listaDepartamentos) {
			if(e.getEmpleados().size()>0)
			System.out.println(e.getNombre() + "- " + e.getEmpleados().size());
		}
		System.out.println("_______________________________________________________________");
		// 10//
		for (DepartamentoEntity e : listaDepartamentos) {
			
			System.out.println(e.getNombre() + "- " + e.getEmpleados().size());
		}
		System.out.println("_______________________________________________________________");
		// 11//
		Query q= em.createQuery("select e.departamento.getDptoId(), e.nombre , e.salario from EmpleadoEntity e order by  e.departamento.getDptoId() desc, e.salario");
		List<Object[]> l= q.getResultList();
		for(Object[] o: l) {
			for(Object ob: o) {
				System.out.print(ob+"-");
			}
			System.out.println();
		}
		System.out.println("_______________________________________________________________");
		// 12//
		for (EmpleadoEntity e : listaEmpleados) {
			if(e.getDirId()==null)
				System.out.println(e.getEmpnoId() + "-" + e.getNombre());
				}
		System.out.println("_______________________________________________________________");
		// 13//
		for (EmpleadoEntity e : listaEmpleados) {
			if(e.getEmpnoId()==1039)
				System.out.println(e.getDepartamento().getDptoId() + "-" + e.getDepartamento().getNombre());
				}
	}
} // de la clase
