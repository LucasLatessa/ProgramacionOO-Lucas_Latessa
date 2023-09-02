package ar.edu.unlu.poo.todoapp.vista;

import java.util.List;
import java.util.Scanner;

import ar.edu.unlu.poo.todoapp.controlador.Controlador;
import ar.edu.unlu.poo.todoapp.modelo.ITarea;

public class VistaConsola implements IVista{
	
	private Scanner entrada;
	
	private Controlador controlador;
	
	public VistaConsola() {
		this.entrada = new Scanner(System.in);
	}

	public void mostrarMenuPrincipal() {
		System.out.println("########################");
		System.out.println("####### TODO App #######");
		System.out.println("########################");
		System.out.println();
		System.out.println("Selecciona una opción:");
		System.out.println("a - Agregar tarea");
		System.out.println("l - Listar tareas");
		System.out.println();
		System.out.println("x - Salir");
	}

	@Override
	public void iniciar() {
		boolean salir = false;
		while(!salir) {
			this.mostrarMenuPrincipal();
			String opcion = this.entrada.nextLine();
			switch (opcion.toLowerCase()) {
				case "a":
					this.mostrarFormularioAlta();
					break;
				case "x":
					salir = true;
					System.out.println("Recuerde completar sus tareas!");
					break;
				default:
					System.out.println("Opción no válida.");
			}
		}
	}

	private void mostrarFormularioAlta() {
		System.out.println("Por favor, ingrese un título:");
		String titulo = this.entrada.nextLine();
		System.out.println("Por favor, ingrese una descripción:");
		String descripcion = this.entrada.nextLine();
		this.controlador.agregarTarea(titulo, descripcion);
	}
	
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void mostrarTareas(List<ITarea> tareas) {
		for (ITarea tarea : tareas) {
			System.out.println("Título:" + tarea.getTitulo());
			System.out.println("Descripción:" + tarea.getDescripcion());
		}
	}
}
