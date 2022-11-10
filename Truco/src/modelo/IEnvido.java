package modelo;

import java.util.ArrayList;

public interface IEnvido {
	public ArrayList<EstadoEnvido> getEnvidosQueridos();
	public boolean hayQueridos() ;
	public EstadoEnvido getEnvidoPreguntado();
}
