import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Stock implements java.io.Serializable {
	@Id	
	@ManyToOne
	
	private Producto producto;
	@Id
	@ManyToOne
	private Tienda tienda;
	private int unidades;

	public Stock() {
	}

	public Stock(Producto producto, Tienda tienda, int unidades) {
	
		this.producto = producto;
		this.tienda = tienda;
		this.unidades = unidades;
	}

	

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public int getUnidades() {
		return this.unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

}
