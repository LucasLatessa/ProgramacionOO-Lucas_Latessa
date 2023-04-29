package modelo;
import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements IJugador,Serializable{
		private String nombre;
		private ArrayList<Carta> cartas = new ArrayList<Carta>();//van a ser 2 por mano
		private Carta cartaIntermedia;
		private int dinero=0;
		private boolean turno=false;
	public Jugador(String nombre) {
		this.nombre=nombre;
	}
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	protected void setCarta(Carta carta) {
		if (cartas.size()==2) {
			this.cartas = new ArrayList<Carta>();
		}
		cartas.add(carta);
	}
	protected void setCartaIntermedia(Carta carta) {
		cartaIntermedia=(carta);
	}
	protected Carta getCartaIntermedia() {
		return (cartaIntermedia);
	}
	/**
	 * @return true si el jugador tiene dos cartas y ademas la cartaIntermedio esta entre las otras dos
	 */
	public boolean isGano(int pozo) {
		boolean gano=false;
		if(cartas.size()==2) {
			Carta c1=cartas.get(0);
			Carta c2=cartas.get(1);
			gano=cartaIntermedia.estaEntre(c1,c2);
			if (gano) {
				this.incDinero(pozo);
			}else {
				this.decDinero(pozo);;
			}
		}
		
		return gano;
	}
	
	protected void limpiarCartas() {
		cartas.clear();
	}
	public int getDinero() {
		return dinero;
	}
	protected void incDinero(int dinero) {
		this.dinero += dinero;
	}
	private void decDinero(int dinero) {
		this.dinero -= dinero;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
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
	public boolean yaJugoEstaMano() {
		return cartas.size()!=0;
	}
	
}
