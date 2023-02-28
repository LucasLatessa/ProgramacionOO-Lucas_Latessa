package Observer;


public interface Iobservable {
	public void notificar(Object evento);
	
	public void agregadorObservador(Iobservador observador);
}
