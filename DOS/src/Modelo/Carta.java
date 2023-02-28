package Modelo;

public class Carta {
	private String numero;
	private Color color; 
	
	public Carta(String numero, Color color){
		this.numero=numero;
		this.color=color;
	}
	
	public String getNumero() {
		return numero;
	}
	public Color getColor() {
		return color;
	}
	
	
	//Comparacion de carta con la que esta en el mazo(this) y la que pone el jugador
	public CompararCarta comparar(Carta cartaJugador) {
		if (cartaJugador.numero==this.numero) {
			if (cartaJugador.color==this.color) {
				return CompararCarta.IGUAL_NUMERO_COLOR;
			}
			return CompararCarta.IGUAL_NUMERO;
		}
		return CompararCarta.DISTINTA;
	}
	public CompararCarta comparar(Carta cartaJugador1,Carta cartaJugador2) {
		if (cartaJugador1.numero+cartaJugador2.numero==this.numero) {
			if ((cartaJugador1.color==this.color)&&(cartaJugador2.color==this.color)) {
				return CompararCarta.IGUAL_NUMERO_COLOR;
			}
			return CompararCarta.IGUAL_NUMERO;
		}
		return CompararCarta.DISTINTA;
	}
	

			
}
