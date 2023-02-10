package productos;

public class Producto {

private String nombre;

private String fabricante;

private String categoria;

private double precio;

public Producto() {
	super();
}

public Producto(String nombre, String fabricante, String categoria, double precio) {
	super();
	this.nombre = nombre;
	this.fabricante = fabricante;
	this.categoria = categoria;
	this.precio = precio;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getFabricante() {
	return fabricante;
}

public void setFabricante(String fabricante) {
	this.fabricante = fabricante;
}

public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

@Override
public String toString() {
	return "Producto [nombre=" + nombre + ", fabricante=" + fabricante + ", categoria=" + categoria + ", precio="
			+ precio + "]";
}



}
