package controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;
import modelo.Eventos;
import modelo.IJuego;
import modelo.IJugador;
import modelo.Juego;
import modelo.Carta;
import observer.Observable;
import observer.Observador;
import vista.IVista;
import vista.VistaConsola;

	public class Controlador implements IControladorRemoto{
		private IJuego modelo;
		private IVista vista;
		private String jugador="";
	
	public Controlador( IVista vista) {
		this.vista = vista;
		this.vista.setControlador(this);
	}
	public void agregarJugador(String jugador) throws RemoteException  {
		this.jugador=jugador;
		modelo.agregarJugador(jugador);
	}

	@Override
	public void actualizar(IObservableRemoto observado, Object evento) throws RemoteException {
		if(evento instanceof Eventos) {
			switch((Eventos) evento) {
				case REPARTIDO:
					if (esTurnoEsteJugador()) {
						vista.jugar();
						}
					else {
						vista.esperarJugandoOponente();
					}
					break;
				case PUEDE_EMPEZAR_JUEGO:
					vista.preguntaEmpezar();
					break;
				case NO_ENTRAN_MAS_JUGADORES:
					vista.preguntaEmpezar();
					break;
				case JUGADOR_AGREGADO:
					if (jugador!=null) {
						vista.esperandoJugadores();}	
					break;
				case INTERMEDIO_GANADO:
					vista.mostrarCartaIntermedia();
					break;
				case INTERMEDIO_PERDIDO:
					vista.mostrarCartaIntermedia();
					break;
				case DINERO_INGRESADO:
					vista.actualizarDinero(this.dineroEsteJug());
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
	
	public int getPozo() throws RemoteException {
		return modelo.getPozo();
	}
	private int dineroEsteJug() throws RemoteException {
		for(IJugador jug:getJugadores()) {
			if (jugador.equals(jug.getNombre())){
				return jug.getDinero();
			}
		}
		return 0;
	}
	public ArrayList<IJugador> getJugadores() throws RemoteException {
		return this.modelo.listarJugadores();
	}
	public void quiero() throws RemoteException {
		modelo.darTercerCarta() ;
	}
	public ArrayList<IJugador> darJugadores() throws RemoteException {
		return modelo.listarJugadores();
	}
	public ArrayList<String> listarCartas() throws RemoteException {
		ArrayList<String> cartas=new ArrayList<String>();
		for (Carta carta:modelo.getITurno().getCartas()) {
			cartas.add(carta.toString());
		}
		return cartas ;
	}
	public IJugador turnoActual() throws RemoteException {
		return modelo.getITurno();
	}
	public Carta getCartaIntermedio() throws RemoteException {
		return modelo.getCartaIntermedio();
	}
	public void empezarJuego() throws RemoteException {
		modelo.jugar();
	}
	public boolean puedeEmpezarJuego() throws RemoteException {
		return modelo.puedeEmpezarJuego();
	}
	private boolean esTurnoEsteJugador() throws RemoteException {
		return turnoActual().getNombre().equals(getJugador());
	}
	public boolean noNombreRepetido(String nombre) throws RemoteException {
		return modelo.verificarNombre(nombre);
	}
	public String getJugador() {
		return jugador;
	}
	@Override
	public <T extends IObservableRemoto> void setModeloRemoto(T modelo) throws RemoteException {
		this.modelo = (IJuego) modelo;
		
	}
	public void noQuiero() throws RemoteException {
		modelo.proximoTurno();
	}
	public void ingresarDinero(String nombre,int dinero) throws RemoteException {
		modelo.introducirDinero(nombre,dinero);
	}
}