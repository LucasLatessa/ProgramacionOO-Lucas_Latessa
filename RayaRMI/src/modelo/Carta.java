package modelo;

import java.io.Serializable;

public class Carta implements Serializable{
	private static final long serialVersionUID = 1L;
	private int valor;
	private Palo palo;
	public Carta(int valor,Palo palo) {
		this.valor=valor;
		this.palo=palo;
	}
	public int getValor() {
		return valor;
	}
	public Palo getPalo() {
		return palo;
	}
	public String toString() {
		return valor+" DE "+palo;
	}

}
