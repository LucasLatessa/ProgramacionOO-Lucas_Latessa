package POO.Serializacion.entities;

/**
 * Institution : Universidad Nacional de Luján
 * Class : Programación Orientada a Objetos
 * Author : Walter Panessi
 */


import java.io.Serializable;
import java.util.Date;


public class PlanEstudio implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer version;
	private Carrera carrera;
	private Date fechaActivacion;
	
	public PlanEstudio(Integer version, Carrera carrera, Date fechaActivacion) {
		super();
		this.version = version;
		this.carrera = carrera;
		this.fechaActivacion = fechaActivacion;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public Date getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	
	@Override
	public String toString() {
		return "PlanEstudio [version=" + version + ", carrera=" + carrera + ", fechaActivacion=" + fechaActivacion
				+ "]";
	}
	
	

}
