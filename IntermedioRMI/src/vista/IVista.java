package vista;

import java.util.ArrayList;

import modelo.IJugador;
import controlador.Controlador;
public interface IVista {
	
	public void setControlador(Controlador controlador);
	
	public void iniciar();
	public void jugar();
	public void juegoTerminado();
	public void manoTerminada();
	public void esperandoJugadores();
	public void mostrarCartasEnMano();
	public void esperarJugandoOponente();
	/**
	 * muestra la carta intermedia en caso de que haya
	 */
	void mostrarCartaIntermedia();

	void mostrarPuntajes();

	public void preguntaEmpezar();

	public void mostrarCartaIntermediaContras();

	void mostrarCartaTirada();
}