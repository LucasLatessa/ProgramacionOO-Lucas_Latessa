package modelo;

import java.util.ArrayList;
import observer.Observador;
import observer.Observable;
public class Juego implements Observable{
	private static final int puntajeFinal=10;//se arranca con 5 puntos, gana quien llega a (10), si el puntaje es 0 estas fuera de juego
	private Jugador jugadorTurno;
	private Mazo mazo;
	private ArrayList<Jugador>jugadores;
	private ArrayList<Observador> observadores;
	public Juego(){
		this.jugadores = new ArrayList<>();
		this.observadores=new ArrayList<>();
		this.mazo=new Mazo();

	}
	public void agregarJugador(String id) {
		
		Jugador jugador=new Jugador(id);
		jugadores.add(jugador);
		if (jugadores.size()==5) {//VALIDO HASTA 5 JUGADORES
			this.notificar(Eventos.NO_ENTRAN_MAS_JUGADORES);
		}else if (jugadores.size()>=2) {
			this.notificar(Eventos.PUEDE_EMPEZAR_JUEGO);
		}else {
			this.notificar(Eventos.JUGADOR_AGREGADO);	
		}
	}
	public void jugar() {
		if (jugadorTurno==null) {//solo para la primera mano
			jugadorTurno=jugadores.get(0);
		}
		for (int i = 0;i < jugadores.size();i++) {
			if (jugadorTurno.getPuntos()!=0) {//porque cuando llega a 0 no juega mas
				for(int x = 0;x < 2;x++) {
					jugadorTurno.setCarta(mazo.dar());
				}
				this.notificar(Eventos.REPARTIDO);}
			jugadorTurno=siguiente(jugadorTurno);
		}
		this.notificar(Eventos.MANO_TERMINADA);
	}
	public void nuevaMano() {
		if(!this.preguntarGanador()) {
			jugadorTurno=siguiente(jugadorTurno);
			for (Jugador jugador:jugadores) {
				jugador.limpiarCartas();}
			this.mazo=new Mazo();
			jugar();
			}
		else {
			notificar(Eventos.JUEGO_TERMINADO);
			}
		}
	public Jugador siguiente(Jugador JugadorTurno){
		Jugador retorno=null;
		for (int i = 0;i < jugadores.size();i++) {
			if (JugadorTurno==jugadores.get(i)) {
				if(jugadores.size()==i+1) {
					retorno=jugadores.get(0);
				}else {
				retorno=jugadores.get(i+1);
				}
				break;
			}
		}
		return retorno;
	}
	public IJugador getITurno() {
		return jugadorTurno;
	}
	private boolean preguntarGanador() {
		boolean hayGanador=false;
		for (Jugador jugador:this.jugadores) {
			if (jugador.getPuntos()>=puntajeFinal) {
				hayGanador=true;
			}
		}
		return hayGanador;
		
	}
	public boolean puedeEmpezarJuego() {
		return jugadores.size()>=2;
	}
	public ArrayList<IJugador> listarJugadores() {
			ArrayList<IJugador> listJugadores=new ArrayList<>() ;
			for (Jugador jugador:this.jugadores) {
				listJugadores.add(jugador);}
			return listJugadores;
	}
	public void darTercerCarta() {
		jugadorTurno.setCartaIntermedia(mazo.dar());
		if(jugadorTurno.isGano()) {
			notificar(Eventos.INTERMEDIO_GANADO);
		}else {
			notificar(Eventos.INTERMEDIO_PERDIDO);
		}
	}
	public Carta getCartaIntermedio() {
		return jugadorTurno.getCartaIntermedia();
	}
	public boolean verificarNombre(String nombre) {
		boolean puedeUsarEsteNombre=true;
		for (Jugador jugador:this.jugadores) {
			if(nombre.equals(jugador.getNombre())) {
				puedeUsarEsteNombre=false;
			}}
		return puedeUsarEsteNombre;
	}
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}
	@Override
	public void agregarObservador(Observador observador) {
		this.observadores.add(observador);
	}
	
	
	
	
}
