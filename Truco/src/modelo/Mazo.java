package modelo;
import java.util.ArrayList;

public class Mazo {
	ArrayList<Carta> cartas = new ArrayList<Carta>();
	public Mazo() {
		for(Palo palo: Palo.values()) {
			for(int i = 1;i<=7;i++){
				Carta carta=new Carta(i,palo);
				cartas.add(carta);
			}
			for(int i = 10;i<=12;i++){
				Carta carta=new Carta(i,palo);
				cartas.add(carta);
			
			}
		}
		int i=0;
	}
	public Carta dar() {
		int index = (int)(Math.random() * cartas.size());
		Carta devolver=cartas.get(index);
		cartas.remove(index);
		return devolver;
	}
	
}
