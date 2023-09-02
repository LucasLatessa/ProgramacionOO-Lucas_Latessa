package vista.grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import modelo.Carta;
import modelo.IJugador;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnPedirCarta;
	private JButton btnMeQuedo;
	private JLabel cartaTiradaJ3;
	private JLabel lblNotificaciones;
	private JLabel lblNotificacionFinal;
	private JPanel panelIzq;
	private JPanel panel_Separador;
	private JLabel cartaTiradaJ4;
	private JLabel cartaTiradaJ5;
	private JPanel panelApuestasArriba;
	private JLabel lblPozo;
	private JPanel panelCartaTiradaJ1;
	private JPanel panelCartaTiradaJ2;
	private JPanel panelCartaTiradaJ3;
	private JPanel panelCartaTiradaJ4;
	private JPanel panelCartaTiradaJ5;
	private JButton btnIniciarJuego;
	private JLabel lblPuntos_J1;
	private JPanel puntos_J1;
	private JPanel puntos_J2;
	private JLabel lblPuntos_J2;
	private JPanel puntos_J3;
	private JLabel lblPuntos_J3;
	private JPanel puntos_J4;
	private JLabel lblPuntos_J4;
	private JPanel puntos_J5;
	private JLabel lblPuntos_J5;
	private JLabel lblNameJ1;
	private JLabel lblNameJ2;
	private JLabel lblNameJ3;
	private JLabel lblNameJ4;
	private JLabel lblNameJ5;
	private JLabel cartasTiradas2;
	private JLabel cartaTiradaJ1;
	private JLabel cartaTiradaJ2;
	private JLabel puntosJ1;
	private JLabel puntosJ2;
	private JLabel puntosJ3;
	private JLabel puntosJ4;
	private JLabel puntosJ5;
	private JLabel jugador1;
	private JLabel jugador2;
	private JLabel jugador3;
	private JLabel jugador4;
	private JLabel jugador5;
	public VentanaPrincipal(){
		Image imagenMadera = null;
		Image imagenMarron = null;
		try {
			imagenMarron = ImageIO.read(new File("src/Imagenes/FondoMarron.jpg"));
			imagenMadera = ImageIO.read(new File("src/Imagenes/Madera.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setTitle("Raya");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 650, 550);
		contentPane = new JPanelConFondo(imagenMarron);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(3, 0));
		JPanel panelDer = new JPanelConFondo(imagenMarron);
		contentPane.add(panelDer, BorderLayout.EAST);
		panelDer.setLayout(new GridLayout(0, 1, 2, 0));
		
		JPanel panelApuestas = new JPanelConFondo(imagenMarron);
		panelDer.add(panelApuestas);
		panelApuestas.setLayout(new BorderLayout(2, 0));
    	
		JPanel panelApuestasAbajo = new JPanelConFondo(imagenMarron);
		panelApuestas.add(panelApuestasAbajo, BorderLayout.CENTER);
		panelApuestasAbajo.setLayout(new GridLayout(0, 1, 0, 0));
		
		puntos_J1 = new JPanelConFondo(imagenMarron);
		panelApuestasAbajo.add(puntos_J1);
		puntos_J1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNameJ1 = new JLabel("");
		puntos_J1.add(lblNameJ1);
		
		lblPuntos_J1 = new JLabel("0");
		lblPuntos_J1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos_J1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntos_J1.add(lblPuntos_J1);
		
		puntos_J2 = new JPanelConFondo(imagenMarron);
		panelApuestasAbajo.add(puntos_J2);
		puntos_J2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNameJ2 = new JLabel("");
		puntos_J2.add(lblNameJ2);
		
		lblPuntos_J2 = new JLabel("0");
		lblPuntos_J2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos_J2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntos_J2.add(lblPuntos_J2);
		
		puntos_J3 = new JPanelConFondo(imagenMarron);
		panelApuestasAbajo.add(puntos_J3);
		puntos_J3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNameJ3 = new JLabel("");
		puntos_J3.add(lblNameJ3);
		
		lblPuntos_J3 = new JLabel("0");
		lblPuntos_J3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos_J3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntos_J3.add(lblPuntos_J3);
		
		puntos_J4 = new JPanelConFondo(imagenMarron);
		panelApuestasAbajo.add(puntos_J4);
		puntos_J4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNameJ4 = new JLabel("");
		puntos_J4.add(lblNameJ4);
		
		lblPuntos_J4 = new JLabel("0");
		lblPuntos_J4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos_J4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntos_J4.add(lblPuntos_J4);
		
		puntos_J5 = new JPanelConFondo(imagenMarron);
		panelApuestasAbajo.add(puntos_J5);
		puntos_J5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNameJ5 = new JLabel("");
		puntos_J5.add(lblNameJ5);
		
		lblPuntos_J5 = new JLabel("0");
		lblPuntos_J5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos_J5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntos_J5.add(lblPuntos_J5);
		
		panelApuestasArriba = new JPanelConFondo(imagenMadera);
		panelApuestas.add(panelApuestasArriba, BorderLayout.NORTH);
		
		lblPozo = new JLabel("Puntos");
		lblPozo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPozo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPozo.setAlignmentY(2.0f);
		lblPozo.setAlignmentX(0.5f);
		panelApuestasArriba.add(lblPozo);
		
		JPanel panelBotones = new JPanelConFondo(imagenMarron);
		panelDer.add(panelBotones);
		panelBotones.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnIniciarJuego = new JButton("Iniciar juego");
		btnIniciarJuego.setBackground(SystemColor.activeCaption);
		panelBotones.add(btnIniciarJuego);
		this.btnIniciarJuego.setVisible(false);
		
		btnPedirCarta = new JButton("Pedir carta");
		btnPedirCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPedirCarta.setBackground(new Color(0, 153, 102));
//		btnPedirCarta.setIcon(imagenVerde);           
//		btnPedirCarta.setContentAreaFilled(false); // Hace que el área de contenido no se pinte por defecto
//		btnPedirCarta.setFocusPainted(false); // Elimina el contorno cuando el botón obtiene el foco
//		btnPedirCarta.setBorderPainted(false); // Elimina el borde pintado
		panelBotones.add(btnPedirCarta);
		btnPedirCarta.setVisible(false);
		
		btnMeQuedo = new JButton("Me quedo");
		btnMeQuedo.setBackground(new Color(255, 0, 0));
//		btnPaso.setIcon(imagenRoja);
//		btnPaso.setContentAreaFilled(false); // Hace que el área de contenido no se pinte por defecto
//		btnPaso.setFocusPainted(false); // Elimina el contorno cuando el botón obtiene el foco
//		btnPaso.setBorderPainted(false); // Elimina el borde pintado
		panelBotones.add(btnMeQuedo);
		btnMeQuedo.setVisible(false);
		
		
		JPanel panelCentro = new JPanelConFondo(imagenMadera);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelCartasTitle = new JPanelConFondo(imagenMadera);
		panelCentro.add(panelCartasTitle);
		panelCartasTitle.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel cartasTiradas1 = new JLabel("Ultima Carta");
		cartasTiradas1.setFont(new Font("Tahoma", Font.BOLD, 11));
		cartasTiradas1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartasTitle.add(cartasTiradas1);
		
		cartasTiradas2 = new JLabel("Puntos parciales");
		cartasTiradas2.setHorizontalAlignment(SwingConstants.CENTER);
		cartasTiradas2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelCartasTitle.add(cartasTiradas2);
		
		panelCartaTiradaJ1 = new JPanelConFondo(imagenMadera);
		panelCentro.add(panelCartaTiradaJ1);
		panelCartaTiradaJ1.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ1 = new JLabel("");
		cartaTiradaJ1.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaTiradaJ1.add(cartaTiradaJ1);
		
		puntosJ1 = new JLabel("");
		puntosJ1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntosJ1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ1.add(puntosJ1);
		
		panelCartaTiradaJ2 = new JPanelConFondo(imagenMadera);
		panelCentro.add(panelCartaTiradaJ2);
		panelCartaTiradaJ2.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ2 = new JLabel("");
		cartaTiradaJ2.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaTiradaJ2.add(cartaTiradaJ2);
		
		puntosJ2 = new JLabel("");
		puntosJ2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntosJ2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ2.add(puntosJ2);
		
		panelCartaTiradaJ3 = new JPanelConFondo(imagenMadera);
		panelCentro.add(panelCartaTiradaJ3);
		panelCartaTiradaJ3.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ3 = new JLabel("");
		cartaTiradaJ3.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		cartaTiradaJ3.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ3.add(cartaTiradaJ3);
		
		puntosJ3 = new JLabel("");
		puntosJ3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntosJ3.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ3.add(puntosJ3);
		
		panelCartaTiradaJ4 = new JPanelConFondo(imagenMadera);
		panelCentro.add(panelCartaTiradaJ4);
		panelCartaTiradaJ4.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ4 = new JLabel("");
		cartaTiradaJ4.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ4.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaTiradaJ4.add(cartaTiradaJ4);
		
		puntosJ4 = new JLabel("");
		puntosJ4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntosJ4.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ4.add(puntosJ4);
		
		panelCartaTiradaJ5 = new JPanelConFondo(imagenMadera);
		panelCentro.add(panelCartaTiradaJ5);
		panelCartaTiradaJ5.setLayout(new GridLayout(0, 2, 0, 0));
		
		cartaTiradaJ5 = new JLabel("");
		cartaTiradaJ5.setHorizontalAlignment(SwingConstants.CENTER);
		cartaTiradaJ5.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelCartaTiradaJ5.add(cartaTiradaJ5);
		
		puntosJ5 = new JLabel("");
		puntosJ5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntosJ5.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ5.add(puntosJ5);
		
		JPanel panelArrib = new JPanelConFondo(imagenMarron);
		FlowLayout fl_panelArrib = (FlowLayout) panelArrib.getLayout();
		fl_panelArrib.setVgap(0);
		fl_panelArrib.setHgap(0);
		contentPane.add(panelArrib, BorderLayout.NORTH);
		
		lblNotificaciones = new JLabel("");
		lblNotificaciones.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelArrib.add(lblNotificaciones);
		
		lblNotificacionFinal = new JLabel("");
		lblNotificacionFinal.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelArrib.add(lblNotificacionFinal);
		
		panelIzq = new JPanelConFondo(imagenMarron);
		contentPane.add(panelIzq, BorderLayout.WEST);
		panelIzq.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_Separador = new JPanelConFondo(imagenMarron);
		panelIzq.add(panel_Separador);
		
		jugador1 = new JLabel("");
		jugador1.setVerticalAlignment(SwingConstants.TOP);
		jugador1.setHorizontalAlignment(SwingConstants.LEFT);
		jugador1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelIzq.add(jugador1);
		
		jugador2 = new JLabel("");
		jugador2.setVerticalAlignment(SwingConstants.TOP);
		jugador2.setHorizontalAlignment(SwingConstants.LEFT);
		jugador2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelIzq.add(jugador2);
		
		jugador3 = new JLabel("");
		jugador3.setVerticalAlignment(SwingConstants.TOP);
		jugador3.setHorizontalAlignment(SwingConstants.LEFT);
		jugador3.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelIzq.add(jugador3);
		
		jugador4 = new JLabel("");
		jugador4.setVerticalAlignment(SwingConstants.TOP);
		jugador4.setHorizontalAlignment(SwingConstants.LEFT);
		jugador4.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelIzq.add(jugador4);
		
		jugador5 = new JLabel("");
		jugador5.setVerticalAlignment(SwingConstants.TOP);
		jugador5.setHorizontalAlignment(SwingConstants.LEFT);
		jugador5.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		panelIzq.add(jugador5);
		
		panelCartaTiradaJ1.setVisible(false);
		panelCartaTiradaJ2.setVisible(false);
		panelCartaTiradaJ3.setVisible(false);
		panelCartaTiradaJ4.setVisible(false);
		panelCartaTiradaJ5.setVisible(false);
		
		puntos_J1.setVisible(false);
		puntos_J2.setVisible(false);
		puntos_J3.setVisible(false);
		puntos_J4.setVisible(false);
		puntos_J5.setVisible(false);
		
	}
	public void onClickPedirCarta(ActionListener listener) {
		this.btnPedirCarta.addActionListener(listener);
	}
	public void onClickPaso(ActionListener listener) {
		this.btnMeQuedo.addActionListener(listener);
	}
	public void onClickIniciarJuego(ActionListener listener) {
		this.btnIniciarJuego.addActionListener(listener);
	}
	public static JRadioButton getSelection(ButtonGroup group)
	{
	        for (Enumeration<?> e=group.getElements(); e.hasMoreElements(); )
	        {
	            JRadioButton b = (JRadioButton)e.nextElement();
	            if (b.getModel() == group.getSelection())
	            {
	                return b;
	            }
	        }
	        return null;
	}
	
	public void setJugadores(ArrayList<String> jugadores) {
		//this.esconderTodosJug();
		for (int x=0;jugadores.size()>x;x++) {
			switch(x) {
			case 0:
				jugador1.setText(jugadores.get(x));
				lblNameJ1.setText(jugadores.get(x));
				panelCartaTiradaJ1.setVisible(true);
				puntos_J1.setVisible(true);
				break;
			case 1:
				jugador2.setText(jugadores.get(x));
				lblNameJ2.setText(jugadores.get(x));
				panelCartaTiradaJ2.setVisible(true);
				puntos_J2.setVisible(true);
				break;
			case 2:
				jugador3.setText(jugadores.get(x));
				lblNameJ3.setText(jugadores.get(x));
				panelCartaTiradaJ3.setVisible(true);
				puntos_J3.setVisible(true);
				break;
			case 3:
				jugador4.setText(jugadores.get(x));
				lblNameJ4.setText(jugadores.get(x));
				panelCartaTiradaJ4.setVisible(true);
				puntos_J4.setVisible(true);
				break;
			case 4:
				jugador5.setText(jugadores.get(x));
				lblNameJ5.setText(jugadores.get(x));
				panelCartaTiradaJ5.setVisible(true);
				puntos_J5.setVisible(true);
			}
		}
	}
	public void actualizarPuntos(ArrayList<IJugador> jugadores) {
		for (int x=0;jugadores.size()>x;x++) {
			switch(x) {
			case 0:
				lblPuntos_J1.setText(""+jugadores.get(x).getPuntos());
				break;
			case 1:
				lblPuntos_J2.setText(""+jugadores.get(x).getPuntos());
				break;
			case 2:
				lblPuntos_J3.setText(""+jugadores.get(x).getPuntos());
			break;
			case 3:
				lblPuntos_J4.setText(""+jugadores.get(x).getPuntos());
			break;
			case 4:
				lblPuntos_J5.setText(""+jugadores.get(x).getPuntos());
				break;
	}}}
	public void limpiarCartas() {
		cartaTiradaJ1.setText("");
		cartaTiradaJ2.setText("");
		cartaTiradaJ3.setText("");
		cartaTiradaJ4.setText("");
		cartaTiradaJ5.setText("");
	}
	public void mostrarCartas(ArrayList<IJugador> jugadores,String nombreTurno) throws IOException {
		String c="";
		for (int x=0;jugadores.size()>x;x++) {
			ArrayList<Carta> cartas1=jugadores.get(x).getCartas();
			 c=cartas1.get(cartas1.size()-1).toString();
			switch(x) {
			case 0:
				cartaTiradaJ1.setIcon(new ImageIcon(ImageIO.read(new File("src/Imagenes/"+c+".png")).getScaledInstance(60, 85, Image.SCALE_SMOOTH)));
				puntosJ1.setText(String.valueOf(jugadores.get(x).getPuntosParciales()));
				break;
			case 1:
				cartaTiradaJ2.setIcon(new ImageIcon(ImageIO.read(new File("src/Imagenes/"+c+".png")).getScaledInstance(60, 85, Image.SCALE_SMOOTH)));
				puntosJ2.setText(String.valueOf(jugadores.get(x).getPuntosParciales()));
				break;
			case 2:
				cartaTiradaJ3.setIcon(new ImageIcon(ImageIO.read(new File("src/Imagenes/"+c+".png")).getScaledInstance(60, 85, Image.SCALE_SMOOTH)));
				puntosJ3.setText(String.valueOf(jugadores.get(x).getPuntosParciales()));
				break;
			case 3:
				cartaTiradaJ4.setIcon(new ImageIcon(ImageIO.read(new File("src/Imagenes/"+c+".png")).getScaledInstance(60, 85, Image.SCALE_SMOOTH)));
				puntosJ4.setText(String.valueOf(jugadores.get(x).getPuntosParciales()));
				break;
			case 4:
				cartaTiradaJ5.setIcon(new ImageIcon(ImageIO.read(new File("src/Imagenes/"+c+".png")).getScaledInstance(60, 85, Image.SCALE_SMOOTH)));
				puntosJ5.setText(String.valueOf(jugadores.get(x).getPuntosParciales()));
				break;
			}}
		}
	public void esperarJugandoOponente(String nombreTurno) {
		setTitle("Raya(TURNO OPONENTE, "+nombreTurno+")");
		btnIniciarJuego.setVisible(false);
		btnPedirCarta.setVisible(false);
		btnMeQuedo.setVisible(false);
	}
	public void turnoActual(String nombreTurno) {
		setTitle("Raya(TURNO ACTUAL, "+nombreTurno+")");
		btnIniciarJuego.setVisible(false);
		btnPedirCarta.setVisible(true);
		btnMeQuedo.setVisible(true);
	}
	public void notifRaya () {
		lblNotificaciones.setVisible(true);
		lblNotificaciones.setText("TE SALIO UNA RAYA :(");;
	}
	public void ocultarNotificaciones() {
		lblNotificaciones.setVisible(false);
		lblNotificaciones.setText("");
	}
	public void laManoTermino() {
		lblNotificaciones.setVisible(true);
		lblNotificaciones.setText("La mano termino");
		this.btnMeQuedo.setVisible(false);
		this.btnPedirCarta.setVisible(false);
	}
	public void botonRepartir() {
		btnIniciarJuego.setVisible(true);
		btnPedirCarta.setVisible(false);
		btnMeQuedo.setVisible(false);
		btnIniciarJuego.setText("Repartir");
	}
	public void juegoTerminado(String ganador) {
		lblNotificacionFinal.setText("El juego termino, el ganador es "+ ganador);
		lblNotificaciones.setVisible(true);}
	public boolean jugadoresCargados() {
		return !(jugador1.getText().equals(""));
	}
	
	public void mostrarJugadores(ArrayList<IJugador> darJugadores) {
		String jugadores="";
		for (int i=0;i<darJugadores.size();i++) {
				jugadores+=darJugadores.get(i).getNombre();
			if (i!=darJugadores.size()-1) {
				jugadores+=", ";
			}
		}
		//for (IJugador jug :darJugadores) {
		//	jugadores+=jug.getNombre()+", ";
		//}
		lblNotificaciones.setVisible(true);
		this.lblNotificaciones.setText("Jugadores agregados: "+jugadores);
	}
	public void yaPuedeEmpezar() {
		this.btnIniciarJuego.setVisible(true);
	}
	}
