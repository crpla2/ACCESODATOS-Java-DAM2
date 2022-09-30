package Ejercicio_13;

import java.io.Serializable;

public class Cliente implements Serializable {
	private String nombreCompleto;
	private String telefono;
	private String direccion;
	private String nif;
	transient String moroso;

	public Cliente() {
	}

	public Cliente(String nombreCompleto, String telefono, String direccion, String nif, String moroso) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nif = nif;
		this.moroso = moroso;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getMoroso() {
		return moroso;
	}

	public void setMoroso(String moroso) {
		this.moroso = moroso;
	}

	@Override
	public String toString() {
		return "Cliente [nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", Dirección=" + direccion
				+ ", nif=" + nif + ", moroso=" + moroso + "]";
	}

}
