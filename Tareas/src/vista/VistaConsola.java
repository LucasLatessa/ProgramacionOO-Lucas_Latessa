package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;

public class VistaConsola {
	private Scanner entrada=new Scanner(System.in);
	private Controlador controlador;
	public void mostrarMenuPrincipal() {
		System.out.println("menu \n1-crear tarea\n2-eliminar tarea \n3-listar tareas\n4-completar tarea\n0-salir");
	}
	private boolean validarOpciones(String opcion,ArrayList<String> opciones) {
		return opciones.contains(opcion);
	}
	public void mostrar() {
		boolean salir=false;
		while(!salir) {
		this.mostrarMenuPrincipal();
		String opcion=this.entrada.nextLine();
		//if (this.validarOpciones(opcion, new arralyList()))
		switch(Integer.valueOf(opcion)) {
		case 0: salir=true;break;
		case 1:
			this.mostrarFormularioAlta();
			break;
		case 2:
		case 3:
		case 4:
		default:
			this.mostrar();
		}}
	}
	private void mostrarFormularioAlta() {
		System.out.println("Ingrese un titulo:");
		String titulo=this.entrada.nextLine();
		System.out.println("Ingrese una descripcion:");
		String descripcion=this.entrada.nextLine();
		this.controlador.crearTarea(titulo,descripcion);
	}

}
