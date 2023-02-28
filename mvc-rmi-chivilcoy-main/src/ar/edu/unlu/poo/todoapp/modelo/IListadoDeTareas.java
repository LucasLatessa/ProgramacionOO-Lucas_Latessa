package ar.edu.unlu.poo.todoapp.modelo;

import java.rmi.RemoteException;
import java.util.List;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

public interface IListadoDeTareas extends IObservableRemoto{

	Tarea agregarTarea(String titulo, String descripcion) throws RemoteException;

	List<ITarea> listarTareas() throws RemoteException;

	void notificar(Object evento) throws RemoteException;

}