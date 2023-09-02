package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import controlador.Controlador;
import modelo.IJugador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaSimilConsola extends JFrame implements IVista{
	private JTextField entrada;
	private JButton btnOpcionInicio;
	//private static Serializador serializador=new Serializador("src/datos.dat");
	private Controlador controlador;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private String opcion;
	private JButton btnAddJugador;
	private JButton btnOpcionEnJuego;
	public VistaSimilConsola() {
		setVisible(true);
		setTitle("Intermedio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 390);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		textArea = new JTextArea();
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		textArea.setAutoscrolls(true);
		textArea.setEditable(false);
		scrollPane.setAutoscrolls(true);
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		entrada = new JTextField();
		panel_1.add(entrada);
		entrada.setColumns(10);
		
		btnOpcionInicio = new JButton("Leer opcion");
		btnOpcionInicio.setHorizontalAlignment(SwingConstants.LEADING);
		panel_1.add(btnOpcionInicio);
		
		btnAddJugador = new JButton("Agregar jugador");
		panel_1.add(btnAddJugador);
		SwingUtilities.getRootPane(btnOpcionInicio).setDefaultButton(btnOpcionInicio);
		
		btnOpcionEnJuego = new JButton("Leer opcion");
		btnOpcionEnJuego.setHorizontalAlignment(SwingConstants.LEADING);
		panel_1.add(btnOpcionEnJuego);
		btnOpcionInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcion = entrada.getText().toUpperCase();
				entrada.setText(null);
				if(!opcion.equals("A")&&!opcion.equals("S")&&!opcion.equals("V")&&!opcion.equals("E")) {
					textArea.append("\nOpcion invalida \nIngrese su opcion");
				}
				switch(opcion) {
				case "A":
					textArea.append("\nIngrese nombre de jugador");
					btnOpcionInicio.setVisible(false);
					btnAddJugador.setVisible(true);
					SwingUtilities.getRootPane(btnAddJugador).setDefaultButton(btnAddJugador);
					break;
				case "E":
					try {
						controlador.repartir();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "V":
					mostrarJugadores();
					try {
						if(controlador.puedeEmpezarJuego()) {
							preguntaEmpezar();
						}else {
						iniciar();}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "S":
					System.exit(0);
				}
			}
		});
		btnAddJugador.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String nameJ1 = entrada.getText();
			entrada.setText(null);
			try {
				if(controlador.noNombreRepetido(nameJ1)) {
					textArea.setText(null);
					controlador.agregarJugador(nameJ1);
					}
					else {
						textArea.append("\nEl nombre de usuario ya esta usado, ingrese otro");
					}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}});
		btnOpcionEnJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 opcion = entrada.getText().toUpperCase();
				 textArea.append("\n"+entrada.getText());
				 if(!opcion.equals("D")&&!opcion.equals("P")) {
						textArea.append("\nOpcion invalida \nIngrese opcion nuevamente");
					}
				 entrada.setText(null);
				switch(opcion) {
				case"D":
					try {
						controlador.quiero();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case"P":
					try {
						controlador.noQuiero();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
	}});
		}
	public void iniciar() {
		textArea.append("\n########################");
		textArea.append("\n###### INTERMEDIO ######");
		textArea.append("\n########################");
		textArea.append("\nA- Agregar jugador \nV- Ver jugadores\nS- Salir ");
		textArea.append("\nIngrese su opcion");
		btnOpcionInicio.setVisible(true);
		btnAddJugador.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
		SwingUtilities.getRootPane(btnOpcionInicio).setDefaultButton(btnOpcionInicio);
	}

	public void preguntaEmpezar() {
		textArea.append("\n########################");
		textArea.append("\n###### INTERMEDIO ######");
		textArea.append("\n########################");
		textArea.append("\nSelecciona una opcion:");
		textArea.append("\nV - Ver jugadores");
		textArea.append("\nE - Empezar");
		textArea.append("\nS - Salir");
		btnOpcionInicio.setVisible(true);
		btnAddJugador.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
		SwingUtilities.getRootPane(btnOpcionInicio).setDefaultButton(btnOpcionInicio);
	}
	public void mostrarJugadores() {
		ArrayList<IJugador> jugadores = null;
		try {
			jugadores = controlador.getJugadores();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (jugadores.size()!=0) {
			textArea.append("\nLos jugadores actuales son: ");
			for (IJugador jugador:jugadores) {
				textArea.append("\n"+jugador.getNombre());
			}
		}else {
			textArea.append("\nNo hay jugadores agregados");
		}
		
	}

	public void jugar() {
		mostrarDinero();
		mostrarCartasEnMano();
		textArea.append("\nOpciones");
		textArea.append("\nD-Dame la carta intermedia \nP-Paso");
		textArea.append("\nIngrese opcion");
		btnOpcionInicio.setVisible(false);
		btnAddJugador.setVisible(false);
		SwingUtilities.getRootPane(btnOpcionEnJuego).setDefaultButton(btnOpcionEnJuego);
		btnOpcionEnJuego.setVisible(true);}
	
	
	/**
	 * muestra las cartas del jugador que le toca jugar
	 */
	public void mostrarCartasEnMano() {
		String ss="Cartas en mano: ";
		try {
			textArea.append("\nTURNO DE "+ controlador.turnoActual().getNombre().toUpperCase());
			for (String sCarta : controlador.listarCartas()) {
				ss+= sCarta+", ";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textArea.append("\n"+ss);
	}@Override
	/**
	 * muestra la carta intermedia en caso de que haya
	 */
	public void mostrarCartaIntermedia() {
		try {
			if (controlador.getCartaIntermedio()!=null){
				textArea.append("\nTu carta intermedia es: "+controlador.getCartaIntermedio().toString()); }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void manoTerminada() {
		textArea.append("\nLa mano termino");
		mostrarDinero();
	}
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	@Override
	public void mostrarDinero() {
		String ss="";
		ArrayList<IJugador> jugadores = null;
		try {
			jugadores = controlador.darJugadores();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (IJugador jugador : jugadores) {
			ss+="\nPuntos " + jugador.getNombre()+": "+ jugador.getDinero()+"\n";
		}
		textArea.append(ss);
	}
	@Override
	public void esperandoJugadores() {
		textArea.append("\nEsperando otros jugadores...");
		btnOpcionInicio.setVisible(false);
		btnAddJugador.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
	}
	@Override
	public void esperarJugandoOponente() {
		textArea.append("\nEsperando que juegue oponente...");
		mostrarCartasEnMano();
		btnOpcionInicio.setVisible(false);
		btnAddJugador.setVisible(false);
		btnOpcionEnJuego.setVisible(false);
	}
	@Override
	public void mostrarCartaTirada() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actualizarDinero(int dineroEsteJug) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void juegoTerminado() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actualizarPozo(int pozo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void limpiarCartas() {
		// TODO Auto-generated method stub
		
	}
}