package vista;

import java.util.ArrayList;

import modelo.IJugador;
import controlador.Controlador;
public interface IVista {
	
	public void setControlador(Controlador controlador);
	
	public void iniciar();


	public void mostrarPuntajes();
}