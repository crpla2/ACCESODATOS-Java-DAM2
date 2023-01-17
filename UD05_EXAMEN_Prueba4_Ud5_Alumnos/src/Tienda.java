

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tienda implements java.io.Serializable {
	@Id	
	private Integer cod;
	private String nombre;
	private String tlf;
	@OneToMany(mappedBy="tienda")
	private Set<Stock> stocks = new HashSet<Stock>(0);

	public Tienda() {
	}

	
	public Tienda(Integer cod, String nombre, String tlf) {
		this.cod =cod;
		this.nombre = nombre;
		this.tlf = tlf;
	}
	

	public Integer getCod() {
		return this.cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTlf() {
		return this.tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public Set<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

}
