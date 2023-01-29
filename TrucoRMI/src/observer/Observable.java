package observer;

public interface Observable {
	public void notificar(Object evento);
	
	public void agregarObservador(Observador observador);
}
