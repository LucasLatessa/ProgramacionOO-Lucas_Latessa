package modelo;

import java.io.Serializable;

public class Carta implements Serializable{
	private int valor;
	private Palo palo;
	public Carta(int valor,Palo palo) {
		this.valor=valor;
		this.palo=palo;
	}
	public int getValor() {
		return valor;
	}
	/**
	 * @param c1,c2  Cartas
	 * @return Retorna true si la carta esta entre c1 y c2(si son de igual valor retorna false)
	 */
	public boolean estaEntre(Carta c1,Carta c2) {
		return (c1.getValor()>this.getValor()&&this.getValor()>c2.getValor())||
				(c1.getValor()<this.getValor()&&this.getValor()<c2.getValor());
	}
	public Palo getPalo() {
		return palo;
	}
	public String toString() {
		return valor+" DE "+palo;
	}

}
