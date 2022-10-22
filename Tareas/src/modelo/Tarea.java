package modelo;

public class Tarea {
	private String titulo;
	private String descripcion;
	private Estado estado;
	public Tarea(String titulo,String descripcion) {
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.estado=Estado.PENDIENTE;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void completar() {
		this.estado=Estado.COMPLETADA;
	}
}
