package modelo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

public interface IJuego extends IObservableRemoto{

	void agregarJugador(String id)throws RemoteException;

	void jugar()throws RemoteException;

	void nuevaMano()throws RemoteException;

	IJugador getITurno()throws RemoteException;

	boolean puedeEmpezarJuego()throws RemoteException;

	ArrayList<IJugador> listarJugadores()throws RemoteException;

	void darTercerCarta()throws RemoteException;

	Carta getCartaIntermedio()throws RemoteException;

	boolean verificarNombre(String nombre) throws RemoteException;

	void proximoTurno() throws RemoteException;

}