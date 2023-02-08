package modelo;

import java.util.ArrayList;


public class Ronda {
			private ArrayList<Jugador> jugadores;
			private ArrayList<Carta> cartas;
			private boolean terminada=false;
		public boolean isTerminada() {
				return terminada;
			}
		public Ronda(){
			jugadores= new ArrayList<Jugador>();
			cartas= new ArrayList<Carta>();
		}
	    public void jugar(Jugador j, Carta c){
	        cartas.add(c);
	        jugadores.add(j);
	        if (jugadores.size()==2){
	        	terminada=true;
	        }
	    }
	    /**
	     * @return jugador ganador de la ronda, en caso de parda retorna nulo
	     */
	    public Jugador getGanador() {
	    	Carta cartaMasAlta=cartas.get(0);
	        int index=0;
	        for (int i=1;i< cartas.size();i++) {
	        	Carta carta=cartas.get(i);
	        	cartaMasAlta = carta.mayor(cartaMasAlta);
	        	index=(cartaMasAlta==carta)?i:index;
	        }
	        return (cartaMasAlta!=null)?jugadores.get(index):null;
	    }
	    public ArrayList<Carta> getCartas() {
	    	return cartas;
	    }
	    /**
	     * @return jugador que ya tiro en caso que uno haya tirado y el otro no, si ambos tiraron devuelve null
	     */
	    public Jugador jugadorYaTiro(){
	    	Jugador jugador=null;
	    	if (jugadores.size()==1) {
	    		jugador=jugadores.get(0);
	    		}
	    	return jugador;
	    	}
	    public boolean unJugadorYaTiro(){
	    	return jugadores.size()==1;
	    	}
}

