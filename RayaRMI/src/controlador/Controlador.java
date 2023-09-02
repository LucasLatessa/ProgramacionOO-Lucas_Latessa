package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;
import modelo.Eventos;
import modelo.IJugador;
import modelo.IJuego;
import modelo.Carta;
import vista.IVista;

	public class Controlador implements IControladorRemoto{
		private IJuego modelo;
		private IVista vista;
		private String jugador=null;
	
		public Controlador( IVista vista) {
			this.vista = vista;
			this.vista.setControlador(this);
		}
	public void agregarJugador(String jugador) throws RemoteException {
		this.jugador=jugador;
		modelo.agregarJugador(jugador);
	}
	@Override
	public void actualizar(IObservableRemoto observado, Object evento) throws RemoteException {
		if(evento instanceof Eventos) {
			switch((Eventos) evento) {
			case CAMBIO_TURNO:
				if (esTurnoEsteJugador()) {
					vista.jugar();
					}
				else {
					vista.esperarJugandoOponente();
				}
				break;
			case PUEDE_EMPEZAR_JUEGO:
				vista.iniciar();
				break;
			case NO_ENTRAN_MAS_JUGADORES:
				vista.noEntranMasJugadores();
				break;
			case JUGADOR_AGREGADO:
				if (jugador!=null) {
					vista.esperandoJugadores();}
				break;
			case SEGUIR_JUEGO:
				if (esTurnoEsteJugador()) {
					vista.jugar();
					}
				else {
					vista.esperarJugandoOponente();
				}
				break;
			case RAYA:
				if (esTurnoEsteJugador()) {
					vista.mostrarRaya();
					}
				else {
					vista.esperarJugandoOponente();
				}			
				modelo.siguienteTurno();
				break;
			case MANO_TERMINADA:
				if (esTurnoEsteJugador()) {
					vista.mostrarRepartir();}
				else {
					vista.reparteOponente();
				}
				break;
			case MANO_TERMINADA_Y_RAYA:
				if (esTurnoEsteJugador()) {
					vista.mostrarRaya();
					vista.mostrarRepartir();}
				else {
					vista.reparteOponente();
				}
				break;
			case JUEGO_TERMINADO:
				vista.juegoTerminado();
				break;
				
		}
		}}
	private boolean esTurnoEsteJugador() throws RemoteException {
		return turnoActual().getNombre().equals(getJugador());
	}
	public String getJugador() {
		return jugador;
	}
	public String nombreTurno()throws RemoteException {
		return modelo.getITurno().getNombre();
	}
	public void quiero()throws RemoteException{
		modelo.pedirCarta() ;
	}
	public void noQuiero()throws RemoteException {
		modelo.noQuieroCarta();//cuando el jugador se planta		
	}
	public ArrayList<IJugador> darJugadores()throws RemoteException {
		return modelo.listarJugadores();
	}
	public ArrayList<String> listarCartas() throws RemoteException {
		ArrayList<String> cartas=new ArrayList<String>();
		for (Carta carta:modelo.getITurno().getCartas()) {
			cartas.add(carta.toString());
		}
		return cartas ;
	}
	public boolean puedePedir() throws RemoteException {
		return modelo.turnoPuedePedir();
	}
	public int obtenerCantCartasJugActual() throws RemoteException {
		return modelo.getITurno().getCartas().size();
	}
	public IJugador turnoActual() throws RemoteException {
		return modelo.getITurno();
	}
	public void empezarJuego() throws RemoteException {
		modelo.nuevaRonda();
	}
	public boolean puedeEmpezarJuego() throws RemoteException {
		return modelo.puedeEmpezarJuego();
	}
	public IJugador termino() throws RemoteException {
		if(modelo.hayGanador()) {
			return modelo.getGanador();
		}else {
			return null;
		}
	}
	public boolean verificarNombre(String nameJ1) throws RemoteException {
		return modelo.verificarNombre(nameJ1);
	}
	@Override
	public <T extends IObservableRemoto> void setModeloRemoto(T modelo) throws RemoteException {
		this.modelo = (IJuego) modelo;
		
	}
}