package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Ijugador{
	private String id;
	private ArrayList<Carta>cartas;
	
	public Jugador(String id) {
		this.id=id;
		this.cartas=new ArrayList<Carta>();
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public List<Carta> getCartas() {
		return this.cartas;
	}
	
	public void agregarCarta(Carta carta) {
		System.out.println("agrego carta a jugador"+ this.getId());
		this.cartas.add(carta);
	}
	

	public void tirarCarta(Carta carta) {
		cartas.remove(carta);
	}
}
