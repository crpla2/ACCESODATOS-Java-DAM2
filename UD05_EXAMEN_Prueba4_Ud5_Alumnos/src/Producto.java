
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Producto implements java.io.Serializable {
	@Id	
	private String cod;
	private String nombre;
	private String nombreCorto;
	private String descripcion;
	private Double pvp;
	@OneToMany(mappedBy="producto")
	private Set<Stock> stocks = new HashSet<Stock>(0);
	@ManyToOne
	private Familia familia;
	public Producto() {
	}

	public Producto(String cod, Familia familia, String nombreCorto, Double pvp) {
		this.cod = cod;
		this.familia = familia;
		this.nombreCorto = nombreCorto;
		this.pvp = pvp;
	}

	public Producto(String cod, String nombre, String nombreCorto, String descripcion, Double pvp, Familia familia) {
		this.cod = cod;
		this.nombre = nombre;
		this.nombreCorto = nombreCorto;
		this.descripcion = descripcion;
		this.pvp = pvp;
		this.familia = familia;
		
	}
	
	public Producto(String cod, Familia familia, String nombre, String nombreCorto, String descripcion, Double pvp,
			Set<Stock> stocks) {
		this.cod = cod;
		this.familia = familia;
		this.nombre = nombre;
		this.nombreCorto = nombreCorto;
		this.descripcion = descripcion;
		this.pvp = pvp;
		this.stocks = stocks;
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Familia getFamilia() {
		return this.familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCorto() {
		return this.nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPvp() {
		return this.pvp;
	}

	public void setPvp(Double pvp) {
		this.pvp = pvp;
	}

	public Set<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

}
