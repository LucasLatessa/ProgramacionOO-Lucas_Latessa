package modelo;
import java.util.ArrayList;

public class Mazo {
	ArrayList<Carta> cartas = new ArrayList<Carta>();
	public Mazo() {
		for(Carta c: Carta.values()){
			cartas.add(c);
		}
	}
	public Carta dar() {
		int index = (int)(Math.random() * cartas.size());
		Carta devolver=cartas.get(index);
		cartas.remove(index);
		return devolver;
	}
}
