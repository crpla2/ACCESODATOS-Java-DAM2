package Ejercicio09;

public class Profesores {

private String nombre;
private int departamento;
private double antiguedad;
public Profesores(String nombre, int departamento, double antiguedad) {
	super();
	
	this.nombre = nombre;
	this.departamento = departamento;
	this.antiguedad = antiguedad;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getDepartamento() {
	return departamento;
}
public void setDepartamento(int departamento) {
	this.departamento = departamento;
}
public double getAntiguedad() {
	return antiguedad;
}
public void setAntiguedad(double antiguedad) {
	this.antiguedad = antiguedad;
}
@Override
public String toString() {
	return "Profesores [nombre=" + nombre + ", departamento=" + departamento + ", antiguedad=" + antiguedad + "]";
}

}
