package ar.edu.unlu.poo.utils.observer;

public interface Observable {
	public void notificar(Object evento);
	
	public void agregadorObservador(Observador observador);
}
