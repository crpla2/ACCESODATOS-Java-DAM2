package Ejercicio08;

import java.io.Serializable;

public class Profesores implements Serializable {
	String nombre;
	int antiguedad;
	public Profesores() {}
	public Profesores(String nombre, int antiguedad) {
		super();
		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	@Override
	public String toString() {
		return "Profesores [nombre=" + nombre + ", antiguedad=" + antiguedad + "]";
	}
	
}
