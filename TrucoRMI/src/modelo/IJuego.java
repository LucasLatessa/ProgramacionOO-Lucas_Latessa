package modelo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

public interface IJuego extends IObservableRemoto, Serializable {

	Carta getCartaTirada() throws RemoteException;

	void trucos() throws RemoteException;


	/**tira carta y ya cambia el turno(si no es nula)
	 * @param carta<1-3>
	 * @return carta tirada(si no la encuentra devuelve nulo)
	 * @throws RemoteException 
	 */
	void tirarCarta(int carta) throws RemoteException;

	/**
	 * Cambia el turno del juego, en caso de que ninguno de los dos haya sido el turno anterior
	    es turno del mano(caso primera ronda).
	 * @throws RemoteException 
	 */
	void changeTurno() throws RemoteException;

	/**
	 * Le suma el/los punto/s obtenidos al jugador que no es el turno(ya que en el turno el jugador dijo no quiero)
	 * @throws RemoteException 
	 */
	void calcularEnvidoNQ() throws RemoteException;

	/**le suma los puntos obtenidos al jugador que gana el envido
	 * @return devuelve el ganador
	 * @throws RemoteException 
	 */
	void calcularEnvidoQ() throws RemoteException;

	void newRonda() throws RemoteException;

	void cantado(EstadoEnvido estado) throws RemoteException;

	void cantado(EstadoTruco estado) throws RemoteException;

	void quiero(EstadoTruco estado) throws RemoteException;

	void nuevaMano() throws RemoteException;

	void repartir() throws RemoteException;

	void vaciarCartas() throws RemoteException;

	ArrayList<IJugador> listarJugadores() throws RemoteException;

	/**
	 * @return devuelve el ganador del juego, en caso de no haberlo devuelve nulo
	 */
	void preguntarGanador() throws RemoteException;

	IJugador getITurno() throws RemoteException;

	EstadoTruco getEstadoTruco() throws RemoteException;

	/**
	 * @return si termina la mano le suma los puntos al ganador 
	 */
	boolean siFinManoYSumoPuntos() throws RemoteException;

	void sumarPuntosAlMazo() throws RemoteException;

	void turnoLuegoEnvido() throws RemoteException;

	int getNroRonda() throws RemoteException;

	IJugador getGanadorDeRonda() throws RemoteException;

	ArrayList<Integer> getTantosEnvido() throws RemoteException;

	IJugador quienCantoUltimo() throws RemoteException;

	//PASO EL ENVIDO DE RONDA AL JUEGO
	//
	/**no devuelve el puntaje porque se pueden seguir agregando.
	 * @param envido querido
	 */
	IEnvido addQuerido(EstadoEnvido estado) throws RemoteException;

	IEnvido addPreguntado(EstadoEnvido estado) throws RemoteException;

	/**
	 * @return devuelve el ganador del envido en esta mano, devuelve nulo si no hubo
	 */
	IJugador getGanadorEnvido() throws RemoteException;

	void agregarJugador(String jugador) throws RemoteException;

	String getJugadorUltAgregado()throws RemoteException;

	boolean isJugadoresCompletos() throws RemoteException;

	ArrayList<String> getCartasDeRonda() throws RemoteException;

	boolean verificarNombre(String nombre) throws RemoteException;


}