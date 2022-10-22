package modelo;
import java.util.ArrayList;

public class Jugador implements IJugador{
		
		private String nombre;
		private ArrayList<Carta> cartas = new ArrayList<Carta>();
		private boolean mano;
		private Carta cartaTirada;//para cuando el mano juege, el pie canta envido tener la carta
		public Carta getCartaTirada() {
			return cartaTirada;
		}
		private int puntos;
		private boolean turno;
	
	public Jugador(String nombre) {
		this.nombre=nombre;
	}
	public void repartir(Mazo mazo,Jugador contra) {
		vaciarCartas();
		contra.vaciarCartas();
		for(int i = 0;i < 3;i++) {
			contra.setCarta(mazo.dar());
			setCarta(mazo.dar());
		}
		mano=false;
	}
	
	public void vaciarCartas( ) {
		cartas.clear();
	}
	public Eventos querer(Eventos evento) {
		switch(evento) {
		case TRUCO_CANTADO:
			return Eventos.TRUCO_QUERIDO;
		case RETRUCO_CANTADO:
			return Eventos.RETRUCO_QUERIDO;
		case VALECUATRO_CANTADO:
			return Eventos.VALECUATRO_QUERIDO;
		case ENVIDO_CANTADO:
			return Eventos.ENVIDO_QUERIDO;
		case REALENVIDO_CANTADO:
			return Eventos.REALENVIDO_QUERIDO;
		case FALTAENVIDO_CANTADO:
			return Eventos.FALTAENVIDO_QUERIDO;
		default:
			return evento;
	}
		}
	/**
	 *@return Retorna la carta que quiere tirar jugador<1-3>, en caso de que no tenga esa carta en mano devuelve nulo
	 */
	public Carta tirarCarta(int carta) {
		Carta retorno=null;
		if (carta<= cartas.size()) {
			retorno=cartas.get(carta-1);}
		return retorno;
		
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isMano() {
		return mano;
	}
	public String getNombre() {
		return nombre;
	}
	public void serMano() {
		mano=true;
	}
	public void setCarta(Carta carta) {
		cartas.add(carta);
	}
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	public boolean isTurno() {
		return turno;
	}
	public void setTurno(boolean turno) {
		this.turno = turno;
	}
	
}
