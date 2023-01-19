package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;
import modelo.Eventos;
import modelo.IEnvido;
import modelo.IJugador;
import modelo.IJuego;
import modelo.Ronda;
import modelo.Carta;
import modelo.EstadoEnvido;
import modelo.EstadoTruco;
import observer.Observable;
import observer.Observador;
import vista.IVista;

	public class Controlador implements IControladorRemoto{
		private IJuego modelo;
		private IVista vista;
		public Controlador(IVista vista) {
			this.vista = vista;
			this.vista.setControlador(this);
		}

		public void setVista(IVista vista) {
			this.vista = vista;
		}
	public void agregarJugador(String jugador) {
		try {
			modelo.agregarJugador(jugador);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	public IJugador obtenerGanadorEnvido() {
		try {
			return modelo.getGanadorEnvido();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public String nombreTurno() {
		try {
			return modelo.getITurno().getNombre();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @return devuelve false si el ganador es nulo, de haber un ganador devuelve el jugador.
	 */
	public IJugador termino() {
		try {
			return modelo.preguntarGanador();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
	public void preguntar(Eventos evento) {
		try {
			modelo.changeTurno();
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
			return null;
		}
	}
	public EstadoTruco queSeEstaJugando() {
		try {
			return modelo.getEstadoTruco();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public ArrayList<String> listarCartas() {
		ArrayList<String> cartas=new ArrayList<String>();
		try {
			for (Carta carta:modelo.getITurno().getCartas()) {
				cartas.add(carta.toString());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartas ;
	}
	public String getCartaTirada() {
		try {
			return modelo.getCartaTirada()==null?null:modelo.getCartaTirada().toString();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int rondaAcutual() {
		try {
			return modelo.getNroRonda();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;		
		}
		
	}
	public int rondaAnterior() {
		try {
			return modelo.getNroRonda()-1;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;		
		}
	}
	public int obtenerCantCartasJugActual() {
		try {
			return modelo.getITurno().getCartas().size();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;		
		}
	}
	public ArrayList<Integer> obtenerTantosEnvido(){
		try {
			return modelo.obtenerTantosEnvido();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;		
		}
	}
	public IJugador turnoActual() {
		try {
			return modelo.getITurno();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public IJugador quienCantoUltimo() {
		try {
			return modelo.quienCantoUltimo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public void actualizar(IObservableRemoto modelo, Object evento) throws RemoteException {
		if((evento instanceof Eventos) ){
			switch((Eventos) evento) {
				case JUEGO_COMENZADO:
					vista.jugar();
					break;
				case JUEGO_TERMINADO:
					vista.juegoTerminado();
					break;
				case ESPERANDO_JUGADORES:
					vista.esperandoJugadores();
					vista.iniciar();
					break;
				case PARDA:
					
					vista.avisarParda();
					vista.jugar();
					break;
				case RONDA_TERMINADA:
				try {
					vista.rondaTerminada(((IJuego) modelo).obtenerGanadorDeRonda().getNombre());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
					break;}
			}
		
		if(evento instanceof IEnvido) {
			vista.quererNoQuererEnvido(nombreTurno(),(IEnvido) evento);
		}
		if(evento instanceof EstadoTruco) {
			vista.quererNoQuererTruco(nombreTurno(),(EstadoTruco) evento);
		}
		}
	@Override
	public <T extends IObservableRemoto> void setModeloRemoto(T modeloRemoto) throws RemoteException {
		this.modelo=(IJuego) modeloRemoto;
		
	}


	public void cerrarApp() {
		// TODO Auto-generated method stub
		
	}


	public void enviarMensaje(Object textoMensaje) {
		// TODO Auto-generated method stub
		
	}


	public void conectarUsuario(String getNombreUsuario) {
		// TODO Auto-generated method stub
		
	}
}