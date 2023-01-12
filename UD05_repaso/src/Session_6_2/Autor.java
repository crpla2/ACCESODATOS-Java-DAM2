package Session_6_2;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="autores")
public class Autor {
    
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="NOMBRE", nullable = false)
    private String nombre;
    
    /**
     * El caso de la Entidad Author es m�s simple, pues solo marcamos la colecci�n con ManyToMany, pero en este caso ya no es 
     * necesario definir la anotaci�n JoinTable, en su lugar, definimos la propiedad mappedBy para indicar la relaci�n bidireccional y 
     * al mismo tiempo, JPA puede tomar la configuraci�n del JoinTable de Books.
     * 
     * Como resultado, JPA creara internamente una tabla mas (rel_libros_autores) que podremos ver con el explorer.exe
     * **/
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    /** GET and SET **/
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    public List<Libro> getLibros() {
    	return libros;
    }
    
    @Override
    public String toString() {
    	return "Nombre autor: " + nombre + ", ID: "+id;
    }
}
