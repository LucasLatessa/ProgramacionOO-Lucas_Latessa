package modelo;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import ar.edu.unlu.rmimvc.observer.ObservableRemoto;
import observer.Observador;
public class Juego extends ObservableRemoto implements  IJuego,Serializable{
	private static final long serialVersionUID = 1L;
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
public void agregarJugador(String id) throws RemoteException {
	Jugador jugador=new Jugador(id);
	jugadores.add(jugador);
	if (jugadores.size()==5) {//VALIDO HASTA 5 JUGADORES
		this.notificarObservadores(Eventos.NO_ENTRAN_MAS_JUGADORES);
	}else if (jugadores.size()>=2) {
		this.notificarObservadores(Eventos.PUEDE_EMPEZAR_JUEGO);
	}else {
		this.notificarObservadores(Eventos.JUGADOR_AGREGADO);	
	}
}
public void pedirCarta() throws RemoteException {
	jugadorTurno.setCarta(mazo.dar());
	if(jugadorTurno.isRayado()) {
		notificarObservadores(Eventos.RAYA);
	}else {
		notificarObservadores(Eventos.SEGUIR_JUEGO);
	}
}
public void nuevaRonda() throws RemoteException {
	if(!this.hayGanador()) {
		for (Jugador jugador:jugadores) {
			jugador.limpiarCartas();}
		contJugRonda=0;
		this.mazo=new Mazo();
		repartir();
		}
	else {
		notificarObservadores(Eventos.JUEGO_TERMINADO);
		}
	}
public void repartir() throws RemoteException {
	for (Jugador jugador: jugadores) {
			jugador.setCarta(mazo.dar());}
	siguienteTurno();
}
public void siguienteTurno() throws RemoteException{
	if(contJugRonda>=jugadores.size()) {
		if(jugadorTurno.isRayado()) {
			notificarObservadores(Eventos.MANO_TERMINADA_Y_RAYA);
		}else {
		notificarObservadores(Eventos.MANO_TERMINADA);}
	}else {
		contJugRonda+=1;
		if (jugadorTurno==null){//primera ronda del juego
			jugadorTurno=jugadores.get(0);
		}
		else {
			jugadorTurno.changeTurno();//seteamos en false
			for(Jugador jug:jugadores) {
				if(jugadorTurno==jug) {
					this.jugadorTurno=this.siguiente(jug);
				}
			}
				}
		this.jugadorTurno.changeTurno();//seteamos en true
		if(jugadorTurno.isRayado()) {
			notificarObservadores(Eventos.RAYA);
		}
		else {
			notificarObservadores(Eventos.CAMBIO_TURNO);}
	}}
private Jugador siguiente(Jugador jug) {
	Jugador siguiente=null;
	for (int i = 0;i < jugadores.size();i++) {
		if (jug==jugadores.get(i)) {
			if(jugadores.size()==i+1) {
				siguiente=jugadores.get(0);
			}else {
				siguiente=jugadores.get(i+1);
			}}}
	return siguiente;
}
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
	public void noQuieroCarta() throws RemoteException {
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
}