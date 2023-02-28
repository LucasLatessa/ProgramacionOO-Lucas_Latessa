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
	//private String nameJugador;//PARA PRUEBAS EL ATRIBUTO,SACAR PARA INSERTAR NOMBRES DE JUGADORES

	public VistaGrafica() {//String nameJugadorPARA PRUEBAS EL PARAMETRO,SACAR PARA INSERTAR NOMBRES DE JUGADORES
		super();
		this.vInicioSesion = new VentanaInicioSesion();
		this.vPrincipal = new VentanaPrincipal();
		//this.vRanking = new VentanaRanking();
		//this.nameJugador=nameJugador;//PARA PRUEBAS

		mostrarInicioSesion();
		
		this.vInicioSesion.onClickIniciar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//PARA INSERTAR NOMBRES DE JUGADORES DESCOMENTAR ABAJO
				try {
					if(controlador.noNombreRepetido(vInicioSesion.getGetNombreUsuario())) {
					controlador.agregarJugador(vInicioSesion.getGetNombreUsuario());}
					else {
						vInicioSesion.nombreRepetido();
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
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
	}


	@Override
	public void juegoTerminado() {
		mostrarPuntajes();
		String ganador=controlador.termino().getNombre();
		this.vPrincipal.juegoTerminado(ganador);}


	@Override
	public void manoTerminada() {
		mostrarPuntajes();
		vPrincipal.laManoTermino();
		vPrincipal.limpiarVista();
		}


	@Override
	public void esperandoJugadores() {
		this.vInicioSesion.esperandoOtrosJugadores();
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
			ArrayList<String> jugadoresSTR = null;
			for(IJugador jug:jugadores) {
				jugadoresSTR.add(jug.getNombre());
			}
			this.vPrincipal.setJugadores(jugadoresSTR);
			this.vPrincipal.botonesComienzo();
		}
		mostrarPuntajes();
		mostrarCartasEnMano();
		this.vPrincipal.turnoActual(controlador.getJugador());
		mostrarCartaTirada();
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
			ArrayList<String> jugadoresSTR = null;
			for(IJugador jug:jugadores) {
				jugadoresSTR.add(jug.getNombre());
			}
			this.vPrincipal.setJugadores(jugadoresSTR);
			this.vPrincipal.botonesComienzo();
		}
		try {
			this.vPrincipal.esperarJugandoOponente(this.controlador.turnoActual().getNombre());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mostrarCartaTirada();
		this.mostrarPuntajes();
	}
	@Override
	public void mostrarCartasEnMano() {
		try {
			this.vPrincipal.mostrarCartas(controlador.listarCartas());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void mostrarCartaIntermedia() {
		String cartaIntermedia=controlador.getCartaIntermedio().toString());
		if (cartaIntermedia!=null){
			try {
				this.vPrincipal.mostrarCartaIntermedia(cartaIntermedia);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}
	@Override
	public void preguntaEmpezar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarCartaIntermediaContras() {
		// TODO Auto-generated method stub
		
	}
	
}
