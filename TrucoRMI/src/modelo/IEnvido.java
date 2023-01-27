package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public interface IEnvido extends Serializable{
	public ArrayList<EstadoEnvido> getEnvidosQueridos();
	public boolean hayQueridos() ;
	public EstadoEnvido getEnvidoPreguntado();
	public ArrayList<String> puedeCantar();
}
