package ar.edu.unlu.poo.todoapp.vista;

import java.util.List;

import ar.edu.unlu.poo.todoapp.controlador.Controlador;
import ar.edu.unlu.poo.todoapp.modelo.ITarea;

public interface IVista {
	public void mostrarTareas(List<ITarea> tareas);
	
	public void setControlador(Controlador controlador);
	
	public void iniciar();
}
