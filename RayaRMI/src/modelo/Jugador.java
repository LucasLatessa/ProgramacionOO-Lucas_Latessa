package modelo;
import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements IJugador,Serializable {
	private static final long serialVersionUID = 1L;
		private String nombre;
		private ArrayList<Carta> cartas = new ArrayList<Carta>();
		private int puntos=0;
		private int puntosParciales=0;
		private boolean turno=false;
		private boolean rayado=false;
	public Jugador(String nombre) {
		this.nombre=nombre;
	}
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	protected void setCarta(Carta carta) {
		cartas.add(carta);
		if (carta.getValor()>9) {
			rayado=carta.getValor()>9;
		}else {
			puntosParciales+=carta.getValor();
		}
	}
	protected void limpiarCartas() {
		cartas.clear();
		rayado=false;
		puntosParciales=0;
	}
	public int getPuntosParciales() {
		return puntosParciales;
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
	public boolean isTurno() {
		return turno;
	}
	public void mePlanto() {
		if (!rayado) {
			for(Carta carta:cartas) {
				incPuntos(carta.getValor());
			}
		}
	}
	public void changeTurno() {
		this.turno = !(turno);
	}
	public void setTurno(boolean b) {
		this.turno=b;
	}
	public boolean isRayado() {
		return this.rayado;
	}
	public Carta getUltCarta() {
		return cartas.get(cartas.size()-1);
	}
	
}
