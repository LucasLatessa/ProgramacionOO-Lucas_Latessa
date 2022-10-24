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
		private int mano;//<1-3>
		private ArrayList<Observador> observadores;
		private ArrayList<Eventos> eventosEnMano;//cada vez que reparto poner vacio
		public Juego() {
		observadores=new ArrayList<>();
		
	}
	public void changeTurno() {
		if (jugador1.isTurno()) {
			jugador2.setTurno(true);
			jugador1.setTurno(false);
		}else if (jugador2.isTurno()) {
			jugador1.setTurno(true);
			jugador2.setTurno(false);
		}else {
			if (jugador1.isMano()){
				jugador1.setTurno(true);}
				else {
					jugador2.setTurno(true);;
				}
			}
		}
	/**
	 * @return devuelve el ganador del envido, para todas las variantes.falta implementar caso que tiene tres cartas del mismo palo
	 */
	private int calcularTantos(Jugador jugador) {
		int sumatoriajug=0;
		ArrayList<Carta> cartasjug=jugador.getCartas();
		Carta carta1=cartasjug.get(0);
		Carta carta2=cartasjug.get(1);
		Carta carta3=null;
		if (cartasjug.size()==3) {
			carta3=cartasjug.get(3);
		} else {
			carta3=jugador.getCartaTirada();
		}
			int c1v=carta1.getValor();int c2v=carta1.getValor();int c3v=carta1.getValor();//valoraciones de cartas
			if (carta1.getPalo().equals(carta2.getPalo())&&carta2.getPalo().equals(carta3.getPalo())) {//caso son las 3 cartas mismo palo			
				sumatoriajug+=((c1v<10)&&(((c2v<10)&&(c2v<c1v))||((c3v<10)&&(c3v<c1v))))?c1v:0;
				sumatoriajug+=((c2v<10)&&(((c1v<10)&&(c1v<c2v))||((c3v<10)&&(c3v<c2v))))?c2v:0;
				sumatoriajug+=((c3v<10)&&(((c1v<10)&&(c1v<c3v))||((c2v<10)&&(c2v<c3v))))?c3v:0;
				sumatoriajug+=20;} 
			else if(carta1.getPalo().equals(carta2.getPalo())) {
				sumatoriajug=((c1v<10)&&(c2v<10))?c1v+c2v:0;
				sumatoriajug=((10>=c1v)&&(c2v<10))?c2v:0;
				sumatoriajug=((10>=c2v)&&(c1v<10))?c1v:0;
				sumatoriajug+=20;}
			else if(carta1.getPalo().equals(carta3.getPalo())) {
				sumatoriajug=((c1v<10)&&(c3v<10))?c1v+c3v:0;
				sumatoriajug=((10>=c1v)&&(c3v<10))?c3v:0;
				sumatoriajug=((10>=c3v)&&(c1v<10))?c1v:0;
				sumatoriajug+=20;}
			else if(carta3.getPalo().equals(carta2.getPalo())) {
				sumatoriajug=((c3v<10)&&(c2v<10))?c3v+c2v:0;
				sumatoriajug=((10>=c3v)&&(c2v<10))?c2v:0;
				sumatoriajug=((10>=c2v)&&(c3v<10))?c3v:0;
				sumatoriajug+=20;}
			return sumatoriajug;
	}
	public Jugador envidos() {
		int sumatoriajug1=calcularTantos(jugador1);
		int sumatoriajug2=calcularTantos(jugador2);
		if (sumatoriajug1==sumatoriajug2){
			return jugador1.isMano()? jugador1:jugador2;//si los tantos son iguales, gana el mano
		}else {
			return (sumatoriajug1>sumatoriajug2)?jugador1:jugador2;//se devuelve el jugador con mas tantos
		}
		
	}
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
	public void cantado(Eventos evento) {
		notificar(evento);
	}
	public Jugador nuevaRonda() {
		mazo=new Mazo();
		eventosEnMano=new ArrayList<>();
		mano=1;
		if (jugador2.isMano()){
			jugador2.repartir(mazo,jugador1);
			jugador1.serMano();
			changeTurno();
			return jugador1;
		}else {
			jugador1.repartir(mazo,jugador2);//la primera mano del juego siempre la da el jugador 1
			jugador2.serMano();
			changeTurno();
			return jugador2;
		}
	}
	public int getMano() {
		return mano;
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
	public ArrayList<Eventos> getEventos(){
		return this.eventosEnMano;
}
	public void agregarEvento(Eventos evento) {
		if (evento==Eventos.RETRUCO_QUERIDO||evento==Eventos.VALECUATRO_QUERIDO){//si es uno de estos casos actualizo lo que se esta jugando
			eventosEnMano.remove(eventosEnMano.size());
			eventosEnMano.add(evento);
		}
		else {
			eventosEnMano.add(evento);
		}
		
	}
	
}
