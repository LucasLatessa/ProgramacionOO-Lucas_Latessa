package Modelo;

import java.util.ArrayList;
import java.util.List;

import Observer.Iobservable;
import Observer.Iobservador;

public class Juego implements Iobservable{

	private int posJugadorActual;
	private Mazo mazoDescarte;
	private Mazo mazoJuego;
	private ArrayList<Carta>cartasEnMesa;
	private ArrayList<Jugador>jugadores;
	private List<Iobservador> observadores;
	
	
	public Juego(){
		this.observadores = new ArrayList<>();
		this.cartasEnMesa=new ArrayList<>();
		this.jugadores = new ArrayList<>();
		this.posJugadorActual=-1;
		this.mazoJuego=new Mazo();
		mazoJuego.cargarCartas(); //solo una vez
		
//####################################ARREGLAR EL MEZCLAR########################################
		//mazoJuego.mezclar();      
		mazoDescarte=new Mazo();

	}
	
	public void agregarJugador(String id) {
		//VALIDAR QUE SEA HASTA 4 JUGADORES
		Jugador jugador=new Jugador(id);
		jugadores.add(jugador);
		if (jugadores.size()>=2) {
			this.notificar(EstadoJuego.JUGADOR_AGREGADO_PUEDE_EMPEZAR);
		}
		this.notificar(EstadoJuego.JUGADOR_AGREGADO);
		
	}
	
	public Jugador JugadorSiguiente() {
		this.posJugadorActual= this.posJugadorActual++;
		return jugadores.get(posJugadorActual);
	}
	
	@Override
	public void notificar(Object evento) {
		for (Iobservador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}
	
	@Override
	public void agregadorObservador(Iobservador observador) {
		this.observadores.add(observador);	
	}

	public ArrayList<Jugador> listarJugadores() {
		return jugadores;
	}
	public int getJugadorActual() {
		return this.posJugadorActual;
	}
	
	public void repartirCartas() { //reparte todas las cartas a los jugadores
		for (int i=1; i<=7;i++){
			for (Jugador jugador:jugadores){
				Carta carta=this.mazoJuego.sacarCarta();
				jugador.agregarCarta(carta);
			}
		}
		//y pone dos en mesa
		this.cartasEnMesa.add(this.mazoJuego.sacarCarta());
		this.cartasEnMesa.add(this.mazoJuego.sacarCarta());
		this.JugadorSiguiente();
		this.notificar(EstadoJuego.CARTAS_REPARTIDAS);
	}
	private void agregarCartaEnMesa() {
		this.cartasEnMesa.add(this.mazoJuego.sacarCarta());
	}
	public void agregarCartaEnMesa(Carta cartaJugador) {
		this.cartasEnMesa.add(cartaJugador);
	}
	public ArrayList<Carta> getCartasEnMesa() {
		return this.cartasEnMesa;
	}

	public void jugarActual(int posCartaJugada,int posCartaJugada2, int posCartaEnMesa) {
		
	}
	public void jugarActual(int posCartaJugada, int posCartaEnMesa) {
		Carta cartaJugador=this.jugadores.get(posJugadorActual).getCartas().get(posCartaJugada);
		Carta cartaMesa=this.cartasEnMesa.get(posCartaEnMesa);
		CompararCarta comparacion=cartaMesa.comparar(cartaJugador);
		
		switch((CompararCarta) comparacion) {
		case IGUAL_NUMERO:
			this.jugadores.get(posJugadorActual).tirarCarta(cartaJugador);
			//las descarto
			this.mazoDescarte.agregarCarta(cartaJugador);
			this.mazoDescarte.agregarCarta(cartaMesa); 
			this.cartasEnMesa.remove(posCartaEnMesa); //la saco de la lista
			this.agregarCartaEnMesa();
			this.notificar(EstadoJuego.CARTA_TIRADA_DESCATADA_PUESTA_OTRA_CARTA);
			//si el jugador no tiene mas cartas se termina el juego
			if ((this.jugadores.get(posJugadorActual).getCartas().size())==0) {
				this.notificar(EstadoJuego.JUEGO_TERMINADO);}
			break;
		case IGUAL_NUMERO_COLOR:
			this.jugadores.get(posJugadorActual).tirarCarta(cartaJugador);
			//las descarto
			this.mazoDescarte.agregarCarta(cartaJugador);
			this.mazoDescarte.agregarCarta(cartaMesa); 
			this.cartasEnMesa.remove(posCartaEnMesa); //la saco de la lista
			//si el jugador no tiene mas cartas se termina el juego
			this.notificar(EstadoJuego.CARTAS_TIRADAS_JUGADOR_PONER_CARTA);
			if ((this.jugadores.get(posJugadorActual).getCartas().size())==0) { 
				this.notificar(EstadoJuego.JUEGO_TERMINADO);}
			break;
		case DISTINTA:
			break;

		}	
	}

	public void robarCartaJugadorActual() {
		this.jugadores.get(posJugadorActual).agregarCarta(this.mazoJuego.sacarCarta());
		this.notificar(EstadoJuego.CARTA_ROBADA);
		
	}
}
