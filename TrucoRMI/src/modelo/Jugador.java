package modelo;
import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements IJugador, Serializable {
		private String nombre;
		private ArrayList<Carta> cartas = new ArrayList<Carta>();
		private Carta cartaTirada;//para cuando el mano juege, el pie canta envido tener la carta
		private int puntos;
		private boolean mano=false;
		private boolean turno=false;
		private boolean cantoUltimo=false;
	public boolean isCantoUltimo() {
			return cantoUltimo;
		}
		public void setCantoUltimo(boolean cantoUltimo) {
			this.cantoUltimo = cantoUltimo;
		}
	public Jugador(String nombre) {
		this.nombre=nombre;
	}
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	protected void setCarta(Carta carta) {
		cartas.add(carta);
	}
	protected void limpiarCartas() {
		cartas.clear();
	}
	/**
	 *@return Retorna la carta que quiere tirar jugador<1-3>, en caso de que no tenga esa carta en mano devuelve nulo
	 */
	protected Carta tirarCarta(int carta) {
		Carta retorno=null;
		if (carta<= cartas.size()) {
			retorno=cartas.get(carta-1);
			cartas.remove(carta-1);}
		cartaTirada=retorno;
		return retorno;
	}
	public Carta getCartaTirada() {
		return cartaTirada;
	}
	public int getPuntos() {
		return puntos;
	}
	protected void incPuntos(int puntos) {
		this.puntos += puntos;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public boolean isMano() {
		return mano;
	}
	public void invertirMano() {
		turno=false;//cada vez que se reparte de nuevo inizializo el turno
		mano=!(mano);
	}
	public boolean isTurno() {
		return turno;
	}
	public void changeTurno() {
		this.turno = !(turno);
	}
	public void setTurno(boolean b) {
		this.turno=b;
	}
	
}
