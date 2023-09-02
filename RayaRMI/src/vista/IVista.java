package vista;

import controlador.Controlador;
public interface IVista {
	
	public void setControlador(Controlador controlador);
	
	public void iniciar();
	public void jugar();
	public void mostrarPuntajes();
	public void juegoTerminado();
	public void manoTerminada();
	public void esperandoJugadores();
	public void mostrarCartasTodos();
	public void esperarJugandoOponente();
	public void mostrarRepartir();
	public void noEntranMasJugadores();
	public void mostrarRaya();
	public void reparteOponente();
}