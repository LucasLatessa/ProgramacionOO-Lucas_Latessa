package ar.edu.unlu.poo.todoapp.modelo;

public class Tarea implements ITarea{
	
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	
	private String descripcion;
	
	private EstadosDeTarea estado;

	public Tarea(String titulo, String descripcion) {
		super();
		this.setTitulo(titulo);
		this.setDescripcion(descripcion);
		this.setEstado(EstadosDeTarea.PENDIENTE);
	}

	private void setEstado(EstadosDeTarea estado) {
		this.estado = estado;
	}
	@Override
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void completar() {
		this.setEstado(EstadosDeTarea.COMPLETADA);
	}
	
	public boolean isCompletada() {
		return this.estado.equals(EstadosDeTarea.COMPLETADA);
	}
	
}
