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
	private String nameJugador;

	public VistaGrafica() {//String nameJugadorPARA PRUEBAS EL PARAMETRO,SACAR PARA INSERTAR NOMBRES DE JUGADORES
		super();
		this.vInicioSesion = new VentanaInicioSesion();
		this.vPrincipal = new VentanaPrincipal();
		//this.vRanking = new VentanaRanking();
		//this.nameJugador=nameJugador;//PARA PRUEBAS

		mostrarInicioSesion();
		
		this.vInicioSesion.onClickSiguiente(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(controlador.noNombreRepetido(vInicioSesion.getTextUsuario())) {
						nameJugador=vInicioSesion.getTextUsuario();
						vInicioSesion.ingresarDin();
						controlador.agregarJugador(vInicioSesion.getTextUsuario());
					}
					else {
						vInicioSesion.nombreRepetido();
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		this.vInicioSesion.onClickIniciar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(vInicioSesion.getDinero()>100) {
						controlador.ingresarDinero(nameJugador,vInicioSesion.getDinero());
						vInicioSesion.setVisible(false);
						vPrincipal.setVisible(true);}
					else {
						vInicioSesion.dineroInvalido();
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
						controlador.repartir();
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
	}


	@Override
	public void manoTerminada() {
		mostrarDinero();
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
			this.vPrincipal.botonesComienzo();
		}
		mostrarDinero();
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
			ArrayList<String> jugadoresSTR = new ArrayList<String>();
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
		this.mostrarDinero();
		mostrarCartasEnMano();
	}
	@Override
	public void mostrarCartasEnMano() {
		try {
			this.vPrincipal.mostrarCartas(controlador.listarCartas(),controlador.turnoActual().getNombre());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void mostrarCartaIntermedia() {
		String cartaIntermedia = null;
		try {
			cartaIntermedia = controlador.getCartaIntermedio().toString();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (cartaIntermedia!=null){
			try {
				this.vPrincipal.mostrarCartaIntermedia(cartaIntermedia,controlador.turnoActual().getNombre());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		try {
			actualizarPozo(controlador.getPozo());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void preguntaEmpezar() {
		try {
			mostrarDinero();
			vPrincipal.mostrarJugadores(controlador.darJugadores());
			vPrincipal.yaPuedeEmpezar();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Override
	public void esperandoJugadores() {
		try {
			mostrarDinero();
			this.vPrincipal.mostrarJugadores(controlador.darJugadores());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Override
	public void mostrarDinero() {
		try {
			for (IJugador jug:controlador.darJugadores()) {
				if (jug.getNombre().equals(nameJugador)) {
					vPrincipal.actualizarDinero(jug.getDinero());
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void mostrarCartaTirada() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void juegoTerminado() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actualizarDinero(int dineroEsteJug) {
		vPrincipal.actualizarDinero(dineroEsteJug);
		try {
			vPrincipal.actualizarPozo(controlador.getPozo());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actualizarPozo(int pozo) {
		vPrincipal.actualizarPozo(pozo);
	}
	@Override
	public void limpiarCartas() {
		vPrincipal.limpiarCartas();
		
	}
}
