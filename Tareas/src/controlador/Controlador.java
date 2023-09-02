package controlador;
import modelo.ListaDeTareas;
import vista.VistaConsola;
public class Controlador {
		private ListaDeTareas modelo;
		private VistaConsola vista;
	public Controlador(ListaDeTareas modelo, VistaConsola vista) {
		this.modelo=modelo;
		this.vista=vista;
	}
	public void crearTarea(String titulo, String descripcion) {
		this.modelo.crearTarea(titulo,descripcion);
		
	}

}
