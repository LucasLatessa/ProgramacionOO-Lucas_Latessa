package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public interface IJugador extends Serializable{
	public int getPuntos();
	public String getNombre();
	public  ArrayList<Carta>  getCartas();
	public Carta getCartaTirada() ;
}
