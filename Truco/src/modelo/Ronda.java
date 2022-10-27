package modelo;

import java.util.ArrayList;

public class Ronda
	{
	    private Jugador ganador;
		private Envido envido;
		private ArrayList<Jugador> jugadores;
		private ArrayList<Carta> cartas;
		public Ronda(Jugador j1,Jugador j2){
			jugadores= new ArrayList<Jugador>();
			cartas= new ArrayList<Carta>();
		}
		public void envidos(EstadoEnvido estado) {
			envido.agregar(estado);
		}
	    public void jugar(Jugador j, Carta c)
	    {
	        cartas.add(c);
	        jugadores.add(j);
	    }
	    
	    /**
	     * @return retorna el jugador ganador de la ronda, en caso de parda retorna nulo
	     */
	    public Jugador getGanador() {
	        ArrayList<Carta> cartasJugadas = cartas;
	        int index=-1;
	        Carta cartaMasAlta=new Carta(4,Palo.COPA);
	        for (int i=0;i< cartasJugadas.size();i++) {
	        	Carta carta=cartasJugadas.get(i);
	            if (carta.mayor(cartaMasAlta)==carta){
	                cartaMasAlta = carta;
	                index=i;
	            }else if(carta.mayor(cartaMasAlta)==null) {
	            	index=-1;}
	            }
	        if (index!=-1) {
	        	return jugadores.get(index);}
	        else {
	            return null;}
	    }
	}

