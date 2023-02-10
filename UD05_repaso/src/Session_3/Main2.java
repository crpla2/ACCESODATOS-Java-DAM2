package Session_3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {

	public static void main(String[] args) throws ParseException {
        
		AccesoBdatos_Sesion3 abd = new AccesoBdatos_Sesion3();
		abd.conectar();
	//	abd.imprimirDepartamento(90);
//		abd.imprimirDepartamento(40);
//		abd.imprimirDepartamento(10);
		
    //  System.out.println(abd.insertarDepartamento(new DepartamentoEntity(60,"Recursos Humanos", "Chimillas")));
    //  System.out.println(abd.insertarDepartamento(new DepartamentoEntity(60,"Recursos Humanos", "Chimillas")));
    //  abd.imprimirDepartamento(60);
		
	//	System.out.println(abd.modificarDepartamento(new DepartamentoEntity(88,"RRHH", "Huerrios")));
	//	System.out.println(abd.modificarDepartamento(new DepartamentoEntity(60,"RRHH", "Esquedas")));
	//	abd.imprimirDepartamento(60);
		
	//	abd.borrarDepartamento(88); // false no existe
	//	abd.borrarDepartamento(60); // true
	//	abd.borrarDepartamento(10); // false pues tiene empleados
		
	//	abd.imprimirDepartamento(10);
	
	abd.demoJPQL();
		//Ejercicio9
		//System.out.println(abd.borraDepartamento(20));
	//	System.out.println(abd.borrarEmpleado(3054));
		//System.out.println(abd.incrementarSalarioDepartamento(50,100));
		//System.out.println(abd.incrementarSalarioV2(100));
	//	System.out.println(abd.incrementarSalarioOficioV2("Presidente",1000));
		//System.out.println(abd.incrementarSalarioDepartamentoV2(20,1000));
	//	System.out.println(abd.borrarEmpleadoV2(1034));
	//	System.out.println(abd.borraDepartamentoV2(40));
		abd.desconectar();
	
	}

}

