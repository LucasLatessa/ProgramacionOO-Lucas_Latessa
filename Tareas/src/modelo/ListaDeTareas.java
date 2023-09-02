package modelo;
import java.util.ArrayList;
import ObservadoObservador.Observable;
import ObservadoObservador.Observador;
public class ListaDeTareas implements Observable {
	private ArrayList<Tarea> tareas;
	private ArrayList<Observador> observadores;
	public ListaDeTareas() {
		this.tareas=new ArrayList<>();
	}
	public Tarea crearTarea(String titulo,String descripcion) {
		Tarea tarea=new Tarea(titulo,descripcion);
		int posicion=this.buscarTareaPorTitulo(titulo);
		if (posicion!=-1){
			tareas.remove(posicion);
			
		}
		tareas.add(tarea);
		this.notificar(tareas);//hacer enumerado de eventos eventos.tareaagregada
		return tarea;
	}
	public int buscarTareaPorTitulo(String titulo) {
		int i=0;
		boolean encontrada=false;
		while(!encontrada &&i<this.tareas.size()) {
			if(this.tareas.get(i).getTitulo().equals(titulo)) {
				encontrada=true;
				
			}else {
				i++;
			}
				
		}
		return encontrada? i:-1;//si encontrada true devuelve i, sino -1
	}
	@Override
	public void notificar(Object evento) {
		for(Observador observador :observadores ) {
			observador.actualizar(evento,this);
		}
		
	}
	@Override
	public void agregarObservador(Observador observador) {
		observadores.add(observador);
		
	}
}
