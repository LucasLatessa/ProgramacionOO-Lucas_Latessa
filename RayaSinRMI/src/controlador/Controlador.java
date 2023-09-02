package controlador;

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
	public void agregarJugador(String jugador) {
		modelo.agregarJugador(jugador);
	}
	@Override
	public void actualizar(Object evento, Observable observado)  {
		if(evento instanceof Eventos) {
			switch((Eventos) evento) {
			case CAMBIO_TURNO:
					vista.jugar();
				break;
			case PUEDE_EMPEZAR_JUEGO:
				vista.iniciar();
				break;
			case NO_ENTRAN_MAS_JUGADORES:
				vista.noEntranMasJugadores();
				break;
			case JUGADOR_AGREGADO:
				vista.iniciar();
				break;
			case SEGUIR_JUEGO:
					vista.jugar();
				break;
			case RAYA:
				vista.mostrarRaya();
				modelo.siguienteTurno();
				break;
			case MANO_TERMINADA:
				vista.mostrarRepartir();
				break;
			case MANO_TERMINADA_Y_RAYA:
					vista.mostrarRaya();
					vista.mostrarRepartir();
				break;
			case JUEGO_TERMINADO:
				vista.juegoTerminado();
				break;
				
		}
		}}
	public String nombreTurno(){
		return modelo.getITurno().getNombre();
	}
	public void quiero(){
		modelo.pedirCarta() ;
	}
	public void noQuiero()  {
		modelo.noQuieroCarta();//cuando el jugador se planta		
	}
	public ArrayList<IJugador> darJugadores()  {
		return modelo.listarJugadores();
	}
	public ArrayList<String> listarCartas()   {
		ArrayList<String> cartas=new ArrayList<String>();
		for (Carta carta:modelo.getITurno().getCartas()) {
			cartas.add(carta.toString());
		}
		return cartas ;
	}
	public boolean puedePedir()   {
		return modelo.turnoPuedePedir();
	}
	public int obtenerCantCartasJugActual()  {
		return modelo.getITurno().getCartas().size();
	}
	public IJugador turnoActual()   {
		return modelo.getITurno();
	}
	public void empezarJuego()   {
		modelo.nuevaRonda();
	}
	public boolean puedeEmpezarJuego()   {
		return modelo.puedeEmpezarJuego();
	}
	public IJugador termino()   {
		if(modelo.hayGanador()) {
			return modelo.getGanador();
		}else {
			return null;
		}
	}
	public boolean verificarNombre(String nameJ1)   {
		return modelo.verificarNombre(nameJ1);
	}
}