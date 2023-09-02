import ar.edu.unlu.poo.todoapp.controlador.Controlador;
import ar.edu.unlu.poo.todoapp.modelo.ListadoDeTareas;
import ar.edu.unlu.poo.todoapp.vista.VistaConsola;

public class TodoApp {

	public static void main(String[] args) {
		ListadoDeTareas modelo = new ListadoDeTareas();
		VistaConsola vista = new VistaConsola();
		Controlador controlador = new Controlador(modelo, vista);
		vista.iniciar();

	}

}
