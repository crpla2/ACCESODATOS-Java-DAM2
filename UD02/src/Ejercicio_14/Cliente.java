package Ejercicio_14;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Cliente implements Externalizable {
	private String nombreCompleto;
	private String telefono;
	private String direccion;
	private String nif;
	private String moroso;

	public Cliente() {
	}

	public Cliente(String nombreCompleto, String telefono, String direccion, String nif,String moroso) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nif = nif;
		this.moroso=moroso;
		
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
		return "Cliente [Nombre: " + nombreCompleto + ", Teléfono: " + telefono + ", Dirección: " + direccion
				+ ", NIF:" + nif +", moroso:"+ moroso +"]";
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.nombreCompleto = in.readUTF();
		this.telefono =  in.readUTF();
		this.direccion =  in.readUTF();
		this.nif =  in.readUTF();
		
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(nombreCompleto);
		out.writeUTF(telefono);
		out.writeUTF(direccion);
		out.writeUTF(direccion);
		
		
	}

}
