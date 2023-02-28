package ar.edu.unlu.poo.todoapp.controlador;

import java.rmi.RemoteException;
import java.util.List;

import ar.edu.unlu.poo.todoapp.modelo.Eventos;
import ar.edu.unlu.poo.todoapp.modelo.IListadoDeTareas;
import ar.edu.unlu.poo.todoapp.modelo.ITarea;
import ar.edu.unlu.poo.todoapp.vista.VistaConsola;
import ar.edu.unlu.poo.utils.observer.Observable;
import ar.edu.unlu.poo.utils.observer.Observador;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

public class Controlador implements IControladorRemoto{
	private IListadoDeTareas modelo;
	
	private VistaConsola vista;
	
	public Controlador(VistaConsola vista) {
		this.vista = vista;
		this.vista.setControlador(this);
	}

	public void agregarTarea(String titulo, String descripcion) {
		try {
			this.modelo.agregarTarea(titulo, descripcion);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// this.vista.informarError("Estamos teniendo problemas para guardar la tarea");
		}
	}
	@Override
	public void actualizar(IObservableRemoto observable, Object evento) throws RemoteException{
		if(evento instanceof Eventos) {
			switch((Eventos) evento) {
				case TAREA_AGREGADA:
					List<ITarea> tareas = this.modelo.listarTareas();
					this.vista.mostrarTareas(tareas);
					break;
			}
		}
	}
	@Override
	public <T extends IObservableRemoto> void setModeloRemoto(T modelo) throws RemoteException {
		this.modelo = (IListadoDeTareas) modelo;
	}

}