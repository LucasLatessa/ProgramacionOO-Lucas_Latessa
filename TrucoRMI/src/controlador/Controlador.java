package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;
import ar.edu.unlu.rmimvc.observer.ObservableRemoto;
import modelo.Eventos;
import modelo.IEnvido;
import modelo.IJuego;
import modelo.IJugador;
import modelo.Juego;
import modelo.Ronda;
import modelo.Carta;
import modelo.EstadoEnvido;
import modelo.EstadoTruco;
import observer.Observable;
import observer.Observador;
import vista.IVista;
import vista.VistaConsola;

	public class Controlador implements IControladorRemoto{
		private IJuego modelo;
		private IVista vista;
		private String jugador;
		public String getJugador() {
			return jugador;
		}
		public Controlador(IVista vista) {
			this.vista = vista;
			this.vista.setControlador(this);
			
		}
	public void agregarJugador(String jugador) {
		this.jugador=jugador;
		try {
			modelo.agregarJugador(jugador);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setModeloRemoto(IJuego modelo) {
		this.modelo=(Juego) modelo;
	}
	@Override
	public void actualizar(IObservableRemoto observable, Object evento) throws RemoteException {
		if(evento instanceof Eventos) {
			
			switch((Eventos) evento) {
				case JUEGO_COMENZADO:
						if (jugador==null){
						jugador=modelo.getJugadorUltAgregado();}
					if (esTurnoEsteJugador()) {
						vista.jugar();
						}
					else {
						vista.esperarJugandoOponente();
					}
					break;
				case PARDA:
					vista.avisarParda();
					if (esTurnoEsteJugador()) {
						vista.jugar();
						}
					else {
						vista.esperarJugandoOponente();
					}
					break;
				case JUEGO_TERMINADO:
					vista.juegoTerminado();
					if(this.termino().getNombre().equals(jugador)) {
						vista.serializar(jugador);
					}
					break;
				case ESPERANDO_JUGADORES:
					if (jugador!=null) {
					vista.esperandoJugadores();}	
					break;
				case RONDA_TERMINADA:
					vista.rondaTerminada(obtenerGanadorDeRonda().equals(jugador));
					if (esTurnoEsteJugador()) {
						vista.jugar();
						}
					else {
						vista.esperarJugandoOponente();
					}
					break;
				case MANO_TERMINADA:
					vista.manoTerminada();
					if (esTurnoEsteJugador()&&!modelo.isTerminado()) {
						vista.jugar();
						}
					else {
						vista.esperarJugandoOponente();
					}
					break;
				case ENVIDO_JUGADO:
					vista.mostrarEnvido(this.obtenerGanadorEnvido().getNombre());
					modelo.preguntarGanador();
					if (esTurnoEsteJugador()&&!modelo.isTerminado()) {
						vista.jugar();
						}
					else {
						vista.esperarJugandoOponente();
					}
					break;
				case SEGUIR_JUEGO:
					if (esTurnoEsteJugador()) {
						vista.jugar();
						}
					else {
						vista.esperarJugandoOponente();
					}
					break;
			}
		}
		if(evento instanceof IEnvido) {
			if (esTurnoEsteJugador()) {
				vista.quererNoQuererEnvido(nombreTurno(),(IEnvido) evento);
				}
			else {
				vista.esperarJugandoOponente();
			}
		}
		if(evento instanceof EstadoTruco) {
			if (esTurnoEsteJugador()) {
				vista.quererNoQuererTruco(nombreTurno(),(EstadoTruco) evento);
				}
			else {
				vista.esperarJugandoOponente();
			}
		}
		}
	private boolean esTurnoEsteJugador() {
		return nombreTurno().equals(getJugador());
	}
	public IJugador obtenerGanadorEnvido() {
		try {
			return modelo.getGanadorEnvido();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String obtenerGanadorDeRonda() {
		try {
			IJugador ganador=modelo.getGanadorDeRonda();
			return ganador!=null?ganador.getNombre():"";
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public ArrayList<String> obtenerCartasRonda() {
		try {
			return modelo.getCartasDeRonda();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String nombreTurno() {
		try {
			return modelo.getITurno().getNombre();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
		try {
			modelo.cantado(estado);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cantar(EstadoTruco estado) {
		try {
			modelo.cantado(estado);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void tirar(int carta) {
		 try {
			modelo.tirarCarta(carta);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void terminarMano() {
		try {
			modelo.sumarPuntosAlMazo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void alMazo() {
		try {
			modelo.sumarPuntosAlMazo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void quiero() {
		try {
			modelo.calcularEnvidoQ() ;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void quiero(EstadoTruco estado) {
		try {
			modelo.quiero(estado);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void noQuiero() {
		try {
			modelo.calcularEnvidoNQ();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public ArrayList<IJugador> darJugadores() {
		try {
			return modelo.listarJugadores();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private EstadoTruco queSeEstaJugando() {
		try {
			return modelo.getEstadoTruco();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String queTrucoPuedeCantar() {
		String retorno = "";
		try {
			IJugador cantoUlt=quienCantoUltimo();
			boolean puedeCantar=cantoUlt!=null?!(cantoUlt.getNombre()).equals(jugador):true;
			if (puedeCantar) {
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
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
		
	}
	public ArrayList<String> listarCartas() {
		ArrayList<String> cartas=new ArrayList<String>();
		try {
			for (Carta carta:modelo.getITurno().getCartas()) {
				cartas.add(carta.toString().toUpperCase());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartas ;
	}
	public String getCartaTirada() {
		try {
			return modelo.getCartaTirada()==null?null:modelo.getCartaTirada().toString().toUpperCase();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int rondaActual()  {
		try {
			return modelo.getNroRonda();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;		
	}
	public int obtenerCantCartasJugActual()  {
		try {
			return modelo.getITurno().getCartas().size();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public ArrayList<Integer> obtenerTantosEnvido() {
		try {
			return modelo.getTantosEnvido();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public IJugador turnoActual()  {
		try {
			return modelo.getITurno();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public IJugador quienCantoUltimo()  {
		try {
			return modelo.quienCantoUltimo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public <T extends IObservableRemoto> void setModeloRemoto(T modelo) throws RemoteException {
		this.modelo = (IJuego)modelo; 
		
	}
	public boolean hayDosJugadores() {
		try {
			return modelo.isJugadoresCompletos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * @return true si el jugador actual puede cantar envidos
	 * @throws RemoteException 
	 */
	public boolean puedeCantarEnvidos() throws RemoteException {
		return (rondaActual()==1)&&(!modelo.rondaActualTerminada())&&(obtenerGanadorEnvido()==null)&&(queSeEstaJugando()==EstadoTruco.NADA);

	}
	public boolean noNombreRepetido(String nombre) throws RemoteException {
		return modelo.verificarNombre(nombre);
	}
	
}