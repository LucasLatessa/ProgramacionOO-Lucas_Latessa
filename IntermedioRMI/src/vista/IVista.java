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

	public void preguntaEmpezar();

	void mostrarCartaTirada();

	void mostrarDinero();

	public void actualizarDinero(int dineroEsteJug);
	public void actualizarPozo(int pozo);

	public void limpiarCartas();

}