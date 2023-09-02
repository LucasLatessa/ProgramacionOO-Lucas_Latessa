package modelo;
import java.util.ArrayList;

import observer.Observador;
import observer.Observable;
public class Juego implements Observable{
	private static final int puntosFinales = 100;
	private Jugador jugadorTurno=null;
	private ArrayList<Jugador>jugadores;
	private ArrayList<Observador> observadores;
	private Mazo mazo;
	private Jugador ganador= null;
	private int contJugRonda=0;
	public IJugador getGanador() {
		return this.ganador;
	}
public Juego(){
	this.jugadores = new ArrayList<>();
	this.observadores=new ArrayList<>();
	this.mazo=new Mazo();
}
public void agregarJugador(String id)   {
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
public void pedirCarta()   {
	jugadorTurno.setCarta(mazo.dar());
	if(jugadorTurno.isRayado()) {
		notificar(Eventos.RAYA);
	}else {
		notificar(Eventos.SEGUIR_JUEGO);
	}
}
public void nuevaRonda()   {
	if(!this.hayGanador()) {
		for (Jugador jugador:jugadores) {
			jugador.limpiarCartas();}
		contJugRonda=0;
		this.mazo=new Mazo();
		repartir();
		}
	else {
		notificar(Eventos.JUEGO_TERMINADO);
		}
	}
public void repartir()   {
	for (Jugador jugador: jugadores) {
			jugador.setCarta(mazo.dar());}
	siguienteTurno();
}
public void siguienteTurno()  {
	if(contJugRonda>=jugadores.size()) {
		notificar(Eventos.MANO_TERMINADA);
	}else {
		contJugRonda+=1;
		if (jugadorTurno==null){//primera ronda del juego
			jugadorTurno=jugadores.get(0);
		}
		else {
			Jugador anteriorTurno=jugadorTurno;
			anteriorTurno.changeTurno();//seteamos en false
			for (int i = 0;i < jugadores.size();i++) {
				if (jugadorTurno==jugadores.get(i)) {
					if(jugadores.size()==i+1) {
						this.jugadorTurno=jugadores.get(0);
					}else {
						this.jugadorTurno=jugadores.get(i+1);
					}
				break;}
				}}
		this.jugadorTurno.changeTurno();//seteamos en true
		if(jugadorTurno.isRayado()) {
			notificar(Eventos.RAYA);
		}
		else {
			notificar(Eventos.CAMBIO_TURNO);}
	}}
/**
 * @return devuelve true si hay ganador del juego
 */
public boolean hayGanador() {
	int puntosGanador=0;
	for (Jugador jugador:this.jugadores) {
		if (jugador.getPuntos()>=puntosFinales&&jugador.getPuntos()>puntosGanador) {
			ganador=jugador;
			puntosGanador=jugador.getPuntos();
		}
	}
	return !(ganador==null);
}
public IJugador getITurno() {
	return jugadorTurno;
}
public ArrayList<IJugador> listarJugadores() {
	ArrayList<IJugador> listJugadores=new ArrayList<>() ;
	for (Jugador jugador:this.jugadores) {
		listJugadores.add(jugador);}
	return listJugadores;
}
public ArrayList<Observador> getObservadores() {
	return observadores;
}
public boolean verificarNombre(String nombre) {
	boolean puedeUsarEsteNombre=true;
	for (Jugador jugador:this.jugadores) {
		if(nombre.equals(jugador.getNombre())) {
			puedeUsarEsteNombre=false;
		}}
	return puedeUsarEsteNombre;
}
	public void noQuieroCarta()   {
		jugadorTurno.mePlanto();
		siguienteTurno();
	}
	public Carta getUltCarta() {
		return  jugadorTurno.getUltCarta();
	}
	public boolean puedeEmpezarJuego() {
		return jugadores.size()>=2;
	}
	public boolean turnoPuedePedir() {
		return !jugadorTurno.isRayado();
	}
	@Override
	public void agregarObservador(Observador observador) {
		this.observadores.add(observador);
	}
	@Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}
}