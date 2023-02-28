package POO.Serializacion.entities;

/**
 * Institution : Universidad Nacional de Luján
 * Class : Programación Orientada a Objetos
 * Author : Walter Panessi
 */

import java.io.Serializable;

public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer legajo;
	private String apellido;
	private String nombre;
	private PlanEstudio plan;
	public Estudiante(Integer legajo, String apellido, String nombre, PlanEstudio plan) {
		super();
		this.legajo = legajo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.plan = plan;
	}
	public Integer getLegajo() {
		return legajo;
	}
	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public PlanEstudio getPlan() {
		return plan;
	}
	public void setPlan(PlanEstudio plan) {
		this.plan = plan;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((legajo == null) ? 0 : legajo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (legajo == null) {
			if (other.legajo != null)
				return false;
		} else if (!legajo.equals(other.legajo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Estudiante [legajo=" + legajo + ", apellido=" + apellido + ", nombre=" + nombre + ", plan=" + plan
				+ "]";
	}


}
