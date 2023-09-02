package modelo;
import java.io.Serializable;
import java.util.ArrayList;

public interface IJugador extends Serializable{

	ArrayList<Carta> getCartas();

	String getNombre();
	int getPuntosParciales();
	int getPuntos();
}
