package modelo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

public interface IJuego extends IObservableRemoto{

	void agregarJugador(String jugador)throws RemoteException;

	void nuevaRonda()throws RemoteException;

	void siguienteTurno() throws RemoteException;

	IJugador getITurno()throws RemoteException;
	void pedirCarta()throws RemoteException;

	void noQuieroCarta()throws RemoteException;
	ArrayList<IJugador> listarJugadores()throws RemoteException;

	boolean turnoPuedePedir()throws RemoteException;

	boolean puedeEmpezarJuego()throws RemoteException;

	boolean hayGanador()throws RemoteException;

	IJugador getGanador()throws RemoteException;

	boolean verificarNombre(String nameJ1)throws RemoteException;

}
