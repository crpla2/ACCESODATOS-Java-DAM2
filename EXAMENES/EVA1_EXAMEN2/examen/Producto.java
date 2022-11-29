package examen;


public class Producto {
	private long idProducto;
	private String nombreProducto;
	private long idProveedor;
	private long idCategoria;
	private String cantidadPorUnidad;
	private double precioUnidad;
	private int unidadesEnExistencia;
	
	public Producto() {
		super();
	}

	public Producto(long idProducto, String nombreProducto, long idProveedor, long idCategoria,
			String cantidadPorUnidad, double precioUnidad, int unidadesEnExistencia) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.idProveedor = idProveedor;
		this.idCategoria = idCategoria;
		this.cantidadPorUnidad = cantidadPorUnidad;
		this.precioUnidad = precioUnidad;
		this.unidadesEnExistencia = unidadesEnExistencia;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCantidadPorUnidad() {
		return cantidadPorUnidad;
	}

	public void setCantidadPorUnidad(String cantidadPorUnidad) {
		this.cantidadPorUnidad = cantidadPorUnidad;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getUnidadesEnExistencia() {
		return unidadesEnExistencia;
	}

	public void setUnidadesEnExistencia(int unidadesEnExistencia) {
		this.unidadesEnExistencia = unidadesEnExistencia;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", idProveedor="
				+ idProveedor + ", idCategoria=" + idCategoria + ", cantidadPorUnidad=" + cantidadPorUnidad
				+ ", precioUnidad=" + precioUnidad + ", unidadesEnExistencia=" + unidadesEnExistencia + "]";
	}

	
	
}
