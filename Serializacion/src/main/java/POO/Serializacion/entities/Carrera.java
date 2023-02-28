package POO.Serializacion.entities;
/**
 * Institution : Universidad Nacional de Luján
 * Class : Programación Orientada a Objetos
 * Author : Walter Panessi
 */
import java.io.Serializable;

public class Carrera implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String nombre;
	
	public Carrera(Integer codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	

}
