package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public interface IJugador extends Serializable{
	public int getDinero();
	public String getNombre();
	public  ArrayList<Carta>  getCartas();
}
