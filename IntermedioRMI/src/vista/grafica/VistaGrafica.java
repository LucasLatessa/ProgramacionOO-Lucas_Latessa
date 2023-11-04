package vista.grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Controlador;
import modelo.IJugador;
import serializacion.AdministradorDeDineros;
import vista.IVista;

public class VistaGrafica implements IVista {
	//private static Serializador serializador=new Serializador("src/datos.dat");
	private VentanaInicioSesion vInicioSesion;
	private VentanaPrincipal vPrincipal;
	//private VentanaRanking vRanking;
	private Controlador controlador;
	private String nameJugador;
	private VentanaDeudas vRanking;
	private static final int pozoInicial = 100;
	private AdministradorDeDineros lista = null;
	public VistaGrafica() {//String nameJugadorPARA PRUEBAS EL PARAMETRO,SACAR PARA INSERTAR NOMBRES DE JUGADORES
		super();
		this.vInicioSesion = new VentanaInicioSesion();
		this.vPrincipal = new VentanaPrincipal();
		this.vRanking = new VentanaDeudas();
		//this.nameJugador=nameJugador;//PARA PRUEBAS
		
		mostrarInicioSesion();
		this.vInicioSesion.onClickSiguiente(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(controlador.noNombreRepetido(vInicioSesion.getTextUsuario())) {
						nameJugador=vInicioSesion.getTextUsuario();
						controlador.agregarJugador(vInicioSesion.getTextUsuario());
						vInicioSesion.ingresarDin();
					}
					else {
						vInicioSesion.nombreRepetido();
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		this.vInicioSesion.onClickIngresarDin(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					//si entre lo que acaba de ingresar y lo que ya tenia es mayor a pozoInicial
					if((controlador.dineroEsteJug() + vInicioSesion.getDinero())>pozoInicial) {
						controlador.ingresarDineroYDec(nameJugador,vInicioSesion.getDinero());
						vInicioSesion.setVisible(false);
						vPrincipal.setVisible(true);}
					else {
						vInicioSesion.dineroInvalido();
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}});
		this.vPrincipal.onClickCargar(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.ingresarDineroSinDec(nameJugador, vPrincipal.getDinero());
					vPrincipal.ocultarCarga(); 
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
		vPrincipal.addWindowListener((WindowListener) new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }
        });

		vPrincipal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }
        });
		this.vInicioSesion.onClickVerRanking(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vRanking.setVisible(true);
				vRanking.mostrarTabla(lista.getNombresGanadores(),lista.getDineroAFavor());}
		});
	}
	public void handleWindowClosing() {
        try {
            controlador.meRetiro();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
		
		//bloque para decidir si muestro btnVerRanking(depende de si el archivo serializacion existe)
		try {
			lista = controlador.traerHistorial();
		} catch (RemoteException e) {
			e.printStackTrace();
		} 
		if (lista==null) {
			vInicioSesion.btnVerRanking.setVisible(false);
		}
		//------------------------------------------------------------------------------------------
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
		if(!vPrincipal.jugadoresCargados()) {//porque es la primera mano
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
//	@Override
//	public void limpiarCartas() {
//		vPrincipal.limpiarCartas();
//		
//	}
	@Override
	public void mostrarRepartir() {
		vPrincipal.mostrarRepartir();
	}
	@Override
	public void pedirIngresoPozo(int dineroDispo) {
		vInicioSesion.setVisible(true);
		vPrincipal.setVisible(false);
		vInicioSesion.pedirIngresoPozo(dineroDispo,controlador.getJugador());
		
	}
	@Override
	public void limpiarCartas() {
		vPrincipal.limpiarCartas();
		vPrincipal.ocultarNotificaciones();
	}
}
