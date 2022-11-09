package examen;

 
public class MainMVC {
    public static void main(String[] args) {
        
        //Crear un objeto de la clase View
        View vista  = new View();
        //Crear un objeto de la clase Controller
        Controller controlador  = new Controller(vista);
        //Vincular la vista y el controlador
        vista.conectaControlador(controlador);
 
    }
}