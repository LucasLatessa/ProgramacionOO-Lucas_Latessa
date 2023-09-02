package vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import controlador.Controlador;
import modelo.IJugador;
import vista.IVista;

public class VistaGrafica implements IVista {
	//private static Serializador serializador=new Serializador("src/datos.dat");
	private VentanaInicioSesion vInicioSesion;
	private VentanaPrincipal vPrincipal;
	//private VentanaRanking vRanking;
	private Controlador controlador;
	public VistaGrafica() {//String nameJugadorPARA PRUEBAS EL PARAMETRO,SACAR PARA INSERTAR NOMBRES DE JUGADORES
		super();
		this.vInicioSesion = new VentanaInicioSesion();
		this.vPrincipal = new VentanaPrincipal();
		//this.vRanking = new VentanaRanking();
		//this.nameJugador=nameJugador;//PARA PRUEBAS

		mostrarInicioSesion();
		
		this.vInicioSesion.onClickAddJug(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(controlador.verificarNombre(vInicioSesion.getTextUsuario())) {
						vInicioSesion.getTextUsuario();
						controlador.agregarJugador(vInicioSesion.getTextUsuario());
						vInicioSesion.setVisible(false);
						vPrincipal.setVisible(true);
					}
					else {
						vInicioSesion.nombreRepetido();
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}});
		this.vPrincipal.onClickPedirCarta(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.ocultarNotificaciones();
				try {
					controlador.quiero();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		this.vPrincipal.onClickIniciarJuego(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					try {
						vPrincipal.ocultarNotificaciones();
						controlador.empezarJuego();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}});
		this.vPrincipal.onClickPaso(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.ocultarNotificaciones();
				try {
					controlador.noQuiero();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	private void mostrarInicioSesion() {
		this.vInicioSesion.setVisible(true);
		this.vPrincipal.setVisible(false);
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}

	@Override
	public void iniciar() {
		//controlador.agregarJugador(nameJugador);//PARA PRUEBAS RAPIDAS
		try {
			vPrincipal.mostrarJugadores(controlador.darJugadores());
			if(controlador.puedeEmpezarJuego()) {
				vPrincipal.yaPuedeEmpezar();}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Override
	public void manoTerminada() {
		mostrarPuntajes();
		mostrarCartasTodos();
		}
	public void mostrarRepartir() {
		manoTerminada();
		vPrincipal.botonRepartir();
	}
	public void reparteOponente(){
		manoTerminada();
		vPrincipal.laManoTermino();
	}
	@Override
	public void jugar() {
		this.vInicioSesion.setVisible(false);
		this.vPrincipal.setVisible(true);
		if(!vPrincipal.jugadoresCargados()) {//es porque es la primera mano
			ArrayList<IJugador> jugadores = null;
			try {
				jugadores = controlador.darJugadores();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<String> jugadoresSTR = new ArrayList<String>();
			for(IJugador jug:jugadores) {
				jugadoresSTR.add(jug.getNombre());
			}
			this.vPrincipal.setJugadores(jugadoresSTR);
		}
		mostrarPuntajes();
		mostrarCartasTodos();
		this.vPrincipal.turnoActual(controlador.getJugador());
	}
	@Override
	public void esperarJugandoOponente() {
		this.vInicioSesion.setVisible(false);
		this.vPrincipal.setVisible(true);
		if(!vPrincipal.jugadoresCargados()) {//es porque es la primera mano
			ArrayList<IJugador> jugadores = null;
			try {
				jugadores = controlador.darJugadores();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<String> jugadoresSTR = new ArrayList<String>();
			for(IJugador jug:jugadores) {
				jugadoresSTR.add(jug.getNombre());
			}
			this.vPrincipal.setJugadores(jugadoresSTR);
			this.vPrincipal.ocultarNotificaciones();;
		}
		try {
			this.vPrincipal.esperarJugandoOponente(this.controlador.turnoActual().getNombre());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mostrarPuntajes();
		mostrarCartasTodos();
	}
	@Override
	public void mostrarCartasTodos() {
		try {
			ArrayList<IJugador> jugadores=controlador.darJugadores();
			this.vPrincipal.mostrarCartas(jugadores,controlador.turnoActual().getNombre());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void esperandoJugadores() {
		try {
			mostrarPuntajes();
			this.vPrincipal.mostrarJugadores(controlador.darJugadores());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Override
	public void mostrarPuntajes() {
		try {
			vPrincipal.actualizarPuntos(controlador.darJugadores());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void juegoTerminado() {
		try {
			vPrincipal.juegoTerminado(controlador.termino().getNombre());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void noEntranMasJugadores() {
		try {
			vPrincipal.mostrarJugadores(controlador.darJugadores());
			vPrincipal.yaPuedeEmpezar();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Override
	public void mostrarRaya() {
		vPrincipal.notifRaya();
	}
}
