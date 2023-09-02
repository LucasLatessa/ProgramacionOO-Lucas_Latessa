package ar.edu.unlu.poo.todoapp.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlu.poo.utils.observer.Observable;
import ar.edu.unlu.poo.utils.observer.Observador;
public class ListadoDeTareas implements Observable{
	private List<ITarea> tareas;
	
	private List<Observador> observadores;
	
	public ListadoDeTareas() {
		this.tareas = new ArrayList<>();
		this.observadores = new ArrayList<>();
	}
	
	public Tarea agregarTarea(String titulo, String descripcion) {
		Tarea tarea = new Tarea(titulo, descripcion);
		int posicion = this.buscarTareaPorTitulo(titulo);
		if( posicion != -1) {		
			this.tareas.remove(posicion);
		}
		this.tareas.add(tarea);
		this.notificar(Eventos.TAREA_AGREGADA);
		return tarea;
	}
	
	private int buscarTareaPorTitulo(String titulo) {
		int i = 0;
		boolean encontrada = false;
		String buscado = titulo.toLowerCase();
		while(!encontrada && i < this.tareas.size()) {
			if(this.tareas.get(i).getTitulo().toLowerCase().equals(buscado)) {
				encontrada = true;
			}else {
				i++;
			}
		}
		return encontrada ? i : -1;
	}
	
	public List<ITarea> listarTareas(){
		return this.tareas;
	}

	@Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}

	@Override
	public void agregadorObservador(Observador observador) {
		this.observadores.add(observador);
	}
}
