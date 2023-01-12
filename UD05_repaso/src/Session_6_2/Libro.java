package Session_6_2;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "books")
public class Libro {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    //La anotaci�n @JoinTable no es obligatoria en s�, ya que en caso de no definirse JPA asumir� el nombre de la tabla, columnas, 
    //longitud, etc. Para no quedar a merced de la implementaci�n de JPA, siempre es recomendable definirla, as�, tenemos el control total sobre ella.
    /**
     * Hemos definidos las siguientes propiedades de la anotaci�n JoinTable
		name: Nombre de la tabla que ser� creada f�sicamente en la base de datos.
		joinColumns: Corresponde al nombre para el ID de la Entidad Book.
		inverseJoinColumns: Corresponde al nombre para el ID de la Entidad Author
    **/
    @JoinTable(
        name = "rel_libros_autores",
        joinColumns = @JoinColumn(name = "FK_LIBRO", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_AUTOR", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Autor> autores;
   
    public void addAuthor(Autor autor){
        if(this.autores == null){
            this.autores = new ArrayList<>();
        }
        
        this.autores.add(autor);
    }

    /** GET and SET */
    public void setNombre(String nombre) {
    	this.nombre=nombre;
    }
    public List<Autor> getAutores() {
    	return autores;
    }
    
    @Override
    public String toString() {
    	return "Nombre libro: " + nombre + ", ID: "+id;
    }
  
}
