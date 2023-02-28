package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;

import modelo.Eventos;
import modelo.IJugador;
import modelo.Juego;
import modelo.Carta;
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
				case REPARTIDO:
					vista.jugar();
					break;
				case PUEDE_EMPEZAR_JUEGO:
					vista.iniciar();
					break;
				case NO_ENTRAN_MAS_JUGADORES:
					vista.noEntranMasJugadores();
					break;
				case JUGADOR_AGREGADO:
					//vista.esperandoJugadores();cuando implemento RMI descomentar
					vista.iniciar();//cuando implemento RMI sacar
					break;
				case INTERMEDIO_GANADO:
					vista.mostrarCartaIntermedia();
					break;
				case INTERMEDIO_PERDIDO:
					vista.mostrarCartaIntermedia();
					break;
				case MANO_TERMINADA:
					vista.manoTerminada();
					modelo.nuevaMano();
					break;
				case JUEGO_TERMINADO:
					vista.juegoTerminado();
					break;
					
			}
		}
		}
	/**
	 * @return devuelve el IJugador ganador.
	 */
	public IJugador termino() {
		return null;
	}
	public ArrayList<IJugador> getJugadores() {
		return this.modelo.listarJugadores();
	}
	public void quiero() {
		modelo.darTercerCarta() ;
	}
	public ArrayList<IJugador> darJugadores() {
		return modelo.listarJugadores();
	}
	public ArrayList<String> listarCartas() {
		ArrayList<String> cartas=new ArrayList<String>();
		for (Carta carta:modelo.getITurno().getCartas()) {
			cartas.add(carta.toString());
		}
		return cartas ;
	}
	public IJugador turnoActual() {
		return modelo.getITurno();
	}
	public Carta getCartaIntermedio() {
		return modelo.getCartaIntermedio();
	}
	public void empezarJuego() {
		modelo.jugar();
	}
	public boolean puedeEmpezarJuego() {
		return modelo.puedeEmpezarJuego();
	}
}