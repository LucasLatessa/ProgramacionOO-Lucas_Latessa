package Modelo;

import java.util.ArrayList;

public class Mazo {
	private ArrayList<Carta>cartas;
	
	public Mazo() {
		this.cartas=new ArrayList<Carta>();
	}
	public void cargarCartas() {
		Carta carta = null;
		for(Color color: Color.values()) {
			if (color!=Color.MULTICOLOR){//para todos los colores menos multicolor
				for(int i = 1;i<=10;i++){
					if (i!=2) {
					for (int x=1;x<=2;x++) {
						carta=new Carta(String.valueOf(i),color);
						cartas.add(carta);//agregar dos de esa carta
						}
					if(i>=5) {
						carta=new Carta(String.valueOf(i),color);
						cartas.add(carta);//si el numero es menor a 6 agregar una mas de esa carta
					}
				}}
			}
		}
		for (int x=1;x<=12;x++) {//agregar 12 2 multicolor
			carta=new Carta("2",Color.MULTICOLOR);
			cartas.add(carta);
		}
	}
	
	public void mezclar() {
        ArrayList<Carta> mezclada = new ArrayList<>();
        while (this.cartas.size() > 0) {
            int index = (int) (Math.random() * this.cartas.size());
            Carta removedCard = this.cartas.remove(index);
            mezclada.add(removedCard);
        }
	}
	public Carta sacarCarta() {
		return cartas.remove(cartas.size()-1); //saca d atras para delante
	}
	public void agregarCarta(Carta carta) {
		 this.cartas.add(carta);
	}
}

