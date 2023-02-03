package vista.grafica;
import modelo.EstadoTruco;
import modelo.IJuego;
import modelo.IJugador;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnEnvido;
	private JButton btnRealEnvido;
	private JButton btnFaltaEnvido;
	private JButton btnTruco;
	private JButton btnReTruco;
	private JButton btnValeCuatro;
	private JButton btnQuiero;
	private JButton btnNoQuiero;
	private JButton btnMazo;
	private JButton btnTirarCarta;
	private JRadioButton carta3;
	private ButtonGroup grupo;
	private JLabel cartasTiradasJ2;
	private JLabel cartaTiradaJ2_1;
	private JLabel cartaTiradaJ2_2;
	private JLabel cartaTiradaJ2_3;
	private JLabel cartaTiradaJ1_1;
	private JLabel cartaTiradaJ1_2;
	private JLabel cartaTiradaJ1_3;
	private JLabel ronda1;
	private JLabel ronda2;
	private JLabel ronda3;
	private JLabel lblResultadoRonda1;
	private JLabel lblResultadoRonda2;
	private JLabel lblResultadoRonda3;
	private JLabel lblNameJugador2;
	private JLabel lblPuntosJ2;
	private JLabel lblNameJugador1;
	private JLabel lblPuntosJ1;
	private JPanel panelBajo_Cartas;
	private JLabel lblNotificaciones;
	private JLabel lblNotificacionFinal;
	private JPanel panelC1;
	private JPanel panelC2;
	private JPanel panelC3;
	private JRadioButton carta1;
	private JRadioButton carta2;
	private JLabel lblCarta1;
	private JLabel lblCarta2;
	private JLabel lblCarta3;
	private JPanel panelRadioBt1;
	private JPanel panelRadioBt2;
	private JPanel panelRadioBt3;
	private JPanel panel_Separador;
	public VentanaPrincipal(){
		Image imagenVerde = null;
		Image imagenMarron = null;
		try {
			imagenVerde = ImageIO.read(new File("src/Imagenes/FondoVerde.png"));
			imagenMarron = ImageIO.read(new File("src/Imagenes/FondoMarron.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("Truco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanelConFondo(imagenMarron);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panelDerecha = new JPanel();
		contentPane.add(panelDerecha, BorderLayout.EAST);
		panelDerecha.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelPuntosArriba = new JPanelConFondo(imagenMarron);
		panelDerecha.add(panelPuntosArriba);
		panelPuntosArriba.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Puntos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentY(2.0f);
		lblNewLabel.setAlignmentX(0.5f);
		panelPuntosArriba.add(lblNewLabel, BorderLayout.NORTH);
    	
		JPanel panelPuntosAbajo = new JPanelConFondo(imagenMarron);
		panelPuntosArriba.add(panelPuntosAbajo, BorderLayout.CENTER);
		panelPuntosAbajo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanelConFondo(imagenMarron);
		panelPuntosAbajo.add(panel_3, BorderLayout.NORTH);
		
		JPanel panelPuntosJ2 = new JPanelConFondo(imagenMarron);
		panel_3.add(panelPuntosJ2);
		panelPuntosJ2.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNameJugador2 = new JLabel("");
		lblNameJugador2.setVerticalAlignment(SwingConstants.TOP);
		lblNameJugador2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNameJugador2.setAlignmentY(0.0f);
		panelPuntosJ2.add(lblNameJugador2);
		
		lblPuntosJ2 = new JLabel("0");
		lblPuntosJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosJ2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPuntosJ2.add(lblPuntosJ2);
		
		JPanel panelPuntosJ1 = new JPanelConFondo(imagenMarron);
		panel_3.add(panelPuntosJ1);
		panelPuntosJ1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNameJugador1 = new JLabel("");
		lblNameJugador1.setVerticalAlignment(SwingConstants.TOP);
		lblNameJugador1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNameJugador1.setAlignmentY(2.0f);
		lblNameJugador1.setAlignmentX(0.5f);
		panelPuntosJ1.add(lblNameJugador1);
		
		lblPuntosJ1 = new JLabel("0");
		lblPuntosJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosJ1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPuntosJ1.add(lblPuntosJ1);
		
		JPanel panelAbajo_Cantos = new JPanelConFondo(imagenMarron);
		panelDerecha.add(panelAbajo_Cantos);
		panelAbajo_Cantos.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnEnvido = new JButton("Envido");
		panelAbajo_Cantos.add(btnEnvido);
		
		btnRealEnvido = new JButton("Real envido");
		panelAbajo_Cantos.add(btnRealEnvido);
		
		btnFaltaEnvido = new JButton("Falta envido");
		panelAbajo_Cantos.add(btnFaltaEnvido);
		
		btnTruco = new JButton("Truco");
		panelAbajo_Cantos.add(btnTruco);
		
		btnReTruco = new JButton("Re truco");
		panelAbajo_Cantos.add(btnReTruco);
		
		btnValeCuatro = new JButton("Vale cuatro");
		panelAbajo_Cantos.add(btnValeCuatro);
		
		btnQuiero = new JButton("Quiero");
		panelAbajo_Cantos.add(btnQuiero);
		
		btnNoQuiero = new JButton("No quiero");
		panelAbajo_Cantos.add(btnNoQuiero);
		
		btnMazo = new JButton("Mazo");
		panelAbajo_Cantos.add(btnMazo);
		
		panelBajo_Cartas = new JPanelConFondo(imagenMarron);
		FlowLayout flowLayout = (FlowLayout) panelBajo_Cartas.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		contentPane.add(panelBajo_Cartas, BorderLayout.SOUTH);
		grupo= new ButtonGroup();
			
		panelC1 = new JPanelConFondo(imagenMarron);
		panelBajo_Cartas.add(panelC1);
		panelC1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCarta1 = new JLabel("");
		lblCarta1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				carta1.setSelected(true);
			}
		});
		lblCarta1.setHorizontalAlignment(SwingConstants.CENTER);
		panelC1.add(lblCarta1);
		
		panelRadioBt1 = new JPanelConFondo(imagenMarron);
		panelC1.add(panelRadioBt1);
		
		carta1 = new JRadioButton("");
		carta1.setVerticalAlignment(SwingConstants.BOTTOM);
		panelRadioBt1.add(carta1);
		carta1.setHorizontalAlignment(SwingConstants.CENTER);
		grupo.add(carta1);
		
		panelC2 = new JPanelConFondo(imagenMarron);
		panelBajo_Cartas.add(panelC2);
		panelC2.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCarta2 = new JLabel("");
		lblCarta2.setHorizontalAlignment(SwingConstants.CENTER);
		panelC2.add(lblCarta2);
		
		panelRadioBt2 = new JPanelConFondo(imagenMarron);
		panelC2.add(panelRadioBt2);
		
		carta2 = new JRadioButton("");
		carta2.setVerticalAlignment(SwingConstants.BOTTOM);
		panelRadioBt2.add(carta2);
		carta2.setHorizontalAlignment(SwingConstants.CENTER);
		grupo.add(carta2);
		lblCarta2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				carta2.setSelected(true);
			}
		});
		
		panelC3 = new JPanelConFondo(imagenMarron);
		panelBajo_Cartas.add(panelC3);
		panelC3.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCarta3 = new JLabel("");
		lblCarta3.setHorizontalAlignment(SwingConstants.CENTER);
		panelC3.add(lblCarta3);
		
		panelRadioBt3 = new JPanelConFondo(imagenMarron);
		panelC3.add(panelRadioBt3);
		carta3 = new JRadioButton("");
		carta3.setVerticalAlignment(SwingConstants.BOTTOM);
		panelRadioBt3.add(carta3);
		carta3.setHorizontalAlignment(SwingConstants.CENTER);
		grupo.add(carta3);
		lblCarta3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				carta3.setSelected(true);
			}
		});
		btnTirarCarta = new JButton("Tirar Carta");
		
		panelBajo_Cartas.add(btnTirarCarta);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelCartasTiradasIzq = new JPanel();
		panelCentro.add(panelCartasTiradasIzq);
		panelCartasTiradasIzq.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelCartasTiradasJ1 = new JPanelConFondo(imagenMarron);
		panelCartasTiradasIzq.add(panelCartasTiradasJ1);
		panelCartasTiradasJ1.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_Separador = new JPanelConFondo(imagenMarron);
		panelCartasTiradasJ1.add(panel_Separador);
		
		JLabel cartasTiradasJ1 = new JLabel("Tus cartas tiradas");
		cartasTiradasJ1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartasTiradasJ1.add(cartasTiradasJ1);
		
		JPanel panelCartaTiradaJ1_1 = new JPanelConFondo(imagenVerde);
		panelCartasTiradasIzq.add(panelCartaTiradaJ1_1);
		panelCartaTiradaJ1_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanelConFondo(imagenMarron);
		panelCartaTiradaJ1_1.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		ronda1 = new JLabel("Ronda 1");
		panel.add(ronda1);
		ronda1.setVerticalAlignment(SwingConstants.TOP);
		ronda1.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblResultadoRonda1 = new JLabel("");
		lblResultadoRonda1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblResultadoRonda1);
		
		cartaTiradaJ1_1 = new JLabel("");
		cartaTiradaJ1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ1_1.add(cartaTiradaJ1_1);
		
		JPanel panelCartaTiradaJ1_2 = new JPanelConFondo(imagenVerde);
		panelCartasTiradasIzq.add(panelCartaTiradaJ1_2);
		panelCartaTiradaJ1_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanelConFondo(imagenMarron);
		panelCartaTiradaJ1_2.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		ronda2 = new JLabel("Ronda 2");
		panel_1.add(ronda2);
		ronda2.setVerticalAlignment(SwingConstants.TOP);
		ronda2.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblResultadoRonda2 = new JLabel("");
		lblResultadoRonda2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblResultadoRonda2);
		
		cartaTiradaJ1_2 = new JLabel("");
		cartaTiradaJ1_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ1_2.add(cartaTiradaJ1_2);
		
		JPanel panelCartaTiradaJ1_3 = new JPanelConFondo(imagenVerde);
		panelCartasTiradasIzq.add(panelCartaTiradaJ1_3);
		panelCartaTiradaJ1_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanelConFondo(imagenMarron);
		panelCartaTiradaJ1_3.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		ronda3 = new JLabel("Ronda 3");
		panel_2.add(ronda3);
		ronda3.setVerticalAlignment(SwingConstants.TOP);
		ronda3.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblResultadoRonda3 = new JLabel("");
		lblResultadoRonda3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblResultadoRonda3);
		
		cartaTiradaJ1_3 = new JLabel("");
		cartaTiradaJ1_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ1_3.add(cartaTiradaJ1_3);
		
		JPanel panelCartasTiradaDer = new JPanel();
		panelCentro.add(panelCartasTiradaDer);
		panelCartasTiradaDer.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelCartasTiradasJ2 = new JPanelConFondo(imagenMarron);
		panelCartasTiradaDer.add(panelCartasTiradasJ2);
		panelCartasTiradasJ2.setLayout(new GridLayout(0, 1, 0, 0));
		
		cartasTiradasJ2 = new JLabel("Cartas tiradas del oponente");
		cartasTiradasJ2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartasTiradasJ2.add(cartasTiradasJ2);
		
		JPanel panelCartaTiradaJ2_1 = new JPanelConFondo(imagenVerde);
		panelCartasTiradaDer.add(panelCartaTiradaJ2_1);
		panelCartaTiradaJ2_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		cartaTiradaJ2_1 = new JLabel("");
		cartaTiradaJ2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ2_1.add(cartaTiradaJ2_1);
		
		JPanel panelCartaTiradaJ2_2 = new JPanelConFondo(imagenVerde);
		panelCartasTiradaDer.add(panelCartaTiradaJ2_2);
		panelCartaTiradaJ2_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		cartaTiradaJ2_2 = new JLabel("");
		cartaTiradaJ2_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ2_2.add(cartaTiradaJ2_2);
		
		JPanel panelCartaTiradaJ2_3 = new JPanelConFondo(imagenVerde);
		panelCartasTiradaDer.add(panelCartaTiradaJ2_3);
		panelCartaTiradaJ2_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		cartaTiradaJ2_3 = new JLabel("");
		cartaTiradaJ2_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelCartaTiradaJ2_3.add(cartaTiradaJ2_3);
		
		JPanel panelArriba = new JPanelConFondo(imagenMarron);
		FlowLayout flowLayout_1 = (FlowLayout) panelArriba.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		contentPane.add(panelArriba, BorderLayout.NORTH);
		
		lblNotificaciones = new JLabel("");
		panelArriba.add(lblNotificaciones);
		
		lblNotificacionFinal = new JLabel("");
		panelArriba.add(lblNotificacionFinal);
	}
	public void onClickTirarCarta(ActionListener listener) {
		this.btnTirarCarta.addActionListener(listener);
	}
	public void onClickEnvido(ActionListener listener) {
		this.btnEnvido.addActionListener(listener);
	}
	public void onClickRealEnvido(ActionListener listener) {
		this.btnRealEnvido.addActionListener(listener);
	}
	public void onClickFaltaEnvido(ActionListener listener) {
		this.btnFaltaEnvido.addActionListener(listener);
	}
	public void onClickMazo(ActionListener listener) {
		this.btnMazo.addActionListener(listener);
	}
	public void onClickTruco(ActionListener listener) {
		this.btnTruco.addActionListener(listener);
	}
	public void onClickReTruco(ActionListener listener) {
		this.btnReTruco.addActionListener(listener);
	}
	public void onClickValeCuatro(ActionListener listener) {
		this.btnValeCuatro.addActionListener(listener);
	}
	public void onClickQuiero(ActionListener listener) {
		this.btnQuiero.addActionListener(listener);
	}
	public void onClickNoQuiero(ActionListener listener) {
		this.btnNoQuiero.addActionListener(listener);
	}
	public static JRadioButton getSelection(ButtonGroup group)
	{
	        for (Enumeration e=group.getElements(); e.hasMoreElements(); )
	        {
	            JRadioButton b = (JRadioButton)e.nextElement();
	            if (b.getModel() == group.getSelection())
	            {
	                return b;
	            }
	        }
	        return null;
	}
	public void setJugadores(String jug1,String jug2) {
		lblNameJugador1.setText(jug1);
		lblNameJugador2.setText(jug2);
	}
	public void actualizarPuntos(int jug1,int jug2) {
		lblPuntosJ1.setText(Integer.toString(jug1));
		lblPuntosJ2.setText(Integer.toString(jug2));
	}
	public void botonesComienzo() {
		btnEnvido.setVisible(true);
		btnRealEnvido.setVisible(true);
		btnFaltaEnvido.setVisible(true);
		btnTruco.setVisible(true);
		btnMazo.setVisible(true);
		btnTirarCarta.setVisible(true);
		
		btnReTruco.setVisible(false);
		btnValeCuatro.setVisible(false);
		btnQuiero.setVisible(false);
		btnNoQuiero.setVisible(false);
	}
	public void limpiarVista() {
		lblResultadoRonda1.setText("");
		lblResultadoRonda2.setText("");
		lblResultadoRonda3.setText("");
		
		cartaTiradaJ1_1.setText("");
		cartaTiradaJ1_2.setText("");
		cartaTiradaJ1_3.setText("");
		cartaTiradaJ2_1.setText("");
		cartaTiradaJ2_2.setText("");
		cartaTiradaJ2_3.setText("");
		cartaTiradaJ1_1.setIcon(null);
		cartaTiradaJ1_2.setIcon(null);
		cartaTiradaJ1_3.setIcon(null);
		cartaTiradaJ2_1.setIcon(null);
		cartaTiradaJ2_2.setIcon(null);
		cartaTiradaJ2_3.setIcon(null);
	}
	public void mostrarCartas(ArrayList<String> cartas) throws IOException {
		String c1;String c2;String c3;
		switch(cartas.size()) {
		case 3:
			carta3.setVisible(true);
			c3=cartas.get(2);
			lblCarta3.setVisible(true);
			lblCarta3.setIcon(new ImageIcon(ImageIO.read(new File("src/Imagenes/"+c3+".png")).getScaledInstance(70, 100, Image.SCALE_SMOOTH)));
			carta3.setText(c3);
		case 2:
			carta2.setVisible(true);
			c2=cartas.get(1);
			lblCarta2.setVisible(true);
			lblCarta2.setIcon(new ImageIcon(ImageIO.read(new File("src/Imagenes/"+c2+".png")).getScaledInstance(70, 100, Image.SCALE_SMOOTH)));
			carta2.setText(c2);
		case 1:
			carta1.setVisible(true);
			c1=cartas.get(0);
			lblCarta1.setVisible(true);
			lblCarta1.setIcon(new ImageIcon(ImageIO.read(new File("src/Imagenes/"+c1+".png")).getScaledInstance(70, 100, Image.SCALE_SMOOTH)));
			carta1.setText(c1);
		}
	}
	public void esperarJugandoOponente(String nombreTurno) {
		setTitle("Truco(TURNO OPONENTE, "+nombreTurno+")");
		btnEnvido.setVisible(false);
		btnRealEnvido.setVisible(false);
		btnFaltaEnvido.setVisible(false);
		btnTruco.setVisible(false);
		btnReTruco.setVisible(false);
		btnValeCuatro.setVisible(false);
		btnQuiero.setVisible(false);
		btnNoQuiero.setVisible(false);
		btnMazo.setVisible(false);
		btnTirarCarta.setVisible(false);
		carta1.setVisible(false);
		carta2.setVisible(false);
		carta3.setVisible(false);
		lblCarta1.setVisible(false);
		lblCarta2.setVisible(false);
		lblCarta3.setVisible(false);
	}
	public void turnoActual(String trucoPuedeCantar,String nombreTurno) {
		setTitle("Truco(TURNO ACTUAL, "+nombreTurno+")");
		btnQuiero.setVisible(false);
		btnNoQuiero.setVisible(false);
			switch(trucoPuedeCantar) {
			case "Truco":
				btnTruco.setVisible(true);
				break;
			case "Re truco":
				btnReTruco.setVisible(true);
				break;
			case "Vale cuatro":
				btnValeCuatro.setVisible(true);
				;
			}
		btnMazo.setVisible(true);
		btnTirarCarta.setVisible(true);
	}
	public void mostrarBotonesEnvido() {
		btnEnvido.setVisible(true);
		btnRealEnvido.setVisible(true);
		btnFaltaEnvido.setVisible(true);
	}
	public int getCartaSeleccionada() throws IOException {
		JRadioButton seleccionado=getSelection(grupo);
		int retornar=0;
		if (seleccionado==carta1) {
			retornar=1;
		}else if(seleccionado==carta2){
			retornar=2;
		}else if(seleccionado==carta3){ 
			retornar=3;
		}
		if (!carta3.isVisible()) {
			carta2.setVisible(false);
			this.lblCarta2.setIcon(null);;
		}
		carta3.setVisible(false);
		this.lblCarta3.setIcon(null);
		ImageIcon iconCarta=new ImageIcon(ImageIO.read(new File("src/Imagenes/"+seleccionado.getText()+".png")).getScaledInstance(50, 80, Image.SCALE_SMOOTH));
		if (cartaTiradaJ1_1.getIcon()==null) {
			cartaTiradaJ1_1.setText(seleccionado.getText());
			cartaTiradaJ1_1.setIcon(iconCarta);}
		else if(cartaTiradaJ1_2.getIcon()==null) {
			cartaTiradaJ1_2.setText(seleccionado.getText());
			cartaTiradaJ1_2.setIcon(iconCarta);}
		else if (cartaTiradaJ1_3.getIcon()==null) {
			cartaTiradaJ1_3.setText(seleccionado.getText());
			cartaTiradaJ1_3.setIcon(iconCarta);}
		return retornar;
		
	}
	public boolean jugadoresCargados() {
		return !(lblNameJugador1.getText().equals("") && lblNameJugador2.getText().equals(""));
	}
	public void mostrarCartaTirada(String cartaTirada) throws IOException {
		ImageIcon iconCarta=new ImageIcon(ImageIO.read(new File("src/Imagenes/"+cartaTirada+".png")).getScaledInstance(50, 80, Image.SCALE_SMOOTH));
		if(noEsNingunaQueYoTire(cartaTirada)&&noEsNingunaQueContraTiro(cartaTirada)) {
			if (cartaTiradaJ2_1.getIcon() == null) {
				cartaTiradaJ2_1.setText(cartaTirada);
				cartaTiradaJ2_1.setIcon(iconCarta);}
			else if(cartaTiradaJ2_2.getIcon() == null) {
				cartaTiradaJ2_2.setText(cartaTirada);
				cartaTiradaJ2_2.setIcon(iconCarta);}
			else if (cartaTiradaJ2_3.getIcon() == null) {
				cartaTiradaJ2_3.setText(cartaTirada);
				cartaTiradaJ2_3.setIcon(iconCarta);}
	}}
	private boolean noEsNingunaQueContraTiro(String cartaTirada) {
		return (!(cartaTirada.equals(cartaTiradaJ2_1.getText()))&&!(cartaTirada.equals(cartaTiradaJ2_2.getText()))&&!(cartaTirada.equals(cartaTiradaJ2_3.getText())));
	}
	private boolean noEsNingunaQueYoTire(String cartaTirada) {
		return (!(cartaTirada.equals(cartaTiradaJ1_1.getText()))&&!(cartaTirada.equals(cartaTiradaJ1_2.getText()))&&!(cartaTirada.equals(cartaTiradaJ1_3.getText())));
	}
	public void ganoRonda() {
		if (lblResultadoRonda1.getText().equals("")) {
			lblResultadoRonda1.setText("Ganaste la ronda");}
		else if (lblResultadoRonda2.getText().equals("")) {
			lblResultadoRonda2.setText("Ganaste la ronda");}
		else if (lblResultadoRonda3.getText().equals("")&&cartaTiradaJ1_3.getText()!="") {
			lblResultadoRonda3.setText("Ganaste la ronda");}
	}
	public void perdioRonda() {
		if (lblResultadoRonda1.getText().equals("")) {
			lblResultadoRonda1.setText("Perdiste la ronda");}
		else if (lblResultadoRonda2.getText().equals("")) {
			lblResultadoRonda2.setText("Perdiste la ronda");}
		else if (lblResultadoRonda3.getText().equals("")&&cartaTiradaJ1_3.getText()!="") {
			lblResultadoRonda3.setText("Perdiste la ronda");}
	}
	public void pardaRonda() {
		if (lblResultadoRonda1.getText().equals("")) {
			lblResultadoRonda1.setText("Ronda parda");
			lblResultadoRonda2.setText("Segunda define");}
		else if (lblResultadoRonda2.getText().equals("")) {
			lblResultadoRonda2.setText("Ronda parda");}
		else if (lblResultadoRonda3.getText().equals("")&&cartaTiradaJ1_3.getText()!="") {
			lblResultadoRonda3.setText("Ronda parda");}
	}
	public boolean isPrimeraRonda() {
		return cartaTiradaJ1_1.getText().equals("");
	}
	public void notificarCanto(String string) {
		lblNotificaciones.setVisible(true);
		lblNotificaciones.setText("El contrario canto "+string.toLowerCase());
	}
	public void mostrarBotonesEnvido(ArrayList<String> puedeCantar) {
		btnTirarCarta.setVisible(false);
		btnQuiero.setVisible(true);
		btnNoQuiero.setVisible(true);
		for(String canto :puedeCantar) {
			if (canto.equals(btnEnvido.getText())) {
				btnEnvido.setVisible(true);}
			if (canto.equals(btnRealEnvido.getText())) {
				btnRealEnvido.setVisible(true);}
			if (canto.equals(btnFaltaEnvido.getText())) {
				btnFaltaEnvido.setVisible(true);}
		}
	}
	public void ocultarBotonesEnvido() {
		btnEnvido.setVisible(false);
		btnRealEnvido.setVisible(false);
		btnFaltaEnvido.setVisible(false);
	}
	public void mostrarBotonesTruco(boolean puedeCantarEnvido) {
		if (puedeCantarEnvido) {
			btnEnvido.setVisible(true);
			btnRealEnvido.setVisible(true);
			btnFaltaEnvido.setVisible(true);
		}
		btnQuiero.setVisible(true);
		btnNoQuiero.setVisible(true);
	}
	public void ocultarBotonesTruco() {
		ocultarNotificaciones();
	}
	public void ocultarNotificaciones() {
		lblNotificaciones.setVisible(false);
	}
	public void mostrarGanadorEnvido(String nombre,Integer p1, Integer p2) {
		lblNotificaciones.setText( "El ganador del tanto es "+nombre+". Los tantos fueron :"+p1+", "+p2+". ");
		lblNotificaciones.setVisible(true);
	}
	public void laManoTermino() {
		lblNotificaciones.setText( "La mano termino");
	}
	public void juegoTerminado(String ganador) {
		lblNotificacionFinal.setText("El juego termino, el ganador es "+ ganador);
		this.panelBajo_Cartas.setVisible(false);	}
	public void pedirDeNuevoCarta() {
		this.lblNotificaciones.setVisible(true);
		lblNotificaciones.setText( "Selecciona una carta para tirar");
		
	}
}
