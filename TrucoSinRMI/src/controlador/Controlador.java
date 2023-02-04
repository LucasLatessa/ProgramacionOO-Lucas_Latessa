package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;

import modelo.Eventos;
import modelo.IEnvido;
import modelo.IJugador;
import modelo.Juego;
import modelo.Ronda;
import modelo.Carta;
import modelo.EstadoEnvido;
import modelo.EstadoTruco;
import observer.Observable;
import observer.Observador;
import vista.VistaConsola;

	public class Controlador implements Observador{
		private Juego modelo;
		private VistaConsola vista;
	
	public Controlador(Juego modelo, VistaConsola vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
		this.modelo.agregarObservador(this);
	}
	public void agregarJugador(String jugador)  {
		modelo.agregarJugador(jugador);
	}
	@Override
	public void actualizar(Object evento, Observable observado) {
		if(evento instanceof Eventos) {
			switch((Eventos) evento) {
				case JUEGO_COMENZADO:
					vista.jugar();
					break;
				case PARDA:
					vista.avisarParda();
					vista.jugar();
					break;
				case JUEGO_TERMINADO:
					vista.juegoTerminado();
					break;
				case ESPERANDO_JUGADORES:
					vista.iniciar();
					break;
				case RONDA_TERMINADA:
					vista.rondaTerminada(obtenerGanadorDeRonda());
					vista.jugar();
					break;
				case MANO_TERMINADA:
					vista.manoTerminada();
					vista.jugar();
					break;
				case ENVIDO_JUGADO:
					vista.mostrarEnvido(this.obtenerGanadorEnvido().getNombre());
					vista.jugar();
					break;
				case SEGUIR_JUEGO:
					vista.jugar();
					break;
			}
		}
		if(evento instanceof IEnvido) {
			vista.quererNoQuererEnvido(nombreTurno(),(IEnvido) evento);
		}
		if(evento instanceof EstadoTruco) {
			vista.quererNoQuererTruco(nombreTurno(),(EstadoTruco) evento);
		}
		}
	public IJugador obtenerGanadorEnvido() {
		return modelo.getGanadorEnvido();
	}
	public String nombreTurno() {
		return modelo.getITurno().getNombre();
	}
	/**
	 * @return devuelve el IJugador ganador.
	 */
	public IJugador termino() {
		IJugador jug1=darJugadores().get(0);
		IJugador jug2=darJugadores().get(1);
		return jug1.getPuntos()>=15?jug1:jug2;
	}
	public void cantar(EstadoEnvido estado) {
		modelo.cantado(estado);
	}
	public void cantar(EstadoTruco estado) {
		modelo.cantado(estado);
	}
	public void tirar(int carta) {
		 modelo.tirarCarta(carta);		
	}
	public void preguntar(Eventos evento) {
		modelo.changeTurno();		
	}
	public void terminarMano() {
		modelo.sumarPuntosAlMazo();		
	}
	public void alMazo() {
		modelo.sumarPuntosAlMazo();
	}
	public void quiero() {
		modelo.calcularEnvidoQ() ;
	}
	public void quiero(EstadoTruco estado) {
		modelo.quiero(estado);
	}
	public void noQuiero() {
		modelo.calcularEnvidoNQ();		
	}
	public ArrayList<IJugador> darJugadores() {
		return modelo.listarJugadores();
	}
	public EstadoTruco queSeEstaJugando() {
		return modelo.getEstadoTruco();
	}
	public ArrayList<String> listarCartas() {
		ArrayList<String> cartas=new ArrayList<String>();
		for (Carta carta:modelo.getITurno().getCartas()) {
			cartas.add(carta.toString());
		}
		return cartas ;
	}
	public String getCartaTirada() {
		return modelo.getCartaTirada()==null?null:modelo.getCartaTirada().toString();
	}
	public int rondaActual() {
		return modelo.getNroRonda();		
	}
	public int obtenerCantCartasJugActual() {
		return modelo.getITurno().getCartas().size();
	}
	public String obtenerGanadorDeRonda() {
		return modelo.getGanadorDeRonda().getNombre();
	}
	public String queTrucoPuedeCantar() {
		String retorno = "";
		if (quienCantoUltimo()!= turnoActual()) {
		EstadoTruco estado= modelo.getEstadoTruco();
		switch(estado) {
		case NADA:
			retorno="Truco";
			break;
		case TRUCO:
			retorno="Re truco";
			break;
		case RETRUCO:
			retorno="Vale cuatro";
		}}
		return retorno;
		
	}
	public ArrayList<Integer> obtenerTantosEnvido(){
		return modelo.getTantosEnvido();
	}
	public IJugador turnoActual() {
		return modelo.getITurno();
	}
	public IJugador quienCantoUltimo() {
		return modelo.quienCantoUltimo();
	}

	/**
	 * @return true si el jugador actual puede cantar envidos
	 */
	public boolean puedeCantarEnvidos(){
		return (rondaActual()==1)&&(!modelo.rondaActualTerminada())&&(obtenerGanadorEnvido()==null)&&(queSeEstaJugando()==EstadoTruco.NADA);

	}
	public ArrayList<String> obtenerCartasRonda() {
		return modelo.getCartasDeRonda();
	}
}