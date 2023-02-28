package ar.edu.unlu.poo.todoapp.modelo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlu.poo.utils.observer.Observable;
import ar.edu.unlu.poo.utils.observer.Observador;
import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

public class ListadoDeTareas extends ObservableRemoto implements IListadoDeTareas{
	private List<ITarea> tareas;
	
	public ListadoDeTareas() {
		this.tareas = new ArrayList<>();
	}
	
	@Override
	public Tarea agregarTarea(String titulo, String descripcion) throws RemoteException {
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
	
	@Override
	public List<ITarea> listarTareas() throws RemoteException {
		return this.tareas;
	}

	
	@Override
	public void notificar(Object evento) throws RemoteException {
		this.notificarObservadores(evento);
	}

}
