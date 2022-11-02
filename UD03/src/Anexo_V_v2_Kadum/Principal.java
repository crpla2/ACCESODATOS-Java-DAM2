package Anexo_V_v2_Kadum;

public class Principal {
	   public static void main(String[] args) {
	        //Invocar al constructor de la clase Bd
	        new Bd("baloncesto");
	        //Crear un objeto de la clase View
	        Vista vista  = new Vista();
	        //Crear un objeto de la clase Controller
	        Controlador controlador  = new Controlador(vista);
	        //Vincular la vista y el controlador
	        vista.conectaControlador(controlador);
	 
	    }
	}
