package modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import observer.Observador;
import observer.Observable;
public class Juego implements Observable{
		static final int puntosFinales = 15;
		private Jugador jugador1;
		private Jugador jugador2;
		private Mazo mazo;
		private ArrayList<Ronda> rondas;//<1-3>
		private ArrayList<Observador> observadores;
	
	public Juego() {
		observadores=new ArrayList<>();
		rondas=new ArrayList<Ronda>();
	}
	/**
	 * Cambia el turno del juego, en caso de que ninguno de los dos haya sido el turno anterior
	    es turno del mano(caso primera ronda).
	 */
	public void changeTurno() {
		if (jugador1.isTurno()||jugador2.isTurno()) {
			jugador2.changeTurno();
			jugador1.changeTurno();
		}else if (jugador1.isMano()){
			jugador1.setTurno(true);}
		else {
			jugador2.setTurno(true);;
				}
			}
		
	/**
	 * @return devuelve el ganador del envido, para todas las variantes.
	 */
	
	
	public ArrayList<Observador> getObservadores() {
		return observadores;
	}
	public void agregarJugador(String jugador){
		if (this.jugador1==null) {
			this.jugador1=new Jugador(jugador);
		}else if (this.jugador2==null){
			this.jugador2=new Jugador(jugador);
			notificar(Eventos.JUEGO_INICIADO);
		}
	}
	public void newRonda() {
		Ronda ronda=new Ronda();
		rondas.add(ronda);
	}
	public void cantado(Eventos evento) {
		notificar(evento);
	}
	public void nuevaMano() {
		rondas=new ArrayList<Ronda>();
		repartir();
		if (!jugador1.isMano()&&!jugador2.isMano()) {
			jugador2.changeMano();//la primer mano del juego es MANO el jugador2
		}else {
			jugador1.changeMano();
			jugador2.changeMano();
		}
		changeTurno();
		}
	public void repartir() {
		mazo=new Mazo();
		vaciarCartas();
		for(int i = 0;i < 3;i++) {
			jugador1.setCarta(mazo.dar());
			jugador2.setCarta(mazo.dar());
		};
	}
	public void vaciarCartas( ) {
			jugador1.limpiarCartas();
			jugador2.limpiarCartas();
		}
		
	public ArrayList<IJugador> listarJugadores(){
		ArrayList<IJugador> jugadores=new ArrayList<>() ;
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		return jugadores;
	}
	/**
	 * @return devuelve el ganador del juego, en caso de no haberlo devuelve nulo
	 */
	public IJugador preguntarGanador() {
		IJugador ganador=null;
		if (jugador1.getPuntos()>=puntosFinales) {
			ganador=jugador1;
		}else if (jugador2.getPuntos()>=puntosFinales){
			ganador=jugador2;
		}
		return ganador;
	}
	@Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}
	@Override
	public void agregarObservador(Observador observador) {
		this.observadores.add(observador);
	}
	public Jugador getJugador1() {
		return jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public Mazo getMazo() {
		return mazo;
	}
	public IJugador getTurno() {
		IJugador retorno=null;
		if (jugador1.isTurno())
		{
			retorno= jugador1;
		}else if (jugador2.isTurno())
		{
			retorno= jugador2;
		}
		return retorno;
	}
}
	
