package vista;

import java.util.ArrayList;

import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import modelo.EstadoTruco;
import modelo.IEnvido;
import modelo.IJugador;
import controlador.Controlador;
public interface IVista {
	
	public void setControlador(Controlador controlador);
	
	public void iniciar();
	public void jugar();
	public void mostrarPuntajes();
	public void juegoTerminado();
	public void avisarParda();
	public void rondaTerminada(boolean ganador);
	public void manoTerminada();
	public void mostrarEnvido(String nombre);
	public void quererNoQuererEnvido(String nombreTurno, IEnvido evento);
	public void quererNoQuererTruco(String nombreTurno, EstadoTruco evento);
	public void esperandoJugadores();
	public void mostrarCartasEnMano();
	public void esperarJugandoOponente();
	/**
	 * muestra la carta tirada en caso de que haya
	 */
	void mostrarCartaTirada();

	void serializar(String ganador);
}