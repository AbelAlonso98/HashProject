package main;

import java.io.Serializable;

public class Test implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4309838610943277792L;
	String nombre;
	String apellido;
	int edad;

	public Test(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Test [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}

}
