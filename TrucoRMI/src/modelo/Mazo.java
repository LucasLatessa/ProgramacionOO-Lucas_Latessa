package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo implements Serializable{
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
		Collections.shuffle(cartas);
	}
	public Carta dar() {
		Carta devolver=cartas.get(0);
		cartas.remove(0);
		return devolver;
	}
	
}
