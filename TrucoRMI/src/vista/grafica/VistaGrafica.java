package vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import controlador.Controlador;
import modelo.EstadoTruco;
import modelo.IEnvido;
import modelo.IJuego;
import modelo.IJugador;
import vista.IVista;

public class VistaGrafica implements IVista {
	private VentanaInicioSesion vInicioSesion;
	private VentanaPrincipal vPrincipal;
	private Controlador controlador;

	public VistaGrafica() {
		super();
		this.vInicioSesion = new VentanaInicioSesion();
		this.vPrincipal = new VentanaPrincipal();
		
		this.vPrincipal.onClickEnviar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		this.vPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			}			
		});
		this.vInicioSesion.onClickIniciar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				mostrarChat();
			}
		});
	}
	@Override
	public void iniciar(int puerto) {
		this.mostrarInicioSesion();
		
	}
	
	private void mostrarInicioSesion() {
		this.vInicioSesion.setVisible(true);
		this.vPrincipal.setVisible(false);
	}
	
	private void mostrarChat() {
		this.vInicioSesion.setVisible(false);
		this.vPrincipal.setVisible(true);
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		this.controlador.setVista(this);
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarPuntajes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void juegoTerminado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avisarParda() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rondaTerminada(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void manoTerminada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarEnvido(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quererNoQuererEnvido(String nombreTurno, IEnvido evento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quererNoQuererTruco(String nombreTurno, EstadoTruco evento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void esperandoJugadores() {
		// TODO Auto-generated method stub
		
	}
}
