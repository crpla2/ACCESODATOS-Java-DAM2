package ejemplo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public void imprimirDepartamento (int numDepartamento) {
		DepartamentoEntity d = buscarDepartamento(numDepartamento);
		if (d==null)
			System.out.println("No existe el Departamento " + numDepartamento);
		else {
			Set <EmpleadoEntity> empleados =d.getEmpleados();
			String datos="Datos del departamento " + numDepartamento + ": ";
			datos+= "Nombre: " + d.getNombre() + " - Localidad: " + d.getLocalidad()+ "\n";
			if (empleados.isEmpty())
				datos+="No tiene empleados en este momento";
			else {			
				datos+="Lista de empleados"+ "\n";
				datos+="*******************";
			}
			for (EmpleadoEntity empleado :empleados) {
				datos+= "\nN�mero de empleado: " + empleado.getEmpnoId()+ "\n";
				datos+= "Nombre: " + empleado.getNombre()+ "\n";
				datos+= "Oficio: " + empleado.getOficio()+ "\n";
				if (empleado.getDirId()==null)
					datos+= "Jefe: No tiene"+ "\n";
				else
					datos+= "Jefe: "+ empleado.getDirId().getNombre()+ "\n";
				datos+= "A�o de alta: " + (empleado.getAlta().getYear()+1900)+ "\n";	
				datos+= "Salario: "+ empleado.getSalario()+ "\n";
				if (empleado.getComision() ==null)
					datos+= "Comisi�n: No tiene"+ "\n";
				else
					datos+= "Comisi�n: "+ empleado.getComision()+ "\n";
			}
			
			System.out.println(datos);
		}
	} // de m�todo imprimirDepartamento
	
	public boolean insertarDepartamento (DepartamentoEntity d) {
		if (buscarDepartamento(d.getDptoId())!=null)
			return false;
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		return true;
	} // de insertarDepartamento
	
	public boolean modificarDepartamento (DepartamentoEntity d) {
		DepartamentoEntity departamentoBuscado=buscarDepartamento(d.getDptoId());
		if (departamentoBuscado==null)
			return false;
		em.getTransaction().begin();
		departamentoBuscado.setNombre(d.getNombre());
		departamentoBuscado.setLocalidad(d.getLocalidad());
		em.persist (departamentoBuscado);
		em.getTransaction().commit();
		return true;
	} // de modificarDepartamento
	
	// Si tiene empleados lo borrar�a igual, dejando en estos el n�mero de Departamento
	// pero el resto de los atributos del departamento a null. Por eso no dejo borrar
	
	public boolean borrarDepartamento  (int numDepartamento) {
		DepartamentoEntity departamentoBuscado=buscarDepartamento(numDepartamento);
		if (departamentoBuscado==null || !departamentoBuscado.getEmpleados().isEmpty() )
			return false;
		em.getTransaction().begin();
		em.remove(departamentoBuscado);
		em.getTransaction().commit();
		return true;
	} // de modificarDepartamento
	
	public void demoJPQL() {
		/*
		Query q1 = em.createQuery("SELECT COUNT(d) FROM DepartamentoEntity d");
        System.out.println("Total Departamentos: " + q1.getSingleResult());
        //
        TypedQuery<Long> tq1 = em.createQuery(
        	      "SELECT COUNT(d) FROM DepartamentoEntity d", Long.class);
        System.out.println("Total Departamentos: " + tq1.getSingleResult());
        //
        TypedQuery<DepartamentoEntity>tq2 =
	            em.createQuery("SELECT d FROM DepartamentoEntity d", DepartamentoEntity.class);
	        List<DepartamentoEntity> l2 = tq2.getResultList();
	        for (DepartamentoEntity r2 : l2) {
	            System.out.println("Nombre :  " + r2.getNombre()+ ", Localidad: "+ r2.getLocalidad());
	        }
	    //
        TypedQuery<Object[]>tq3 =
	            em.createQuery("SELECT d.nombre, d.localidad FROM DepartamentoEntity  d", Object[].class);
	        List<Object[]> l3 = tq3.getResultList();
	        for (Object[] r3 : l3) {
	            System.out.println(
	            "Nombre :  " + r3[0] + ", Localidad: " + r3[1]);
	    }    
	    //
	      TypedQuery<Object[]>tq4 =
		            em.createQuery("SELECT d.nombre, d.localidad FROM DepartamentoEntity d"
		            		+ " WHERE d.dptoId != :n", Object[].class);
	        		tq4.setParameter("n", 10);
		        List<Object[]> l4 = tq4.getResultList();
		        for (Object[] r4 : l4) {
		            System.out.println(
		            "Nombre :  " + r4[0] + ", Localidad: " + r4[1]);
		    }   */  
/****EJERCICIO 8:**********************************/  
		 TypedQuery<EmpleadoEntity> TQEmp;
		 	TQEmp=em.createQuery("SELECT e "
		 					+ "FROM EmpleadoEntity e"
		 					,EmpleadoEntity.class);
		 List<EmpleadoEntity> listaEmp= TQEmp.getResultList();
		 
		 TypedQuery<DepartamentoEntity> TQDep;
		 TQDep=em.createQuery("SELECT d "
		 					+ "FROM DepartamentoEntity d "
		 					+ "ORDER BY d.nombre",DepartamentoEntity.class);
		 List<DepartamentoEntity>listaDep=TQDep.getResultList();
		 /****1*****/
		 for(EmpleadoEntity empleado : listaEmp) {
			 System.out.println(empleado.getNombre()+" - "+empleado.getAlta());
		 }
		 /****2*****/
		 System.out.println();
		 for(EmpleadoEntity empleado:listaEmp) {
			 if(empleado.getNombre().toLowerCase().contains("carrera"))
				 System.out.println(empleado.getNombre()+" - "+ empleado.getAlta());
		 }
		 System.out.println();
		 /****3*****/
		 for(EmpleadoEntity empleado:listaEmp) {
			 if(empleado.getDepartamento().getNombre().equalsIgnoreCase("I+D")&&empleado.getOficio().equalsIgnoreCase("Empleado"))
				 System.out.println(empleado.getNombre()+" - "+ empleado.getOficio()+" - "+empleado.getDepartamento().getNombre());
		 }
		 System.out.println();
		 /****4*****/
		 Date fecha= new Date("2002/12/31");
		 System.out.println(fecha);
		
		 for(EmpleadoEntity empleado:listaEmp) {
			 if((empleado.getAlta().compareTo(fecha))>0)
				 System.out.println(empleado.getNombre()+" - "+ empleado.getAlta());
		 }
		 System.out.println();
		 /****5*****/
		 Query query= em.createQuery("SELECT e.departamento.nombre, e.nombre "
		 						   + "FROM  EmpleadoEntity e "
		 						   + "ORDER BY e.departamento.nombre");
		 List<Object[]>list=query.getResultList();
		 for(Object[] o:list) {
			 System.out.println(o[0]+" - "+ o[1]);
		 }
		 System.out.println();
		 /****6*****/
		 Query query2= em.createQuery("SELECT  d.departamento.nombre , count(d), sum(d.salario), max(d.salario) "
		 							+ "FROM  EmpleadoEntity d "
		 							+ "GROUP BY d.departamento.nombre ");
		 List<Object[]>list2=query2.getResultList();
		 for(Object[] o:list2) {
			 System.out.println(o[0]+" - "+ o[1]+" - "+ o[2]+" - "+ o[3]);
		 }
		 System.out.println();
		 /****7*****/
		 Query query3= em.createQuery("SELECT  d.departamento.nombre , count(d), sum(d.salario), max(d.salario) "
		 							+ "FROM  EmpleadoEntity d "
		 							+ "GROUP BY d.departamento.nombre "
		 							+ "HAVING count(d)>=5");
		 List<Object[]>list3=query3.getResultList();
		 for(Object[] o:list3) {
			 System.out.println(o[0]+" - "+ o[1]+" - "+ o[2]+" - "+ o[3]);
		 }
		 System.out.println();
		 /****8*****/
		for(EmpleadoEntity empleado:listaEmp) {
			if(empleado.getDirId()!=null)		
			  System.out.println(empleado.getNombre()+" - su jefe es - "+ empleado.getDirId().getNombre()+" - departamento - "+empleado.getDepartamento().getDptoId());
		 }
		 System.out.println();
		 /****9*****/
			for(DepartamentoEntity departamento:listaDep) {
				if(departamento.getEmpleados().size()>0)		
				  System.out.println(departamento.getNombre()+" - "+departamento.getEmpleados().size());
			}
			 System.out.println();
		 /****10*****/
			for(DepartamentoEntity departamento:listaDep) {		
				System.out.println(departamento.getNombre()+" - "+departamento.getEmpleados().size());
			}
				 System.out.println();
		 /****11*****/
			for(DepartamentoEntity departamento:listaDep) {		
				System.out.println(departamento.getNombre()+" - "+departamento.getEmpleados().size());
			}
			 System.out.println();			 
		 
		 
		 
	}// de demoJPQL
//--------------------------------------------------------------------------------------------------------------
	
} // de la clase
