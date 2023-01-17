

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Familia implements java.io.Serializable {
	@Id	
	private String cod;
	private String nombre;
	@OneToMany(mappedBy="familia")
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Familia() {
	}

	public Familia(String cod, String nombre) {
		this.cod = cod;
		this.nombre = nombre;
	}

	public Familia(String cod, String nombre, Set <Producto> productos) {
		this.cod = cod;
		this.nombre = nombre;
		this.productos = productos;
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
