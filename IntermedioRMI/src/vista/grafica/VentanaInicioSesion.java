package vista.grafica;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	private JButton btnIngresarDin;
	private JButton btnSiguiente;
	private JLabel lblIndicaciones;
	private JPanel panel_1;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblAdvertencia;
	private JPanel panel_5;
	private JTextField textUsuario;
	private JFormattedTextField textDinero;
	protected JButton btnVerRanking;
	/**
	 * Create the frame.
	 */
	public VentanaInicioSesion() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 149);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "", "[][grow]"));
		
		btnSiguiente = new JButton("Agregar jugador");
		contentPane.add(btnSiguiente, "flowx,cell 0 1");
		SwingUtilities.getRootPane(btnSiguiente).setDefaultButton(btnSiguiente);
		
		btnIngresarDin = new JButton("Ingresar dinero");
		contentPane.add(btnIngresarDin, "cell 0 1");
		btnIngresarDin.setVisible(false);	
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 0");
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		lblIndicaciones = new JLabel("Ingrese usuario");
		panel_2.add(lblIndicaciones);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		lblAdvertencia = new JLabel("Se le quitaran $100 para iniciar el pozo");
		panel_3.add(lblAdvertencia);
		lblAdvertencia.setVisible(false);
		
		panel = new JPanel();
		contentPane.add(panel, "cell 1 0");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_5 = new JPanel();
		panel.add(panel_5);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		panel_5.add(textUsuario);
		
		textDinero = new JFormattedTextField(new Integer(0));
		textDinero.setColumns(5); 
		panel_5.add(textDinero);
		btnVerRanking = new JButton("Ver ranking");
		contentPane.add(btnVerRanking, "cell 1 1");
		textDinero.setVisible(false);
		textDinero.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Simula el clic en el botón cuando se presiona enter.
		        btnIngresarDin.doClick();
		    }
		});
	}
	public void onClickVerRanking(ActionListener listener) {
		this.btnVerRanking.addActionListener(listener);
	}
	public void onClickIngresarDin(ActionListener listener) {
		this.btnIngresarDin.addActionListener(listener);
	}
	public void onClickSiguiente(ActionListener listener) {
		this.btnSiguiente.addActionListener(listener);
	}
	public String getTextUsuario() {
		return this.textUsuario.getText();
	}
	public int getDinero() {
		return (int) this.textDinero.getValue();
	}
	public void nombreRepetido() {
		this.lblIndicaciones.setText("Ingrese usuario(El nombre de usuario ya esta usado)");
	}
	public void ingresarDin() {
		lblIndicaciones.setVisible(true);
		lblIndicaciones.setText("Ingrese la cantidad de dinero que desea cargar($)");
		lblAdvertencia.setVisible(true);
		lblAdvertencia.setText("(Se le quitaran $100 para inicializar el pozo)");
		btnIngresarDin.setVisible(true);
		textDinero.setVisible(true);
		textDinero.setText("0");
		textUsuario.setVisible(false);
		
		SwingUtilities.getRootPane(btnIngresarDin).setDefaultButton(btnIngresarDin);
		btnSiguiente.setVisible(false);
		
	}
	public void dineroInvalido() {
		lblAdvertencia.setText("Cantidad insuficiente(Se le quitan $100 para inicializar el pozo)");
		
	}
	public void pedirIngresoPozo(int dineroDispo,String jugador) {
		lblIndicaciones.setText("Su saldo es: "+dineroDispo);
		lblAdvertencia.setText("El pozo quedo en $0 (Se le quitan $100 nuevamente)");
		btnIngresarDin.setText("Seguir jugando");
		textDinero.setText("0");
		setTitle(jugador);
	}
}
