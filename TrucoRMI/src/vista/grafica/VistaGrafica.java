package vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import controlador.Controlador;
import modelo.EstadoEnvido;
import modelo.EstadoTruco;
import modelo.IEnvido;
import modelo.IJuego;
import modelo.IJugador;
import vista.IVista;

public class VistaGrafica implements IVista {
	private VentanaInicioSesion vInicioSesion;
	private VentanaPrincipal vPrincipal;
	private Controlador controlador;
	private String nameJugador;//PARA PRUEBAS EL ATRIBUTO,SACAR PARA INSERTAR NOMBRES DE JUGADORES

	public VistaGrafica(String nameJugador) {//String nameJugadorPARA PRUEBAS EL PARAMETRO,SACAR PARA INSERTAR NOMBRES DE JUGADORES
		super();
		this.vInicioSesion = new VentanaInicioSesion();
		this.vPrincipal = new VentanaPrincipal();
		this.nameJugador=nameJugador;//PARA PRUEBAS

		mostrarInicioSesion();
		
		this.vInicioSesion.onClickIniciar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//PARA INSERTAR NOMBRES DE JUGADORES DESCOMENTAR ABAJO
//				try {
//					if(controlador.noNombreRepetido(vInicioSesion.getGetNombreUsuario())) {
//					controlador.agregarJugador(vInicioSesion.getGetNombreUsuario());}
//					else {
//						vInicioSesion.nombreRepetido();
//					}
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		this.vPrincipal.onClickTirarCarta(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.tirar(vPrincipal.getCartaSeleccionada());
				vPrincipal.ocultarNotificaciones();
				
			}
		});

		this.vPrincipal.onClickEnvido(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.cantar(EstadoEnvido.ENVIDO);
				vPrincipal.ocultarBotonesEnvido();
			}
		});
		this.vPrincipal.onClickRealEnvido(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.cantar(EstadoEnvido.REALENVIDO);
				vPrincipal.ocultarBotonesEnvido();
			}
		});
		
		this.vPrincipal.onClickFaltaEnvido(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.cantar(EstadoEnvido.FALTAENVIDO);
				vPrincipal.ocultarBotonesEnvido();
			}
		});
		this.vPrincipal.onClickMazo(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.alMazo();
				vPrincipal.ocultarNotificaciones();
			}
		});
		this.vPrincipal.onClickTruco(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.cantar(EstadoTruco.TRUCO);
				vPrincipal.ocultarNotificaciones();
			}
		});
		this.vPrincipal.onClickReTruco(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.cantar(EstadoTruco.RETRUCO);
				vPrincipal.ocultarNotificaciones();
			}
		});
		this.vPrincipal.onClickValeCuatro(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.cantar(EstadoTruco.VALECUATRO);
				vPrincipal.ocultarNotificaciones();
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
		controlador.agregarJugador(nameJugador);//PARA PRUEBAS RAPIDAS
	}

	@Override
	public void mostrarPuntajes() {
		ArrayList<IJugador> jugadores=controlador.darJugadores();
		int puntos1=jugadores.get(0).getPuntos();
		int puntos2=jugadores.get(1).getPuntos();
		this.vPrincipal.actualizarPuntos(puntos1,puntos2);
	}

	@Override
	public void juegoTerminado() {
		mostrarPuntajes();
		this.vPrincipal.juegoTerminado(controlador.termino().getNombre());
	}
	@Override
	public void avisarParda() {
		this.vPrincipal.pardaRonda();
	}

	@Override
	public void rondaTerminada(boolean ganador) {
		if (ganador) {
			this.vPrincipal.ganoRonda();
		}else {
			this.vPrincipal.perdioRonda();
		}
		
	}

	@Override
	public void manoTerminada() {
		mostrarPuntajes();
		vPrincipal.laManoTermino();
		vPrincipal.limpiarVista();
		}

	@Override
	public void mostrarEnvido(String nombre) {
		Integer p1= controlador.obtenerTantosEnvido().get(0);
		Integer p2=controlador.obtenerTantosEnvido().get(1);
		this.vPrincipal.mostrarGanadorEnvido(nombre,p1,p2);
	}

	@Override
	public void quererNoQuererEnvido(String nombreTurno, IEnvido envido) {
		EstadoEnvido ultCantado=envido.getEnvidoPreguntado();
		this.vPrincipal.notificarCanto(ultCantado.toString());
		this.vPrincipal.mostrarBotonesEnvido(envido.puedeCantar());
		mostrarCartasEnMano();
		this.vPrincipal.onClickQuiero(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.quiero();
				vPrincipal.ocultarBotonesEnvido();
			}
		});
		this.vPrincipal.onClickNoQuiero(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.noQuiero();
				vPrincipal.ocultarBotonesEnvido();
				vPrincipal.ocultarNotificaciones();
			}
		});
	}

	@Override
	public void quererNoQuererTruco(String nombreTurno, EstadoTruco truco) {
		this.vPrincipal.notificarCanto(truco.toString());
		boolean puedeCantarEnvido=controlador.puedeCantarEnvidos();
		mostrarCartasEnMano();
		this.vPrincipal.mostrarBotonesTruco(puedeCantarEnvido);
		this.vPrincipal.onClickQuiero(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.quiero(truco);
				vPrincipal.ocultarBotonesTruco();
			}
		});
		this.vPrincipal.onClickNoQuiero(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlador.alMazo();
				vPrincipal.ocultarBotonesTruco();
			}
		});
		
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
			String str1=controlador.darJugadores().get(0).getNombre();
			String str2=controlador.darJugadores().get(1).getNombre();
			this.vPrincipal.setJugadores(str1,str2);
			this.vPrincipal.botonesComienzo();
		}
		mostrarPuntajes();
		mostrarCartasEnMano();
		if (controlador.puedeCantarEnvidos()) {
			this.vPrincipal.mostrarBotonesEnvido();
		}
		String canto=controlador.queTrucoPuedeCantar();
		this.vPrincipal.turnoActual(canto,controlador.nombreTurno());
		mostrarCartaTirada();
	}
	@Override
	public void esperarJugandoOponente() {
		this.vInicioSesion.setVisible(false);
		this.vPrincipal.setVisible(true);
		if(!vPrincipal.jugadoresCargados()) {//es porque es la primera mano
			String str1=controlador.darJugadores().get(0).getNombre();
			String str2=controlador.darJugadores().get(1).getNombre();
			this.vPrincipal.setJugadores(str1,str2);
			this.vPrincipal.botonesComienzo();
		}
		;
		this.vPrincipal.esperarJugandoOponente(this.controlador.nombreTurno());
		mostrarCartaTirada();
		this.mostrarPuntajes();
	}
	@Override
	public void mostrarCartasEnMano() {
		this.vPrincipal.mostrarCartas(controlador.listarCartas());
	}
	@Override
	public void mostrarCartaTirada() {
		String cartaTirada=controlador.getCartaTirada();
		if (cartaTirada!=null){
			this.vPrincipal.mostrarCartaTirada(cartaTirada);
			}
		
	}
}
